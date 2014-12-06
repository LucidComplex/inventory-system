/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import base.Command;
import base.UI;
import exceptions.ExecutorException;
import javax.swing.*;
import models.Address;
import models.Contact;
import models.Supplier;

/**
 *
 * @author tan
 */
public class EditSupplierCommand extends Command {

    public EditSupplierCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }
    
    @Override
    public void execute() throws ExecutorException {
        JComboBox editSupplier = (JComboBox) fields.get("supplier_combo");
        Object selectedObject = editSupplier.getSelectedItem();
        if(selectedObject instanceof String)
            return;
        Supplier supplier = (Supplier) selectedObject;
        Address address = supplier.getAddress();
        Contact contact = supplier.getContact();
        
        JTextField newName = (JTextField) fields.get("name_field");
        JTextField newStreet = (JTextField) fields.get("street_field");
        JTextField newCity = (JTextField) fields.get("city_field");
        JTextField newCountry = (JTextField) fields.get("country_field");
        JTextField newProvince = (JTextField) fields.get("province_field");
        JTextField newZipcode = (JTextField) fields.get("zipcode_field");
        JTextField newContact = (JTextField) fields.get("contact_field");
        JTextField newEmail = (JTextField) fields.get("email_field");
        
        if(newName.isEnabled())
            supplier.setName(newName.getText());
        if(newStreet.isEnabled())
            address.setStreet(newStreet.getText());
        if(newCity.isEnabled())
            address.setCity(newCity.getText());
        if(newCountry.isEnabled())
            address.setCountry(newCountry.getText());
        if(newProvince.isEnabled())
            address.setProvince(newProvince.getText());
        if(newZipcode.isEnabled())
            address.setZipcode(newZipcode.getText());
        if(newContact.isEnabled())
            contact.setNumber(newContact.getText());
        if(newEmail.isEnabled())
            contact.setEmail(newEmail.getText());
            
        supplier.update();
    }
    
}
