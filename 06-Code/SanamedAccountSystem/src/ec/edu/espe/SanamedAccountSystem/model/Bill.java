/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.SanamedAccountSystem.model;

import java.util.Date;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class Bill {
    private Client client;
    private Pharmacy pharmacy;
    private int numberOfbill;
    private Date date;

    public Bill() {
    }

    public Bill(Client client, Pharmacy pharmacy, int numberOfbill, Date date) {
        this.client = client;
        this.pharmacy = pharmacy;
        this.numberOfbill = numberOfbill;
        this.date = date;
    }
    
    

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public int getNumberOfbill() {
        return numberOfbill;
    }

    public void setNumberOfbill(int numberOfbill) {
        this.numberOfbill = numberOfbill;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void printBil(ShoppingList list){
        
    }
}
