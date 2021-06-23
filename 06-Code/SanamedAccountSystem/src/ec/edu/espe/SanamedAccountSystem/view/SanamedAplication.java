/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.SanamedAccountSystem.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.SanamedAccountSystem.model.Client;
import ec.edu.espe.SanamedAccountSystem.model.CreditCard;
import ec.edu.espe.SanamedAccountSystem.model.Pharmacy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Myckel Chamorro EMCL.java ESPE-DCCO
 */
public class SanamedAplication {

    public static void main(String[] args) throws ParseException, IOException {

        Pharmacy pharmacy = new Pharmacy();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        int selectOption;

        ArrayList<Client> clients = new ArrayList<>();

        Pharmacy pharma = new Pharmacy("Sanamed", "npi", "Aleja", "clave");

        //INICIO DE SESION
        login(pharma);
        //MENU
        int option = 0;
        String op = "";
        menu(option, op);
        //Client client = new Client(1, "Pablo", "Calle piojito", 676543, new CreditCard(114455));
        //System.out.println("The Client 1->" + client);
        // Client client2 = new Client(2, "Marta", "Calle Tejar", 226542, new CreditCard(124458));
        // System.out.println("The Client 2->" + client2);

        //clients.add(client);
        //clients.add(client2);
        //System.out.println("The arraylist of clients ->" + clients);
        //Client clientsArray[] = new Client[5];
        //clientsArray[0] = client;
        //clientsArray[1] = client2;
        //System.out.println("The clientArray-> " + clientsArray[0] + ", " + clientsArray[1]);
    }

    public static void login(Pharmacy pharma) {

        //INICIO DE SESION
        String userLog = null;
        Scanner scan = new Scanner(System.in);
//        System.out.println("Ingrese su usuario: ");
//        userLog= scan.nextLine();
        //userLog = JOptionPane.showInputDialog("Ingrese su usuario: ");
        userLog = JOptionPane.showInputDialog(null, "Ingrese su usuario", "Ingreso de Usuario", JOptionPane.QUESTION_MESSAGE);
        pharma.logginCashier(userLog);

    }

    public static void menu(int option, String op) {
        do {
            op = JOptionPane.showInputDialog("SELECCIONE UNA OPCION. \n"
                    + "1. Ingreso de ventas\n"
                    + "2. Busqueda de productos\n"
                    + "3. Imprimir\n"
                    + "4. Salir");
            option = Integer.parseInt(op);
            switch (option) {

                case 1:
                    int selectOption;
                    int id;
                    String name;
                    String adress;
                    long card;
                    int phoneNumber;
                    File document;
                    FileWriter write;
                    PrintWriter line;
                    JOptionPane.showMessageDialog(null, "Selecciono ingreso de ventas");
                    Scanner keyboardinput = new Scanner(System.in);

                    do {
                        System.out.println("\t\t\tSanamed Account System");
                        System.out.println("1.- Insert Json");
                        System.out.println("2.- Read Json");
                        System.out.println("3._ Exit\n");
                        System.out.println("Select an option : ");
                        selectOption = keyboardinput.nextInt();

                        switch (selectOption) {
                            case 1:
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

                                Client client3 = new Client(id, name, adress, phoneNumber, creditCard);

                                document = new File("clients.json");
                                JSONObject jsonClient = new JSONObject();
                                jsonClient.put("id", client3.getId());
                                jsonClient.put("name", client3.getName());
                                jsonClient.put("adress", client3.getAdress());
                                jsonClient.put("phoneNumber", client3.getPhoneNumber());
                                jsonClient.put("creditCard", creditCard);

                                JSONObject clientData = new JSONObject();
                                clientData.put("client", jsonClient);

                                if (!document.exists()) {
                                    try {

                                        document.createNewFile();
                                        write = new FileWriter(document, true);
                                        line = new PrintWriter(write);

                                        write.write(clientData.toString());

                                        line.close();
                                        write.close();

                                    } catch (IOException ex) {
                                        Logger.getLogger(SanamedAplication.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                } else {

                                    try {
                                        write = new FileWriter(document, true);
                                        line = new PrintWriter(write);
                                        write.write(clientData.toString());
                                        line.close();
                                        write.close();
                                    } catch (IOException ex) {
                                        Logger.getLogger(SanamedAplication.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                }
                                break;
                            case 2:

                                JSONParser parser = new JSONParser();

                                try {
                                    FileReader reader = new FileReader("clients.json");
                                    Object obj = parser.parse(reader);
                                    JSONObject jsonObjs = (JSONObject) obj;
                                    System.out.print("JSON" + jsonObjs);

                                } catch (FileNotFoundException e) {
                                } catch (IOException e) {
                                } catch (ParseException e) {
                                }
                                break;

                            case 3:
                                selectOption = 5;

                                break;

                        }
                    } while (selectOption == 3 || selectOption == 1 || selectOption == 2);

                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Selecciono busqueda de productos");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Selecciono impresion");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa ;D");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Eliga una de las opciones", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } while (option != 4);
    }
}

/*function validarCedula(cedula: string) {
  if (cedula.length === 10) {
    const digitoRegion = cedula.substring(0, 2);
    if (digitoRegion >= String(1) && digitoRegion <= String(24)) {
      const ultimoDigito = Number(cedula.substring(9, 10));
      const pares = Number(cedula.substring(1, 2)) + Number(cedula.substring(3, 4)) + Number(cedula.substring(5, 6)) + Number(cedula.substring(7, 8));
      let numeroUno: any = cedula.substring(0, 1);
      numeroUno = (numeroUno * 2);
      if (numeroUno > 9) {
        numeroUno = (numeroUno - 9);
      }
      let numeroTres: any = cedula.substring(2, 3);
      numeroTres = (numeroTres * 2);
      if (numeroTres > 9) {
        numeroTres = (numeroTres - 9);
      }
      let numeroCinco: any = cedula.substring(4, 5);
      numeroCinco = (numeroCinco * 2);
      if (numeroCinco > 9) {
        numeroCinco = (numeroCinco - 9);
      }
      let numeroSiete: any = cedula.substring(6, 7);
      numeroSiete = (numeroSiete * 2);
      if (numeroSiete > 9) {
        numeroSiete = (numeroSiete - 9);
      }
      let numeroNueve: any = cedula.substring(8, 9);
      numeroNueve = (numeroNueve * 2);
      if (numeroNueve > 9) {
        numeroNueve = (numeroNueve - 9);
      }
      const impares = numeroUno + numeroTres + numeroCinco + numeroSiete + numeroNueve;
      const sumaTotal = (pares + impares);
      const primerDigitoSuma = String(sumaTotal).substring(0, 1);
      const decena = (Number(primerDigitoSuma) + 1) * 10;
      let digitoValidador = decena - sumaTotal;
      if (digitoValidador === 10) {
        digitoValidador = 0;
      }
      if (digitoValidador === ultimoDigito) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  } else {
    return false;
  }

}*/
