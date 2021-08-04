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
public class User {
    private String nameUser;
    private String password;

    public User(String nameUser, String password) {
        this.nameUser = nameUser;
        this.password = password;
    }

    public User() {
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
