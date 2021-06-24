/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.SanamedAccountSystem.model;

/**
 *
 * @author Esteban
 */
public class Product {
    
    private Medicins medicine;
   private Cosmetic cosmetic;
   private Others other;
   private int quantity;
   private float individualValue;

    public Product() {
    }

    public Product(Medicins medicine, Cosmetic cosmetic, Others other, int quantity, float individualValue) {
        this.medicine = medicine;
        this.cosmetic = cosmetic;
        this.other = other;
        this.quantity = quantity;
        this.individualValue = individualValue;
    }

    /**
     * @return the medicine
     */
    public Medicins getMedicine() {
        return medicine;
    }

    /**
     * @param medicine the medicine to set
     */
    public void setMedicine(Medicins medicine) {
        this.medicine = medicine;
    }

    /**
     * @return the cosmetic
     */
    public Cosmetic getCosmetic() {
        return cosmetic;
    }

    /**
     * @param cosmetic the cosmetic to set
     */
    public void setCosmetic(Cosmetic cosmetic) {
        this.cosmetic = cosmetic;
    }

    /**
     * @return the other
     */
    public Others getOther() {
        return other;
    }

    /**
     * @param other the other to set
     */
    public void setOther(Others other) {
        this.other = other;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the individualValue
     */
    public float getIndividualValue() {
        return individualValue;
    }

    /**
     * @param individualValue the individualValue to set
     */
    public void setIndividualValue(float individualValue) {
        this.individualValue = individualValue;
    }
   
   
   
   public Medicins addMedicine(Medicins medicine){
       return new Medicins();
   }
   
   public Cosmetic addCosmetic(Cosmetic cosmetic){
       return new Cosmetic();
   }
   
   public Others addOther(Others other){
       return new Others();
   }
   
}
