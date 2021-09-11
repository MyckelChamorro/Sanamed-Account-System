/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import ec.edu.espe.Sanamed.view.FrmBill;
import ec.edu.espe.Sanamed.view.ProductsSearch;
import java.util.ArrayList;

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
    
    public ArrayList mostrarDatos(ProductsSearch v){
        ConexionProduct objCon = new ConexionProduct();
        DBCursor cursor = objCon.coleccion.find();
        String name = null;
        String type = null;
        String id = null;
        String description = null;
        String priceString = null;
        float price;
        
        ArrayList<Product> products = new ArrayList();
        ArrayList listNames = new ArrayList();
        ArrayList listTypes = new ArrayList();
        ArrayList listIds = new ArrayList();
        ArrayList listDescriptions = new ArrayList();
        ArrayList listPrices = new ArrayList();
        
        while(cursor.hasNext()){
            type = (String) cursor.next().get("type");
            System.out.println("Tipo: " +type);
            listTypes.add(type);
            
            name = (String) cursor.curr().get("name");
            System.out.println("Nombre: " +name);
            listNames.add(name);
            
            id = (String) cursor.curr().get("id");
            System.out.println("Id: " +id);
            listIds.add(id);
            
            description = (String) cursor.curr().get("description");
            System.out.println("Descripcion: " +description);
            listDescriptions.add(description);
            
            priceString = (String) cursor.curr().get("price");
            price = Float.parseFloat(priceString);
            listPrices.add(price);
            
            Product productArray = new Product(type, name, id, description, price);
            System.out.println("-> " +productArray);
            products.add(productArray);
        }
        System.out.println("Lista Nombres: " +listNames);
        System.out.println("Lista Tipos: " +listTypes);
        System.out.println("Lista id: " +listIds);
        System.out.println("Lista Descripcion: " +listDescriptions);
        System.out.println("Lista precios: " +listPrices);
        System.out.println("Productos: " +products);
        
        return products;
    }
     
}
