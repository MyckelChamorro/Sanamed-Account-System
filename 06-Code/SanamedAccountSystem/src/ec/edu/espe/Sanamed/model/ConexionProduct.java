/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class ConexionProduct {
    DB baseDatos;
    DBCollection coleccion;
    BasicDBObject documento = new BasicDBObject();
    MongoClientURI uri = new MongoClientURI("mongodb+srv://Esteban:pooEspe123@cluster0.seaw1.mongodb.net/Sanamed?retryWrites=true&w=majority");

//Problems in Modular Reasoning because the conexion should be a method
    
    public ConexionProduct()
    {
        try{
            MongoClient mongo = new MongoClient(uri);
            baseDatos = mongo.getDB("Sanamed");
            coleccion = baseDatos.getCollection("products");
            System.out.println("Conexion a base de datos exitoso.");
        }
        catch(Exception e)
        {
            
        }
    }
}
