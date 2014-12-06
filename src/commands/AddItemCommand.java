/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import base.Command;
import base.UI;
import java.time.Instant;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.Category;
import models.Item;
import models.Supplier;
import models.factory.ModelFactory;

/**
 *
 * @author tan
 */
public class AddItemCommand extends Command {
    
    public AddItemCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }
    
    @Override
    public void execute() {
        Item item = ModelFactory.createItem();
        JComboBox selectedCategory = (JComboBox) fields.get("category_combo");
        JComboBox selectedSupplier = (JComboBox) fields.get("supplier_combo");
        Object categoryObject = selectedCategory.getSelectedItem();
        Object supplierObject = selectedSupplier.getSelectedItem();
        if(categoryObject instanceof String || supplierObject instanceof String)
            return;

        JTextField name = (JTextField) fields.get("name_field");
        JTextArea  description = (JTextArea) fields.get("description_textarea");
        
        item.setCategory((Category)categoryObject);
        item.setName(name.getText());
        item.setDescription( description.getText());
        item.setSupplier((Supplier)supplierObject);
        item.setDateLastAdded(Date.from(Instant.now()));

        item.commit();
    }
    
}
