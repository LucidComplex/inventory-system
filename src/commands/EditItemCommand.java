/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import base.Command;
import base.UI;
import exceptions.ExecutorException;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.Item;

/**
 *
 * @author tan
 */
public class EditItemCommand extends Command {
    
    public EditItemCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }

    @Override
    public void execute() throws ExecutorException {
        JComboBox selectedItem = (JComboBox) fields.get("itemName_combo");
        JTextField name = (JTextField) fields.get("itemName_field");
        JTextArea description = (JTextArea) fields.get("itemDescription_field");
        JRadioButton nameActive = (JRadioButton) fields.get("itemName_radiobutton");
        JRadioButton descriptionActive = (JRadioButton) fields.get("itemDescription_radiobutton");
        
        boolean nameSelected = nameActive.isSelected();
        boolean descriptionSelected = descriptionActive.isSelected();
        
        Item editedItem = (Item) selectedItem.getSelectedItem();
        
        if(nameSelected)
            editedItem.setName(name.getText());
        if(descriptionSelected)
            editedItem.setDescription(description.getText());
        
        editedItem.update();
    }
    
}
