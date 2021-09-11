package ec.edu.espe.sanamed.service;

import ec.edu.espe.sanamed.core.DatabaseManager;
import ec.edu.espe.sanamed.core.Service;
import ec.edu.espe.sanamed.model.User;

/**
 *
 * @author 
 */
public class AuthService extends Service {
    private UserService userService;
    public AuthService(DatabaseManager database) {
        super(database);
        userService = new UserService(database);
    }
    
    public boolean login(String username, String password) {
        User user = userService.get(username);
        
        if (user == null) {
            return false;
        }
        
        if (user.getPassword().equals(password)) {
            return true;
        }
        
        return false;
    }
}
