/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import base.Command;
import base.Database;
import base.UI;
import exceptions.ExecutorException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import models.Item;

/**
 *
 * @author tan
 */
public class SearchCommand extends Command {
    
    public SearchCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }

    @Override
    public void execute() throws ExecutorException {
        JTable table = (JTable) fields.get("inventory_table");
        String searchTerm = ((JTextField) fields.get("search_field")).getText().toLowerCase();
        List<Item> itemList = Database.getItemList();
        for(int i=0; i<itemList.size(); i++){
            Item test = itemList.get(i);
            if(test.getName().toLowerCase().equals(searchTerm)){
                table.setRowSelectionInterval(i, i);
                break;
            }
        }
    }
    
}
