/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.business.services;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.internal.jpa.querydef.CriteriaBuilderImpl;
import smartchoice.data.daos.CompanyDAO;
import smartchoice.data.models.Company;

/**
 *
 * @author TNT
 */
public class CompanyService {

    protected CompanyDAO companyDAO;
    protected EntityManager entityManager;

    public CompanyService(EntityManager entityManager, CompanyDAO companyDAO) {
        this.entityManager = entityManager;
        this.companyDAO = companyDAO;
    }

    public Company createCompany(Company entity) {
        return companyDAO.create(entity);
    }

    public boolean nameExists(String name) {
        CriteriaBuilder builder = new CriteriaBuilderImpl(entityManager.getMetamodel());
        CriteriaQuery<Object> query = builder.createQuery();
        Root<Company> root = query.from(Company.class);
        query = query.select(root)
                .where(builder.equal(root.get("name"), builder.parameter(String.class, "name"))).select(root.get("id"));
        return companyDAO.query(query).setParameter("name", name.toLowerCase()).getResultList().size() > 0;
    }

    public boolean codeExists(String code) {
        CriteriaBuilder builder = new CriteriaBuilderImpl(entityManager.getMetamodel());
        CriteriaQuery<Object> query = builder.createQuery();
        Root<Company> root = query.from(Company.class);
        query = query.select(root)
                .where(builder.equal(root.get("code"), builder.parameter(String.class, "code"))).select(root.get("id"));
        return companyDAO.query(query).setParameter("code", code.toLowerCase()).getResultList().size() > 0;
    }

    public boolean validateForCreate(Company company) {
        if (company.getName() == null || company.getName().trim().isEmpty()) {
            return false;
        }
        return true;
    }

}
