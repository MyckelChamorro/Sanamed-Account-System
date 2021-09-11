package ec.edu.espe.sanamed.controller;

import java.util.function.Consumer;
import ec.edu.espe.sanamed.core.Application;
import ec.edu.espe.sanamed.core.Controller;
import ec.edu.espe.sanamed.service.AuthService;
import ec.edu.espe.sanamed.view.AuthWindow;

/**
 *
 * @author 
 */
public class AuthController extends Controller {
    private AuthWindow window = new AuthWindow(this);
    private AuthService authService;
    
    public AuthController(Application app) {
        super(app);
        authService = app.getService(AuthService.class);
    }

    @Override
    public void initialize() {
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public void doLogin(String username, String password, Consumer<Boolean> callback) {
        boolean loggedIn = authService.login(username, password);
        callback.accept(loggedIn);
        
        if (loggedIn) {
            MainController mainController = app.getController(MainController.class);
            mainController.start();
            window.dispose();
        }
    }
}
