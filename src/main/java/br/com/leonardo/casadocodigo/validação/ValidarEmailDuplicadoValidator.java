package br.com.leonardo.casadocodigo.validação;

import br.com.leonardo.casadocodigo.repositorio.AutorRepository;
import br.com.leonardo.casadocodigo.validação.ValidarEmailDuplicado;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


//Classe que implementa a validação se o email ja existe no banco de dados

public class ValidarEmailDuplicadoValidator implements ConstraintValidator<ValidarEmailDuplicado, String> {
    private String email;
    @Autowired
    AutorRepository autorRepository;


    //metodo de inicialição da anotação
    @Override
    public void initialize(ValidarEmailDuplicado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    //Validação onde caso o email seja encontrado no banco de dados vai retornar o erro, não foi validado se a string é nula pois a validação da fomatação do email realiza esse processo
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {


        //essa validação pode ser realizada atravpes do EntityManager, porém devido a facilidade foi usada através de um repository
        if(autorRepository.findByEmail(email) != null) {
            return false;
        } else {
            return true;
        }

    }

}

