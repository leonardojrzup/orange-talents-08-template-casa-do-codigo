package br.com.leonardo.casadocodigo.annotations;

import br.com.leonardo.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidarEmailDuplicadoValidator implements ConstraintValidator<ValidarEmailDuplicado,String> {
    String email;
    @Autowired
    AutorRepository autorRepository;

    @Override
    public void initialize(ValidarEmailDuplicado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(autorRepository.findByEmail(value) != null){
            return false;
        }else {
            return true;
        }
    }
}
