package ec.edu.espe.sanamed.controller;

import javax.swing.JFrame;
import ec.edu.espe.sanamed.core.Application;
import ec.edu.espe.sanamed.core.Controller;
import ec.edu.espe.sanamed.core.View;
import ec.edu.espe.sanamed.view.MainWindow;

/**
 *
 * @author 
 */
public class MainController extends Controller {
    private final MainWindow window = new MainWindow(this);
    
    public MainController(Application app) {
        super(app);
    }
    
    @Override
    public void initialize() {
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void start() {
        window.setVisible(true);
    }
    
    public <T extends View> void registerWindowView(String event, T view) {
        window.registerView(event, view);
    }
    
    public void showWindowView(String name) {
        window.displayView(name);
    }
}
