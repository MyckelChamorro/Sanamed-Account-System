/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.SanamedAccountSystem.model;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class Pharmacy {
    
    private String name;
    private String branchOffice;
    private String userOfCashier;
    private String password;

    public Pharmacy() {
    }

    public Pharmacy(String name, String branchOffice, String userOfCashier, String password) {
        this.name = name;
        this.branchOffice = branchOffice;
        this.userOfCashier = userOfCashier;
        this.password = password;
    }

    public String getUserOfCashier() {
        return userOfCashier;
    }

    public void setUserOfCashier(String userOfCashier) {
        this.userOfCashier = userOfCashier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
     * @return the branchOffice
     */
    public String getBranchOffice() {
        return branchOffice;
    }

    /**
     * @param branchOffice the branchOffice to set
     */
    public void setBranchOffice(String branchOffice) {
        this.branchOffice = branchOffice;
    }
    
    //Ingreso de usuario
    public void logginCashier(String userlog){
        String userPassword;
        Scanner scan = new Scanner(System.in);
        if (userlog.equalsIgnoreCase(this.userOfCashier))
        {
            System.out.println("Ingrese una contraseña: ");
            userPassword = scan.nextLine();
            while(userPassword.equalsIgnoreCase(this.password)==false){
                System.out.println("Contraseña incorrecta.");
                System.out.println("Ingrese una contraseña: ");
                userPassword = scan.nextLine();
            }
            System.out.println("Paso el ingreso del usuario :D");
            System.out.println("Usuario: " +this.userOfCashier);
        }
        else
        {
            System.out.println("El usuario no existe.");
            System.exit(0);
        }
    }
    
}
