package br.com.leonardo.casadocodigo.validacao;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
//quando é criada
@Retention(RUNTIME)
//Classe no qual faz a validação
@Constraint(validatedBy = ValidarEmailDuplicadoValidator.class)

public @interface ValidarEmailDuplicado {
    //Mensagem de erro caso não for alterada na anotação
    String message() default "Ja existe esse email cadastrado no banco de dados";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //valor padrão caso não for passado nenhum valor na variavel
    String value() default "";


}
