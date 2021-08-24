package br.com.leonardo.casadocodigo.validação;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//Onde é usada
@Target({FIELD})
//quando é criada
@Retention(RUNTIME)
//Classe no qual faz a validação
@Constraint(validatedBy = ValidarEmailDuplicadoValidator.class)


// CLasse que representa a annotation e  "chama" a classe que realiza a validação
public @interface ValidarEmailDuplicado {

    //Mensagem de erro caso não for alterada na anotação
    String message() default "Ja existe esse email cadastrado no banco de dados";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

        //valor padrão caso não for passado nenhum valor na variavel
        String value() default "";
        }
