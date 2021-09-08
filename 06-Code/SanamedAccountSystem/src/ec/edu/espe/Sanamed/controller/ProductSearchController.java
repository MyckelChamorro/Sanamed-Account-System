/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.controller;

import ec.edu.espe.Sanamed.model.Product;
import ec.edu.espe.Sanamed.model.ProductDAO;
import ec.edu.espe.Sanamed.view.ProductsSearch;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class ProductSearchController implements ActionListener{

    ProductDAO objetoDAO = new ProductDAO();
    Product objetoProduct = new Product();
    ProductsSearch vista = new ProductsSearch();

    public ProductSearchController(ProductsSearch v) {
        this.vista=v;
        this.vista.btnShowProducts.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.btnShowProducts){
            ArrayList lista = new ArrayList();
            lista = objetoDAO.mostrarDatos(vista);
        }
        if(e.getSource()==vista.listProduct){
            
        } 
    }
    
}
