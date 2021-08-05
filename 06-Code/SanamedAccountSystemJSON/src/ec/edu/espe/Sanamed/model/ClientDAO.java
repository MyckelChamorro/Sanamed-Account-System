/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import ec.edu.espe.Sanamed.view.FrmBill;
import ec.edu.espe.Sanamed.view.ProductFrm;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class ClientDAO {
    public void insertClient(Client c){
        ConexionClient con = new ConexionClient();
        BasicDBObject documento = new BasicDBObject();
        documento.put("name","'" +c.getName()+ "'");
        documento.put("id","'" +c.getId()+ "'");
        documento.put("direction","'" +c.getDirection()+ "'");
        documento.put("email","'" +c.getEmail()+ "'");
        documento.put("brainchOffice","'" +c.getBrainchOffice()+ "'");
        documento.put("phone","'" +c.getPhone()+ "'");
        con.coleccion.insert(documento);
    }
    
    
}
