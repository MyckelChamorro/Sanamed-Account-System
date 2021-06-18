/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.SanamedAccountSystem.view;

import ec.edu.espe.SanamedAccountSystem.model.Client;
import ec.edu.espe.SanamedAccountSystem.model.CreditCard;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Myckel Chamorro EMCL.java ESPE-DCCO
 */
public class SanamedAplication {

    public static void main(String[] args) {
        int id;
        String name;
        String adress;
        long card;
        int phoneNumber;
        File document;
        FileWriter write;
        PrintWriter line;

        ArrayList<Client> clients = new ArrayList<>();

        Client client = new Client(1, "Pablo", "Calle piojito", 676543, new CreditCard(114455));
        System.out.println("The Client 1->" + client);
        Client client2 = new Client(2, "Marta", "Calle Tejar", 226542, new CreditCard(124458));
        System.out.println("The Client 2->" + client2);

        clients.add(client);
        clients.add(client2);

        System.out.println("The arraylist of clients ->" + clients);

        Client clientsArray[] = new Client[5];
        clientsArray[0] = client;
        clientsArray[1] = client2;
        System.out.println("The clientArray-> " + clientsArray[0] + ", " + clientsArray[1]);

        
         //one word x scan
        Scanner keyboardinput = new Scanner(System.in);
        System.out.println("Text Files by Myckel Chamorro");
        System.out.println("Insert Id-->");
        id = keyboardinput.nextInt();
        System.out.println("Insert name-->");
        name = keyboardinput.next();
        System.out.println("Insert adress-->");
        adress = keyboardinput.next();
        System.out.println("Insert Phone-->");
        phoneNumber = keyboardinput.nextInt();
        System.out.println("Insert Credit Card-->");
        card = keyboardinput.nextLong();
        CreditCard creditCard = new CreditCard(card);

        Client client3 = new Client(id, name, adress,phoneNumber, creditCard);

        document = new File("clients.csv");
        if (!document.exists()) {
            try {
                
                document.createNewFile();
                write = new FileWriter(document, true);
                line = new PrintWriter(write);

                line.println(String.format("%d;%s;%s;%d;%d",
                        client3.getId(),
                        client3.getName(),
                        client3.getAdress(),
                        client3.getPhoneNumber(),
                        creditCard.getNumberOfCard()
                ));

                line.close();
                write.close();
            } catch (IOException ex) {
                Logger.getLogger(SanamedAplication.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        } else {
       
            try {
                write = new FileWriter(document, true);
                line = new PrintWriter(write);

                line.println(String.format("%d;%s;%s;%d;%d",
                        client3.getId(),
                        client3.getName(),
                        client3.getAdress(),
                        client3.getPhoneNumber(),
                        creditCard.getNumberOfCard()
                ));

                line.close();
                write.close();
            } catch (IOException ex) {
                Logger.getLogger(SanamedAplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
