package ec.edu.espe.sanamed.service;

import com.google.gson.Gson;
import ec.edu.espe.sanamed.model.User;
import ec.edu.espe.sanamed.core.DatabaseManager;
import ec.edu.espe.sanamed.core.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class UserService extends Service {
    private Gson gson = new Gson();
    
    public UserService(DatabaseManager database) {
        super(database);
    }
    
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        
        try {
            Path jsonPath = Paths.get("users.json");
            String json = new String(Files.readAllBytes(jsonPath));
            User[] usersArray = gson.fromJson(json, User[].class);
            users.addAll(Arrays.asList(usersArray));
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
        
        return users;
    }
    
    public User get(String username) {
        List<User> users = getAll();
        
        for (User user : users) {
            if (user.getUsername().trim().equalsIgnoreCase(username.trim())) {
                return user;
            }
        }
        
        return null;
    }

    public boolean emailExists(String email) {
        List<User> users = getAll();
        
        for (User user : users) {
            if (user.getEmail().trim().equalsIgnoreCase(email.trim())) {
                return true;
            }
        }
        
        return false;
    }

    public void add(User user) {
        List<User> users = getAll();
        users.add(user);
        String json = gson.toJson(users.toArray());
        Path path = Paths.get("users.json");
        
        try {
            Files.write(path, json.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
