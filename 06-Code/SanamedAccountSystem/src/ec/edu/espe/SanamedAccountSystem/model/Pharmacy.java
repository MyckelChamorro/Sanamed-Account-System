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
public class Pharmacy {
    
    private String name;
    private String branchOffice;

    public Pharmacy() {
    }

    public Pharmacy(String name, String branchOffice) {
        this.name = name;
        this.branchOffice = branchOffice;
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
    
    
    
}
