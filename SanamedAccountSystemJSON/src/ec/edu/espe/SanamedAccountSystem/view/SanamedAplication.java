package ec.edu.espe.SanamedAccountSystem.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.SanamedAccountSystem.model.Client;
import ec.edu.espe.SanamedAccountSystem.model.Cosmetic;
import ec.edu.espe.SanamedAccountSystem.model.Medicins;
import ec.edu.espe.SanamedAccountSystem.model.Others;
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
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Myckel Chamorro EMCL.java ESPE-DCCO
 */
public class SanamedAplication {

    public static void main(String[] args) throws ParseException, IOException, FileNotFoundException, InterruptedException {

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

    public static void menu(int option, String op) throws FileNotFoundException, IOException, ParseException, InterruptedException {
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("------------------------| MENU PRINCIPAL |----------------------");
            System.out.println("1. Nueva venta.");
            System.out.println("2. Ingreso de productos.");
            System.out.println("3. Ingreso de clientes.");
            System.out.println("4. Salir");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Seleccione una opcion: ");
            op = scan.nextLine();
            System.out.println("--------------------------------------------------------------");
            option = Integer.parseInt(op);

            switch (option) {

                case 1:

                    break;
                case 2:
                    System.out.println("Selecciono ingreso de productos.");
                    int selectOp;
                    String typeOfMed;
                    int stock;
                    float price;

                    File documentP;
                    FileWriter fileP;
                    PrintWriter lineP;
                    Scanner keyboardinput2 = new Scanner(System.in);
                    documentP = new File("products.json");
                    JSONObject productData = new JSONObject();

                    do {
                        System.out.println("\t\t\tIngreso de Productos");
                        System.out.println("1.- Insertar Producto");
                        System.out.println("2.- Ver todos los productos");
                        System.out.println("3._ Exit\n");
                        System.out.println("Select an option : ");
                        selectOp = keyboardinput2.nextInt();

                        switch (selectOp) {
                            case 1:
                                int opP;
                                System.out.println("\t\t\tIngrese el tipo de Medicina");
                                System.out.println("1.- Insertar Medicamento");
                                System.out.println("2.- Insertar Cosmetico");
                                System.out.println("3._ Insertar Otro tipo\n");
                                System.out.println("Select an option : ");

                                opP = keyboardinput2.nextInt();

                                switch (opP) {
                                    case 1:
                                        System.out.println("Insert Type of Medicine-->");
                                        typeOfMed = keyboardinput2.next();
                                        System.out.println("Insert stock-->");
                                        stock = keyboardinput2.nextInt();
                                        System.out.println("Insert price-->");
                                        price = keyboardinput2.nextFloat();

                                        Medicins medicin = new Medicins(typeOfMed, stock, price);

                                        JSONObject jsonMed = new JSONObject();
                                        jsonMed.put("typeOfMedicin",medicin.getTypeOfMedicine());
                                        jsonMed.put("stock",medicin.getStock());
                                        jsonMed.put("price", medicin.getPrice());
                                        
                                        productData.put("medicin",jsonMed);
                                        
                                        JSONArray listMed = new JSONArray();
                                        
                                        listMed.add(productData);
                                        if (!documentP.exists()){                       
                                            documentP.createNewFile();
                                        fileP = new FileWriter(documentP, true);
                                        lineP = new PrintWriter(fileP);
                                        fileP.write(listMed.toString());
                                        lineP.close();
                                        fileP.close();        
                                        }else{
                                        fileP = new FileWriter(documentP, true);
                                        lineP = new PrintWriter(fileP);
                                        fileP.write(listMed.toString());
                                        lineP.close();
                                        fileP.close(); 
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Insert Type of Cosmetic-->");
                                        typeOfMed = keyboardinput2.next();
                                        System.out.println("Insert stock-->");
                                        stock = keyboardinput2.nextInt();
                                        System.out.println("Insert price-->");
                                        price = keyboardinput2.nextFloat();

                                        Cosmetic cosmetic = new Cosmetic(typeOfMed, stock, price);

                                        JSONObject jsonCos = new JSONObject();
                                        jsonCos.put("typeOfMedicin",cosmetic.getTypeOfMedicine());
                                        jsonCos.put("stock",cosmetic.getStock());
                                        jsonCos.put("price", cosmetic.getPrice());
                                        
                                        productData.put("cosmetic",jsonCos);
                                        
                                        JSONArray listCos = new JSONArray();
                                        
                                        listCos.add(productData);
                                        if (!documentP.exists()){                       
                                            documentP.createNewFile();
                                        fileP = new FileWriter(documentP, true);
                                        lineP = new PrintWriter(fileP);
                                        fileP.write(listCos.toString());
                                        lineP.close();
                                        fileP.close();        
                                        }else{
                                        fileP = new FileWriter(documentP, true);
                                        lineP = new PrintWriter(fileP);
                                        fileP.write(listCos.toString());
                                        lineP.close();
                                        fileP.close(); 
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Insert Type of the Other -->");
                                        typeOfMed = keyboardinput2.next();
                                        System.out.println("Insert stock-->");
                                        stock = keyboardinput2.nextInt();
                                        System.out.println("Insert price-->");
                                        price = keyboardinput2.nextFloat();

                                        Others other = new Others(typeOfMed, stock, price);

                                        JSONObject jsonOther = new JSONObject();
                                        jsonOther.put("typeOfMedicin",other.getTypeOfMedicine());
                                        jsonOther.put("stock",other.getStock());
                                        jsonOther.put("price", other.getPrice());
                                        
                                        productData.put("other",jsonOther);
                                        
                                        JSONArray listOther = new JSONArray();
                                        
                                        listOther.add(productData);
                                        if (!documentP.exists()){                       
                                            documentP.createNewFile();
                                        fileP = new FileWriter(documentP, true);
                                        lineP = new PrintWriter(fileP);
                                        fileP.write(listOther.toString());
                                        lineP.close();
                                        fileP.close();        
                                        }else{
                                        fileP = new FileWriter(documentP, true);
                                        lineP = new PrintWriter(fileP);
                                        fileP.write(listOther.toString());
                                        lineP.close();
                                        fileP.close(); 
                                        }
                                        break;

                                }
                                break;
                            case 2:  
                                JSONParser parserP = new JSONParser();
                                FileReader readerP = new FileReader("products.json");
                                Object objP = parserP.parse(readerP);
                                JSONArray productList = (JSONArray) objP;
                                System.out.println(productList);
                                for (Object product : productList) {
                                    showInfoProduct((JSONObject) product);

                                }
                                Thread.sleep(5000);
                                break;
                            case 3:
                                selectOp=5;
                                break;

                        }

                    } while (selectOp == 3 || selectOp == 1 || selectOp == 2);

                    break;
                case 3:
                    System.out.println("Ingreso de Clientes.");
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
                                for (Object client : clienList) {
                                    showInfoClient((JSONObject) client);

                                }
                                Thread.sleep(5000);
                                break;

                            case 3:
                                selectOption = 5;

                                break;

                        }
                    } while (selectOption == 3 || selectOption == 1 || selectOption == 2);

                    break;
                case 4:
                    System.out.println("Gracias por ocupar el programa.");
                    break;
                default:
                    System.out.println("Eliga una de las opciones.");
            }
        } while (option != 4);
    }

    private static void showInfoClient(JSONObject jsonObject) {
        JSONObject client = (JSONObject) jsonObject.get("client");
        System.out.println("CLIENTES");
        long id = ((Number) client.get("id")).longValue();
        System.out.println("Id-->" + id);
        String name = (String) client.get("name");
        System.out.println("Name-->" + name);
        String adress = (String) client.get("adress");
        System.out.println("Adress-->" + adress);
        long phone = ((Number) client.get("phoneNumber")).longValue();
        System.out.println("Phone-->" + phone);
        long card = ((Number) client.get("creditCard")).longValue();
        System.out.println("CreditCard-->" + card);

    }

    private static void showInfoProduct(JSONObject jsonObject) {
        JSONObject product = (JSONObject) jsonObject.get("medicin");
        System.out.println("Medicins");
        String type = (String) product.get("typeOfMedicin");
        System.out.println("type od medicin-->" + type);
        long stock = ((Number) product.get("stock")).longValue();
        System.out.println("Stock-->" + stock);
        String price = (String) product.get("price").toString();
        System.out.println("price-->" + price);
        
    }

}
