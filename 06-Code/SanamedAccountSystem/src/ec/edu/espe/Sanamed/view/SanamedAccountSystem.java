/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.view;

import ec.edu.espe.SanamedAccountSystem.model.Client;
import ec.edu.espe.SanamedAccountSystem.model.Cosmetic;
import ec.edu.espe.SanamedAccountSystem.model.Medicins;
import ec.edu.espe.SanamedAccountSystem.model.Others;
import ec.edu.espe.SanamedAccountSystem.model.Pharmacy;
import ec.edu.espe.SanamedAccountSystem.model.Product;
import ec.edu.espe.SanamedAccountSystem.model.ShoppingList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class SanamedAccountSystem {
    public static void main(String[] args) {
        
//        boolean loggin=false;
//        Medicins medicine;
//        Cosmetic cosmetic;
//        Others other;
//        int quantity;
//        float individualValue;
//        ArrayList<Product> products = new ArrayList<>();
//        Product productsArray[] = new Product[5];
//        
//        Product product1 = new Product("Medicine", 2, 4.5F);
//        Product product2 = new Product("Cosmetic", 1, 5.5F);
//        Product product3 = new Product("Medicine", 5, 6F);
//        
//        products.add(product1);
//        products.add(product2);
//        products.add(product1);
//        
//        System.out.println("----- ARRAYLIST -----");
//        System.out.println("Products: " +products+ "\n");
//        
//        productsArray[0] = product1;
//        productsArray[1] = product3;
//        
//        System.out.println("-----  ARREGLO  -----");
//        System.out.println("Product Array: " +productsArray[0]);
//        System.out.println("Product Array; " +productsArray[1]);

        //Medicinas
        Medicins medicina1 = new Medicins("Paracetamol", 5, 0.20F);
        Medicins medicina2 = new Medicins("Aspirina", 10, 0.50F);
        Medicins medicina3 = new Medicins("Jarabe para la tos", 7, 3.5F);
        Medicins medicina4 = new Medicins("Buscapina", 10, 0.5F);
        Medicins medicina5 = new Medicins("Finalin Forte", 10, 0.7F);
        //Cosmeticos
        Cosmetic comsetico1 = new Cosmetic("Crema Nivea", 7, 0.5F);
        Cosmetic comsetico2 = new Cosmetic("Rimel", 6, 1F);
        Cosmetic comsetico3 = new Cosmetic("Maquillaje", 8, 1.5F);
        Cosmetic comsetico4 = new Cosmetic("Labial", 6, 0.5F);
        Cosmetic comsetico5 = new Cosmetic("Sombra", 8, 0.7F);
        //Otros
        Others otros1 = new Others("Pañales", 5, 5.5F);
        Others otros2 = new Others("Bebidas energeticas", 8, 3.5F);
        Others otros3 = new Others("Snickers", 10, 50F);
        Others otros4 = new Others("Vitaminas", 10, 4F);
        Others otros5 = new Others("Crema de peinar", 5, 3.5F);        
        
        
        Pharmacy pharma = new Pharmacy("Sanamed", "npi", "Aleja", "clave");
        
        //INICIO DE SESION
        String userLog = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------| INGRESO DE USUARIO |----------------------");
        System.out.println("Ingrese su usuario: ");
        userLog= scan.nextLine();
        pharma.logginCashier(userLog);
        
        //MENU
        int opcion=0;
        String op="";
            System.out.println("------------------------| MENU PRINCIPAL |----------------------");
            System.out.println("1. Realizar venta.");
            System.out.println("2. Busqueda de productos.");
            System.out.println("3. Imprimir.");
            System.out.println("4. Salir");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Seleccione una opcion: ");
            op = scan.nextLine();
            System.out.println("--------------------------------------------------------------");
        opcion = Integer.parseInt(op);
        switch(opcion){
            case 1: 
                System.out.println("...");
                break;
            case 2: 
                ArrayList<Product> ShoppingList = new ArrayList<Product>();
                ShoppingList list2 = new ShoppingList();
                Product product1 = new Product();
                String tipoDeProducto;
                System.out.println("---------------------| Seleccion de productos |---------------------------");
                System.out.println("Tipo de producto: ");
                tipoDeProducto = scan.nextLine();
                if(tipoDeProducto.equalsIgnoreCase("Medicinas"))
                {
                    int opcionMedicina;
                    System.out.println("Medicinas");
                    System.out.println("1. Paracetamol\n"
                            + "2. Aspirina\n"
                            + "3. Jarabe para la tos.\n"
                            + "4. Buscapina\n"
                            + "5. Finalin Forte\n");
                    System.out.println("Seleccione: ");
                    opcionMedicina = scan.nextInt();
                    //System.out.println(""+opcionMedicina);
                    if(opcionMedicina == 1)
                    {
                        product1.addMedicine(medicina1);
                        ShoppingList.add(product1);
                        break;
                    }
                    else if(opcionMedicina == 2)
                    {
                        product1.addMedicine(medicina2);
                        ShoppingList.add(product1);
                        System.out.println("hola " +ShoppingList);
                        break;
                    }
                    else if (opcionMedicina == 3){
                        product1.addMedicine(medicina3);
                        ShoppingList.add(product1);
                        break;
                    }
           
                }
                Iterator<Product> it = ShoppingList.iterator();
                int contador = 0;
                while(it.hasNext()){
                    list2.agregarProducto(product1);
                }
                System.out.println("");
                break;
            case 3: 
                int opcionImpresion;
                Client cliente = new Client();
                Pharmacy pharm = new Pharmacy();
                ShoppingList list = new ShoppingList();
                System.out.println("Seleccione: ");
                System.out.println("1. Imprimir factura.");
                System.out.println("2. Imprimir consumidor final.");
                opcionImpresion = scan.nextInt();
                if(opcionImpresion == 1){
                    System.out.println("-------------------------------| FACTURA |---------------------------------");
                    System.out.println("Datos Cliente.");
                    System.out.println("Cliente: " +cliente.getName());
                    System.out.println("Direccion: " +cliente.getAdress());
                    System.out.println("ID: " +cliente.getId());
                    System.out.println("Datos Farmacia.");
                    System.out.println("Nombre: " +pharm.getName());
                    System.out.println("Sucursal: " +pharm.getBranchOffice());
                    System.out.println("Cajera: " +pharm.getUserOfCashier());
                    System.out.println("----------------------------------------------------------------------------");
                    list.imprimirLista();
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("Total a pagar                                               " +list.getTotalValue()+ "$");
                    
                }else{
                    System.out.println("---------------------------| FARMACIA SANAMED |-----------------------------");
                    System.out.println("Sucursal: " +pharm.getBranchOffice());
                    System.out.println("----------------------------------------------------------------------------");
                    list.imprimirLista();
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("Total a pagar                                               " +list.getTotalValue()+ "$");
                }
                break;
            case 4: 
                System.out.println("GRACIAS POR USAR EL PROGRAMA.");
                break;
            default: 
                JOptionPane.showMessageDialog(null, "Eliga una de las opciones", "Error", JOptionPane.WARNING_MESSAGE);
        }while(opcion!=4);
        }
        
    } 
