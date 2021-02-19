package br.com.orangetalents.casadocodigo.paiseseestados.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {UniqueEstadoPaisValidator.class})
public @interface UniqueEstadoPais {
    String message() default "{br.com.orangetalents.beanvalidation.uniqueestadopais.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName1();

    String fieldName2();

    Class<?> domainClass();
}
