/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.SanamedAccountSystem.view;

import ec.edu.espe.SanamedAccountSystem.model.Client;
import ec.edu.espe.SanamedAccountSystem.model.CreditCard;
import java.util.ArrayList;

/**
 *
 * @author Myckel Chamorro EMCL.java ESPE-DCCO
 */
public class SanamedAplication {
    public static void main(String[] args) {
    int id;
    String name;
    String adress;
    int phoneNumber;
    CreditCard creditCard;
    ArrayList<Client> clients = new ArrayList<>();
    
    Client client = new Client(1,"Pablo","Calle piojito",676543,new CreditCard(114455));
        System.out.println("The Client 1->"+client);
     Client client2 = new Client(2,"Marta","Calle Tejar",226542,new CreditCard(124458));    
        System.out.println("The Client 2->"+client2);
        
    clients.add(client);
    clients.add(client2);
    
        System.out.println("The arraylist of clients ->"+clients);
        
        Client clientsArray[] = new Client[5];
            clientsArray[0] = client;
            clientsArray[1] = client2;
           System.out.println("The clientArray-> "+ clientsArray[0]+ ", "+clientsArray[1]);
            
    }
}
