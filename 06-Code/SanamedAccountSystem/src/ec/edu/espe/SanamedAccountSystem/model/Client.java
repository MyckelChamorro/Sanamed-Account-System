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
public class Client {

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", adress=" + adress + ", phoneNumber=" + phoneNumber + ", creditCard=" + creditCard + '}';
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the creditCard
     */
    public CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * @param creditCard the creditCard to set
     */
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
    private int id;
    private String name;
    private String adress;
    private int phoneNumber;
    private CreditCard creditCard; 

    public Client() {
    }

    public Client(int id, String name, String adress, int phoneNumber, CreditCard creditCard) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.creditCard = creditCard;
    }
    
    
    
    public void payWithCard(CreditCard card){
        
    }
    
    public void payWithChas(){
        
    }
}
