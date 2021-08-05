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
public class Product {
    private String type;
    private String name;
    private String id;
    private String Description;
    private float price;

    public Product() {
    }

    public Product(String type, String name, String id, String Description, float price) {
        this.type = type;
        this.name = name;
        this.id = id;
        this.Description = Description;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "type=" + type + ", name=" + name + ", id=" + id + ", Description=" + Description + ", price=" + price + '}';
    }
}
