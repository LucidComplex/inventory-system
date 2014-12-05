/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import base.Command;
import base.UI;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import models.Item;

/**
 *
 * @author tan
 */
public class RemoveItemCommand extends Command {
    
    public RemoveItemCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }

    @Override
    public void execute() {
        JSpinner quantitySpinner = (JSpinner) fields.get("quantity_field");
        JComboBox selectedItem = (JComboBox) fields.get("removeItem_combo");
        
        int quantity = (int) quantitySpinner.getValue();
        Object selectedObject = selectedItem.getSelectedItem();
        if(selectedObject instanceof String)
            return;
        Item item = (Item) selectedObject;
        
        // delete the item completely when deleting and quantity is 0
        if(item.getQuantity()==0){
            item.delete();
            return;
        }
        
        item.decQuantity(quantity);
        item.update();
    }
    
}
