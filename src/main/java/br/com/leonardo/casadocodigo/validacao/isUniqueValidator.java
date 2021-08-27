package br.com.leonardo.casadocodigo.validacao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class isUniqueValidator implements ConstraintValidator <isUnique, Object>{
    private String campo;
    private Class<?> classe;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(isUnique params) {
        campo = params.fieldName();
        classe = params.domainClass();
    }
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("Select 1 From " + classe.getName() +" WHERE "+ campo +"=:value" );
        query.setParameter("value", value);
        System.out.println(query);
        List<?> list = query.getResultList();
        return list.isEmpty();
    }
}
