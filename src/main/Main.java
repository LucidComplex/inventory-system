/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import base.Database;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import models.Address;
import models.Category;
import models.Contact;
import models.Monkey;
import models.Supplier;
import models.factory.ModelFactory;
import ui.LoginWindow;

/**
 *
 * @author tan
 */
public class Main {
    private static Database inventory;
    
    public Main(){
        inventory = new Database();
    }
    
    public static void main(String[] args) {
        Main main = new Main();
//        EntityManager em = Database.EMF.createEntityManager();
//        em.getTransaction().begin();
//        Monkey root = ModelFactory.createMonkey();
//        Supplier sup = ModelFactory.createSupplier();
//        Address add = ModelFactory.createAddress();
//        Contact contact = ModelFactory.createContact();
//        Category category = ModelFactory.createCategory();
//        category.setName("Default Category");
//        category.setDescription("this is the default category");
//        em.persist(category);
//        root.setUsername("root");
//        root.setPassword("123");
//        em.persist(root);
//        add.setCity("Cebu");
//        add.setProvince("Cebu");
//        add.setStreet("Gorordo Avenue");
//        add.setZipcode("6000");
//        add.setCountry("Philippines");
//        contact.setEmail("supplier@supply.com");
//        contact.setNumber("78775437");
//        sup.setAddress(add);
//        sup.setContact(contact);
//        sup.setName("JBL");
//        em.persist(sup);
//        em.getTransaction().commit();
        
        main.start();
    }
    
    private static void start(){
        JFrame login = new LoginWindow();
        login.setVisible(true);
    }
    
}
