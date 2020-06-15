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
import smartchoice.data.daos.LocationDAO;
import smartchoice.data.models.Location;

/**
 *
 * @author TNT
 */
public class LocationService {

    protected LocationDAO locationDAO;
    protected EntityManager entityManager;

    public LocationService(EntityManager entityManager, LocationDAO locationDAO) {
        this.entityManager = entityManager;
        this.locationDAO = locationDAO;
    }

    public Location createLocation(Location entity) {
        return locationDAO.create(entity);
    }

    public <In, T> List<T> queryLocationByName(String name, Function<In, T> mapping, String... fields) {
        String fieldJoin = String.join(",", fields);
        String sql = "SELECT " + fieldJoin + " FROM Location WHERE name=?name";
        Query query = locationDAO.nativeQuery(sql).setParameter("name", name);
        List<In> list = query.getResultList();
        return list.stream().map(mapping).collect(Collectors.toList());
    }

    public Location findLocationByName(String name) {
        return locationDAO.findById(Location.class, name);
    }

}
