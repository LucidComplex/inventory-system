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
import models.PurchaseRequest;

/**
 *
 * @author tan
 */
public class RejectRequestCommand extends Command {
    
    public RejectRequestCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }

    @Override
    public void execute() throws ExecutorException {
        JTable table = (JTable) fields.get("requests_table");
        List<PurchaseRequest> requestList = Database.getRequestList();
        PurchaseRequest selectedRequest = requestList.get(table.getSelectedRow());
        selectedRequest.delete();
    }
    
}
