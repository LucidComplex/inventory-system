/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import base.Commitable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tan
 */

@Entity
@Table(name="PURCHASE_REQUEST")
public class PurchaseRequest extends Commitable implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name="REQUESTING_DEPARTMENT")
    private Department requestingDepartment;
    
    @ManyToOne
    private Item requestedItem;
    
    @Column(name="REQUESTED_QUANTITY")
    private int requestedQuantity;

    /**
     * @return the requestingDepartment
     */
    public Department getRequestingDepartment() {
        return requestingDepartment;
    }

    /**
     * @param requestingDepartment the requestingDepartment to set
     */
    public void setRequestingDepartment(Department requestingDepartment) {
        this.requestingDepartment = requestingDepartment;
    }

    /**
     * @return the requestedItem
     */
    public Item getRequestedItem() {
        return requestedItem;
    }

    /**
     * @param requestedItem the requestedItem to set
     */
    public void setRequestedItem(Item requestedItem) {
        this.requestedItem = requestedItem;
    }

    /**
     * @return the requestedQuantity
     */
    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    /**
     * @param requestedQuantity the requestedQuantity to set
     */
    public void setRequestedQuantity(int requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }
    
    @Override
    public String toString(){
        return requestedItem.getName();
    }
    
}
