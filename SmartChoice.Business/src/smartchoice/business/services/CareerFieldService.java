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
import smartchoice.data.daos.CareerFieldDAO;
import smartchoice.data.models.CareerField;

/**
 *
 * @author TNT
 */
public class CareerFieldService {

    protected CareerFieldDAO careerFieldDAO;
    protected EntityManager entityManager;

    public CareerFieldService(EntityManager entityManager, CareerFieldDAO careerFieldDAO) {
        this.entityManager = entityManager;
        this.careerFieldDAO = careerFieldDAO;
    }

    public CareerField createCareerField(CareerField entity) {
        return careerFieldDAO.create(entity);
    }

    public <In, T> List<T> queryCareerFieldByName(String name, Function<In, T> mapping, String... fields) {
        String fieldJoin = String.join(",", fields);
        String sql = "SELECT " + fieldJoin + " FROM CareerField WHERE name=?name";
        Query query = careerFieldDAO.nativeQuery(sql).setParameter("name", name);
        List<In> list = query.getResultList();
        return list.stream().map(mapping).collect(Collectors.toList());
    }

    public boolean validateForCreate(CareerField entity) {
        if (entity.getName() == null || entity.getName().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public List<CareerField> findCareerFieldByName(String name) {
        String sql = "SELECT * FROM CareerField WHERE name=?name";
        Query query = careerFieldDAO.nativeQuery(sql, CareerField.class).setParameter("name", name);
        List<CareerField> list = query.getResultList();
        return list;
    }

}
