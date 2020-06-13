/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.business.services;

import javax.persistence.EntityManager;
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

}
