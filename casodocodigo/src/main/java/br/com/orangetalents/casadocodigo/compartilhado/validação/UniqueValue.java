package br.com.orangetalents.casadocodigo.compartilhado.validação;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
    String message () default "{br.com.orangetalents.beanvalidation.uniquevalue}";
    Class<?>[] groups() default {};
    Class <? extends Payload> [] payload() default {};
    String fieldName ();
    Class<?> domainClass();
}
