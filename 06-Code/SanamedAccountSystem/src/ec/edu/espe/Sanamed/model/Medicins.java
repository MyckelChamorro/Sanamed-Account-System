/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.model;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class Medicins {
    
    private String typeOfMedicine;// crear una clase de esto 
    private int stock;
    private float price;

    public Medicins() {
    }
    
//Problems in High Cohesion because are some events that are empty
    
    public Medicins(String typeOfMedicine, int stock, float price) {
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
    
    public void CalculateStock(){
        
    }
    
    //Problems in High Cohesion because are some events that are empty
}
