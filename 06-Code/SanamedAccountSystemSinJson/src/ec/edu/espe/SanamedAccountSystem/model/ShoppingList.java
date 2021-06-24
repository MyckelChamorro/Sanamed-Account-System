/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.SanamedAccountSystem.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Esteban
 */
public class ShoppingList {
    private ArrayList<Product> products = new ArrayList<Product>();
    private float totalValue;

    public ShoppingList() {
    }

    public ShoppingList(float totalValue) {
        this.totalValue = totalValue;
    }
    
    public void imprimirLista(){
        Iterator<Product> it = products.iterator();
        int contador = 0;
        while(it.hasNext()){
            System.out.println(it.next());
            contador = contador +1;
        }
    }
    
    public void agregarProducto(Product e){
        products.add(e);
    }
    
    public void TotalValue(){
        
    } 

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }
    
    public ArrayList removeProduct(Product product){
        return null;
        
    }
    
    public void ArrayList(Product product){
        
    }
}
