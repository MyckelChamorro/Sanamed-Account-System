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
   private String type;

   //Constructores 
   public Product() {
    }

    public Product(String type, int quantity, float individualValue) {
        this.type = type;
        this.quantity = quantity;
        this.individualValue = individualValue;
    }
    
    public void addMedicine(Medicins medicina){
        this.quantity = 1;
        this.individualValue = medicina.getPrice();
        this.type = medicina.getTypeOfMedicine();
    }

    //Getters & Setters
    public Medicins getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicins medicine) {
        this.medicine = medicine;
    }

    public Cosmetic getCosmetic() {
        return cosmetic;
    }

    public void setCosmetic(Cosmetic cosmetic) {
        this.cosmetic = cosmetic;
    }

    public Others getOther() {
        return other;
    }

    public void setOther(Others other) {
        this.other = other;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getIndividualValue() {
        return individualValue;
    }

    public void setIndividualValue(float individualValue) {
        this.individualValue = individualValue;
    }
   
   //Metodos
//   public Medicins addMedicine(Medicins medicine){
//       return new Medicins();
//   }
   
   public Cosmetic addCosmetic(Cosmetic cosmetic){
       return new Cosmetic();
   }
   
   public Others addOther(Others other){
       return new Others();
   }

    @Override
    public String toString() {
        return "Product{" + "quantity=" + quantity + ", individualValue=" + individualValue + ", type=" + type + '}';
    }
   
   
   
}
