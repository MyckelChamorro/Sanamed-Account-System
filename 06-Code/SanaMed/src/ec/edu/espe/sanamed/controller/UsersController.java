package ec.edu.espe.sanamed.controller;

import ec.edu.espe.sanamed.core.Application;
import ec.edu.espe.sanamed.core.Controller;
import ec.edu.espe.sanamed.model.User;
import ec.edu.espe.sanamed.service.UserService;
import ec.edu.espe.sanamed.view.AddUserView;
import ec.edu.espe.sanamed.view.UsersListView;
import java.util.function.BiConsumer;

/**
 *
 * @author 
 */
public class UsersController extends Controller {
    private UserService userService;
    
    public UsersController(Application app) {
        super(app);
        userService = app.getService(UserService.class);
    }

    @Override
    public void initialize() {
        MainController mainController = app.getController(MainController.class);
        mainController.registerWindowView("users::add", new AddUserView(this));
        mainController.registerWindowView("users::view", new UsersListView(this));
    }

    public void addUser(User user, BiConsumer<Boolean, String> callback) {
        if (userService.get(user.getUsername()) != null) {
            callback.accept(false, "El nombre de usuario ya existe");
            return;
        }
        
        if (userService.emailExists(user.getEmail())) {
            callback.accept(false, "El nombre de usuario ya existe");
            return;
        }
        
        userService.add(user);
        callback.accept(true, null);
    }
    
    public UserService getUserService() {
        return userService;
    }
}
