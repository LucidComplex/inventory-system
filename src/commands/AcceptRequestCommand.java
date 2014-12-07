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
import models.Item;
import models.PurchaseRequest;
import javax.swing.JTable;

/**
 *
 * @author tan
 */
public class AcceptRequestCommand extends Command {
    
    public AcceptRequestCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }

    @Override
    public void execute() throws ExecutorException {
        JTable requestTable = (JTable) fields.get("request_table");
        List<PurchaseRequest> requestList = Database.getRequestList();
        PurchaseRequest request = requestList.get(requestTable.getSelectedRow());
        
        Item requestedItem = request.getRequestedItem();
        int requestedQuantity = request.getRequestedQuantity();
        
        requestedItem.incQuantity(requestedQuantity);
        requestedItem.update();
        
        request.delete();
    }
    
}
