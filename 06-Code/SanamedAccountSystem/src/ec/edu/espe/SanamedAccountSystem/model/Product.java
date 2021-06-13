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
