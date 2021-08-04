/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.SanamedAccountSystem.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class UserJson {
    public void createJson(User user){
        JSONObject user1 = new JSONObject();
        user1.put("Name", user.getNameUser());
        user1.put("Password", user.getPassword());
        
        JSONObject userData1 = new JSONObject();
        userData1.put("User", user1);
        
        JSONArray listUsers = new JSONArray();
        listUsers.add(userData1);
        
        try(FileWriter file = new FileWriter("users.json")){
            file.write(listUsers.toString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        } 
    }
    
    public void userVerification(String userName, String userPassword){
        JSONParser jsonParser = new JSONParser();
        int verification=0;
        
        try(FileReader reader = new FileReader("users.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;
            
            for(int i=0; i<userList.size(); i++){
                Object user = userList.get(i);
                verification = dataComparison((JSONObject) user, userName, userPassword);
                if(verification == 1){
                    i = userList.size()+1;
                }
            }
            if (verification == 1){
                System.out.println("Ingreso correcto");
            }else
            {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                System.out.println("El usuario no existe.");
            }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }  
    }
    
    public int dataComparison(JSONObject jsonObject, String userName, String userPassword){
        int numberVerification=0;
        JSONObject user = (JSONObject) jsonObject.get("User");
        String name = (String) user.get("Name");
        String password = (String) user.get("Password");
        
        //Validacion
        String testPassword;
        Scanner scan = new Scanner(System.in);
        
        if (name.equalsIgnoreCase(userName)){
            System.out.println("Usuario Encontrado.");
            if(password.equalsIgnoreCase(userPassword)){
                    numberVerification=1;
            }
        } 
        return numberVerification;      
    }
    
    public void comparacion(){
        User user = new User();
        if (user.getNameUser() == "098"){
            
        }
    }
    
    public void addUser(User userAdd) {
        JSONParser jsonParser = new JSONParser();
        JSONObject user1 = new JSONObject();

        try (FileReader reader = new FileReader("users.json")) {
            Object obj = jsonParser.parse(reader);

            user1.put("Name", userAdd.getNameUser());
            user1.put("Password", userAdd.getPassword());

            JSONObject userData1 = new JSONObject();
            userData1.put("User", user1);
            
            JSONArray userList = (JSONArray) obj; 
            userList.add(userData1);

            try (FileWriter file = new FileWriter("users.json")) {
                file.write(userList.toString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public void readJson(){
        JSONParser jsonParser = new JSONParser();
        
        try(FileReader reader = new FileReader("users.json")){
            Object obj = jsonParser.parse(reader);
            
            JSONArray userList = (JSONArray) obj;
            System.out.println("El archivo contiene lo siguiente: ");
            System.out.println(userList);
            
            for(Object user: userList){
                mostrarInformacionPersona((JSONObject) user);
            }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }       
    }
    
     private void mostrarInformacionPersona(JSONObject jsonObject) {
        JSONObject user = (JSONObject) jsonObject.get("User");
        System.out.println("Personas dentro del JSON.");
        String name = (String) user.get("Name");
        System.out.println("Nombre: " +name);
        
        String password = (String) user.get("Password");
        System.out.println("Contraseña: " +password);
    }
}
