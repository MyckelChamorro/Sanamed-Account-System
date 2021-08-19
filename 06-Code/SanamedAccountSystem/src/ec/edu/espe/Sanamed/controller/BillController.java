/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.controller;

import ec.edu.espe.Sanamed.model.Client;
import ec.edu.espe.Sanamed.model.ClientDAO;
import ec.edu.espe.Sanamed.model.ProductDAO;
import ec.edu.espe.Sanamed.view.FrmBill;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class BillController implements ActionListener {
    ClientDAO objetoDAO = new ClientDAO();
    ProductDAO productoDAO = new ProductDAO();
    Client objetoClient = new Client();
    FrmBill vista = new FrmBill();

    public BillController(FrmBill v) {
        this.vista=v;
        this.vista.btnSave.addActionListener(this);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista.btnSave){
            addClient();
            productoDAO.mostrarColeccion(vista);
            
        }
    }
    
    public void addClient(){
        objetoClient.setName(vista.txtName.getText());
        objetoClient.setId(vista.txtId.getText());
        objetoClient.setDirection(vista.txtDirection.getText());
        objetoClient.setEmail(vista.txtEmail.getText());
        objetoClient.setBrainchOffice(vista.txtBranchOffice.getText());
        objetoClient.setPhone(vista.txtPhone.getText());
        objetoDAO.insertClient(objetoClient);
        
    }
    
}
