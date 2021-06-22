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
public class CreditCard {
    
    private long numberOfCard;

    @Override
    public String toString() {
        return "CreditCard{" + "numberOfCard=" + numberOfCard + '}';
    }
    

    public CreditCard() {
        numberOfCard=0000;
    }

    public CreditCard(long numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    /**
     * @return the numberOfCard
     */
    public long getNumberOfCard() {
        return numberOfCard;
    }

    /**
     * @param numberOfCard the numberOfCard to set
     */
    public void setNumberOfCard(int numberOfCard) {
        this.numberOfCard = numberOfCard;
    }
      
    
}
