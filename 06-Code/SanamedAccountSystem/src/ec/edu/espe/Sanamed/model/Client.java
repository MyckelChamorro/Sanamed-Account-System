/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.model;

/**
 *
 * @author Esteban
 */
public class Client {

   private String name;
   private String id;
   private String Direction;
   private String email;
   private String brainchOffice;
   private String phone;

    public Client() {
    }

    public Client(String name, String id, String Direction, String email, String brainchOffice, String phone) {
        this.name = name;
        this.id = id;
        this.Direction = Direction;
        this.email = email;
        this.brainchOffice = brainchOffice;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String Direction) {
        this.Direction = Direction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrainchOffice() {
        return brainchOffice;
    }

    public void setBrainchOffice(String brainchOffice) {
        this.brainchOffice = brainchOffice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", id=" + id + ", Direction=" + Direction + ", email=" + email + ", brainchOffice=" + brainchOffice + ", phone=" + phone + '}';
    }
   
   
    
    
}
