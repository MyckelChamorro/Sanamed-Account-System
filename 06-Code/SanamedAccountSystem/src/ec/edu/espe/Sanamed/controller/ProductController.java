/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.controller;

import ec.edu.espe.Sanamed.model.Product;
import ec.edu.espe.Sanamed.model.ProductDAO;
import ec.edu.espe.Sanamed.view.ProductFrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class ProductController implements ActionListener{
    
    ProductDAO objetoDAO = new ProductDAO();
    Product objetoProduct = new Product();
    ProductFrm vista = new ProductFrm();

    public ProductController(ProductFrm v) {
        this.vista=v;
        this.vista.btnAdd.addActionListener(this);
    }
    
    //High Cohesion because this constructor has a leaking "this" 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnAdd){
            addProduct();
        }
    }
    
    public void addProduct(){
        objetoProduct.setType(vista.txtType.getText());
        objetoProduct.setName(vista.txtName.getText());
        objetoProduct.setId(vista.txtId.getText());
        objetoProduct.setDescription(vista.txtDescription.getText());
        objetoProduct.setPrice(Integer.parseInt(vista.txtPrice.getText()));     
        objetoDAO.insertProduct(objetoProduct);
    }
    
}
