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
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class ProductController {
    ProductDAO objetoDAO = new ProductDAO();
    Product objetoProduct = new Product();
    ProductFrm vista = new ProductFrm(this);

    public ProductController() {}
    
    public void mostrarVista() {
        vista.setVisible(true);
    }
    
    public void addProduct(Product product){
        objetoDAO.insertProduct(product);
    }
    
}
