/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import models.*;

/**
 *
 * @author tan
 */
public class Database {
    public static EntityManagerFactory EMF;
    public static EntityManager em;
    private static List<Item> itemList;
    private static List<Supplier> supplierList;
    private static List<Category> categoryList;
    private static List<Department> departmentList;
    private static List<PurchaseRequest> requestList;

    /**
     * @return the itemList
     */
    public static List<Item> getItemList() {
        return itemList;
    }

    /**
     * @return the supplierList
     */
    public static List<Supplier> getSupplierList() {
        return supplierList;
    }

    /**
     * @return the categoryList
     */
    public static List<Category> getCategoryList() {
        return categoryList;
    }

    /**
     * @return the departmentList
     */
    public static List<Department> getDepartmentList() {
        return departmentList;
    }

    /**
     * @return the requestList
     */
    public static List<PurchaseRequest> getRequestList() {
        return requestList;
    }

    /**
     * @param aRequestList the requestList to set
     */
    public static void setRequestList(List<PurchaseRequest> aRequestList) {
        requestList = aRequestList;
    }
    
    public Database(){
        createConnection();
        loadDatabase();
    }        
    
    
    private static void loadDatabase(){
        TypedQuery items = em.createQuery("SELECT i FROM Item i", Item.class);
        itemList = items.getResultList();
        TypedQuery suppliers = em.createQuery("SELECT s FROM Supplier s", Supplier.class);
        supplierList = suppliers.getResultList();
        TypedQuery categories = em.createQuery("SELECT c FROM Category c", Category.class);
        categoryList = categories.getResultList();
        TypedQuery departments = em.createQuery("SELECT d FROM Department d", Department.class);
        departmentList = departments.getResultList();
        TypedQuery requests = em.createQuery("SELECT r FROM PurchaseRequest r", PurchaseRequest.class);
        requestList = requests.getResultList();
    }
    
    public static void refreshDatabase(){
        loadDatabase();
    }
    
    private static void createConnection(){
        EMF = Persistence.createEntityManagerFactory("InventoryPersistence");
        em = EMF.createEntityManager();
    }
}
