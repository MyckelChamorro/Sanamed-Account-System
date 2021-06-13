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
public class FinalConsumer {
    
    private float totalValue;
    private ShoppingList shoppingList;

    public FinalConsumer() {
    }

    public FinalConsumer(float totalValue, ShoppingList shoppingList) {
        this.totalValue = totalValue;
        this.shoppingList = shoppingList;
    }

    /**
     * @return the totalValue
     */
    public float getTotalValue() {
        return totalValue;
    }

    /**
     * @param totalValue the totalValue to set
     */
    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * @return the shoppingList
     */
    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    /**
     * @param shoppingList the shoppingList to set
     */
    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }    
    
    
    public void printFinalConsumer(){
        
    }
}
