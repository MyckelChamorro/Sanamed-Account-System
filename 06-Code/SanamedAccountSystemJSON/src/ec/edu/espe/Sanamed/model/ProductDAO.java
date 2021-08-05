/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.model;

import com.mongodb.BasicDBObject;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class ProductDAO {
     public void insertProduct(Product p){
        ConexionP con = new ConexionP();
        BasicDBObject documento = new BasicDBObject();
        documento.put("type","'" +p.getType()+ "'");
        documento.put("name","'" +p.getName()+ "'");
        documento.put("id","'" +p.getId()+ "'");
        documento.put("description","'" +p.getDescription()+ "'");
        documento.put("price","'" +p.getPrice()+ "'");
        con.coleccion.insert(documento);    
    }
}
