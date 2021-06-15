/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.SanamedAccountSystem.model;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class Others {
    
    private String typeOfMedicine;
    private int stock;
    private float price;

    public Others() {
    }

    public Others(String typeOfMedicine, int stock, float price) {
        this.typeOfMedicine = typeOfMedicine;
        this.stock = stock;
        this.price = price;
    }

    /**
     * @return the typeOfMedicine
     */
    public String getTypeOfMedicine() {
        return typeOfMedicine;
    }

    /**
     * @param typeOfMedicine the typeOfMedicine to set
     */
    public void setTypeOfMedicine(String typeOfMedicine) {
        this.typeOfMedicine = typeOfMedicine;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
    
    public void calculateStock(){
        
    }
}
