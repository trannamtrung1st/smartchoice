/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.console;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import smartchoice.business.services.CareerFieldService;
import smartchoice.business.services.LocationService;
import smartchoice.data.EntityContext;
import smartchoice.data.daos.CareerFieldDAO;
import smartchoice.data.daos.LocationDAO;
import smartchoice.data.models.CareerField;
import smartchoice.data.models.Location;
import smartchoice.helper.FileHelper;
import smartchoice.helper.XMLHelper;

/**
 *
 * @author TNT
 */
public class Entry {

    public static void main(String[] args) throws IOException {
        generateCodeFromSchema();
    }

    static void createAllCareerFields() throws IOException {
        try (EntityContext context = EntityContext.newInstance()) {
            EntityManager em = context.getEntityManager();
            CareerFieldDAO dao = new CareerFieldDAO(em);
            CareerFieldService service = new CareerFieldService(em, dao);
            List<String> lines = FileHelper.readAllLines("T:\\FPT\\STUDY\\SUMMER2020\\PRX\\Project\\SmartChoice\\all-fields.txt");
            int i = 0;
            String line;
            em.getTransaction().begin();
            while (!(line = lines.get(i++)).equals("###")) {
                System.out.println(line);
                CareerField entity = new CareerField();
                entity.setName(line);
                service.createCareerField(entity);
            }
            em.getTransaction().commit();
        }
    }

    static void createAllLocations() throws IOException {
        try (EntityContext context = EntityContext.newInstance()) {
            EntityManager em = context.getEntityManager();
            LocationDAO dao = new LocationDAO(em);
            LocationService service = new LocationService(em, dao);
            List<String> lines = FileHelper.readAllLines("T:\\FPT\\STUDY\\SUMMER2020\\PRX\\Project\\SmartChoice\\all-locs.txt");
            int i = 0;
            String line;
            em.getTransaction().begin();
            while (!(line = lines.get(i++)).equals("###")) {
                System.out.println(line);
                Location entity = new Location();
                entity.setName(line);
                if (line.equals("Nước ngoài")) {
                    entity.setIsInVietNam(false);
                } else {
                    entity.setIsInVietNam(true);
                }
                service.createLocation(entity);
            }
            em.getTransaction().commit();
        }
    }

    static void generateCodeFromSchema() throws IOException {
        System.out.println("Input output, package name, xsd path (Enter to submit): ");
        String output = new Scanner(System.in).nextLine();
        String forcePkgName = new Scanner(System.in).nextLine();
        String xsd = new Scanner(System.in).nextLine();
        XMLHelper.generateCodeFromSchema(output, forcePkgName, xsd, null);
    }
}
