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
    }

    public static void login(Pharmacy pharma) {

        //INICIO DE SESION
        String userLog = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------| INGRESO DE USUARIO |----------------------");
        System.out.println("Ingrese su usuario: ");
        userLog = scan.nextLine();

        pharma.logginCashier(userLog);

    }

    public static void menu(int option, String op) throws FileNotFoundException, IOException, ParseException {
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("------------------------| MENU PRINCIPAL |----------------------");
            System.out.println("1. Ingreso de ventas.");
            System.out.println("2. Busqueda de productos.");
            System.out.println("3. Imprimir.");
            System.out.println("4. Salir");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Seleccione una opcion: ");
            op = scan.nextLine();
            System.out.println("--------------------------------------------------------------");
            option = Integer.parseInt(op);

            switch (option) {

                case 1:
                    int selectOption;
                    int id;
                    String name;
                    String adress;
                    int card;
                    int phoneNumber;
                    File document;
                    FileWriter file;
                    PrintWriter line;
                    System.out.println("Selecciono ingreso de ventas");
                    Scanner keyboardinput = new Scanner(System.in);
                    document = new File("clients.json");
                    JSONObject clientData = new JSONObject();

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
                                card = keyboardinput.nextInt();

                                Client client3 = new Client(id, name, adress, phoneNumber, card);

                                JSONObject jsonClient = new JSONObject();
                                jsonClient.put("id", client3.getId());
                                jsonClient.put("name", client3.getName());
                                jsonClient.put("adress", client3.getAdress());
                                jsonClient.put("phoneNumber", client3.getPhoneNumber());
                                jsonClient.put("creditCard", client3.getCreditCard());

                                clientData.put("client", jsonClient);

                                JSONArray listClient = new JSONArray();
                                listClient.add(clientData);

                                if (!document.exists()) {
                                    try {
                                        document.createNewFile();
                                        file = new FileWriter(document, true);
                                        line = new PrintWriter(file);
                                        file.write(listClient.toString());
                                        line.close();
                                        file.close();

                                    } catch (IOException ex) {
                                        Logger.getLogger(SanamedAplication.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                } else {

                                    try {
                                        file = new FileWriter(document, true);
                                        line = new PrintWriter(file);
                                        file.write(listClient.toString());
                                        line.close();
                                        file.close();

                                        System.out.println("Desarollo");

                                    } catch (IOException ex) {
                                        Logger.getLogger(SanamedAplication.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                }
                                break;
                            case 2:
                                JSONParser parser = new JSONParser();
                                FileReader reader = new FileReader("clients.json");
                                Object obj = parser.parse(reader);
                                JSONArray clienList = (JSONArray) obj;
                                System.out.println(clienList);
                                break;

                            case 3:
                                selectOption = 5;

                                break;

                        }
                    } while (selectOption == 3 || selectOption == 1 || selectOption == 2);

                    break;
                case 2:
                    System.out.println("Selecciono busqueda de productos.");
                    break;
                case 3:
                    System.out.println("Selecciono impresion.");
                    break;
                case 4:
                    System.out.println("Gracias por ocupar el programa.");
                    break;
                default:
                    System.out.println("Eliga una de las opciones.");
            }
        } while (option != 4);
    }

}
