package br.com.orangetalents.casadocodigo.compartilhado.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistByIdValidator implements ConstraintValidator<ExistById, Object> {

    @PersistenceContext
    EntityManager em;

    private String domainAttribute;
    private Class<?> klass;

    @Override
    public void initialize(ExistById id) {
        domainAttribute = id.fieldName();
        klass = id.domainClass();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = em.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + domainAttribute + "=:value");
        query.setParameter("value", value);

        if (value == null) {
            return false;
        }

        List<?> list = query.getResultList();

        return !list.isEmpty();
    }
}
