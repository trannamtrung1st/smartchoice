/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.business.services;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    public boolean companyNameExists(String name) {
        String sql = "SELECT id FROM Company WHERE name=?name";
        Query query = companyDAO.nativeQuery(sql).setParameter("name", name);
        List<Integer> list = query.getResultList();
        return list.size() > 0;
    }

    public boolean companyCodeExists(String code) {
        String sql = "SELECT id FROM Company WHERE code=?code";
        Query query = companyDAO.nativeQuery(sql).setParameter("code", code);
        List<Integer> list = query.getResultList();
        return list.size() > 0;
    }

    public <In, T> List<T> queryCompanyByCode(String code, Function<In, T> mapping, String... fields) {
        String fieldJoin = String.join(",", fields);
        String sql = "SELECT " + fieldJoin + " FROM Company WHERE code=?code";
        Query query = companyDAO.nativeQuery(sql).setParameter("code", code);
        List<In> list = query.getResultList();
        return list.stream().map(mapping).collect(Collectors.toList());
    }

    public Company findCompanyByCode(String code) {
        String sql = "SELECT * FROM Company WHERE code=?code";
        Query query = companyDAO.nativeQuery(sql, Company.class).setParameter("code", code);
        List<Company> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public boolean validateForCreate(Company entity) {
        if (entity.getName() == null || entity.getName().trim().isEmpty()) {
            return false;
        }
        return true;
    }

}
