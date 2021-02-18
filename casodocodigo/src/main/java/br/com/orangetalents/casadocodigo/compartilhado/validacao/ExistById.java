package br.com.orangetalents.casadocodigo.compartilhado.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = {ExistByIdValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistById {
    String message() default "{br.com.orangetalents.beanvalidation.existbyid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
