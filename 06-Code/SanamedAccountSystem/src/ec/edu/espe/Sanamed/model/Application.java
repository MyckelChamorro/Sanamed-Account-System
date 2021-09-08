package ec.edu.espe.Sanamed.model;

import ec.edu.espe.Sanamed.view.LoginFrm;

/**
 *
 * @author 
 */
public class Application {
    private LoginFrm loginFrm;
    
    public Application() {
        loginFrm = new LoginFrm();
    }
    
    public void initialize() {
        loginFrm.setVisible(true);
    }
    
    public static void main(String[] args) {
        Application app = new Application();
        app.initialize();
    }
}
