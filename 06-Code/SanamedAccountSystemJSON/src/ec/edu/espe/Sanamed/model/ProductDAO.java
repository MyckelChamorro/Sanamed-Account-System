/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import ec.edu.espe.Sanamed.view.FrmBill;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class ProductDAO {
     public void insertProduct(Product p){
        ConexionProduct con = new ConexionProduct();
        BasicDBObject documento = new BasicDBObject();
        documento.put("type","'" +p.getType()+ "'");
        documento.put("name","'" +p.getName()+ "'");
        documento.put("id","'" +p.getId()+ "'");
        documento.put("description","'" +p.getDescription()+ "'");
        documento.put("price","'" +p.getPrice()+ "'");
        con.coleccion.insert(documento);    
    }
     
    public void  mostrarColeccion(FrmBill vista){
        ConexionProduct objCon = new ConexionProduct();
        DBCursor cursor = objCon.coleccion.find();
        
        Object [] objeto = new Object[3];
        
        
        while(cursor.hasNext()){
            System.out.println(cursor.next());
            vista.txtFieldDatos.setText((String) vista.txtFieldDatos.getText()+ "\n" +cursor.next().get("name"));
        }    
    }
     
}
