package br.com.leonardo.casadocodigo.annotations;

import br.com.leonardo.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidarNomeDuplicadoValidator implements ConstraintValidator<ValidarNomeDuplicado,String> {
    private String nome;
    @Autowired
    CategoriaRepository categoriaRepository;

    //metodo de inicialição da anotação
    @Override
    public void initialize(ValidarNomeDuplicado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    //Validação onde caso o nome seja encontrado no banco de dados vai retornar o erro, não foi validado se a string é nula pois a validação da fomatação do email realiza esse processo
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        //essa validação pode ser realizada através do EntityManager, porém devido a facilidade foi usada através de um repository
        if(categoriaRepository.findByNome(email) != null) {
            return false;
        } else {
            return true;
        }
    }
}
