package ec.edu.espe.sanamed.core;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ec.edu.espe.sanamed.controller.AuthController;
import ec.edu.espe.sanamed.controller.InvoiceController;
import ec.edu.espe.sanamed.controller.MainController;
import ec.edu.espe.sanamed.controller.ProductsController;
import ec.edu.espe.sanamed.controller.UsersController;
import ec.edu.espe.sanamed.service.AuthService;
import ec.edu.espe.sanamed.service.InvoiceService;
import ec.edu.espe.sanamed.service.ProductService;
import ec.edu.espe.sanamed.service.UserService;

/**
 *
 * @author
 */
public class Application {
    private DatabaseManager dbManager;
    private Map<Class, Service> services = new HashMap<>();
    private Map<Class, Controller> controllers = new HashMap<>();
    
    private Application() {
        // configure swing and another UI tweaks
        setupUISettings();
        
        // register core, services and controllers
        registerDependencies();
        
        // initialize all controllers
        for (Controller controller : controllers.values()) {
            controller.initialize();
        }
    }
    
    public final void registerDependencies() {
        // registrar base de datos
        dbManager = new DatabaseManager();
        
        // registrar los servicios
        registerService(UserService.class);
        registerService(AuthService.class);
        registerService(ProductService.class);
        registerService(InvoiceService.class);
        
        // registrar todos los controladores
        registerController(AuthController.class);
        registerController(MainController.class);
        registerController(UsersController.class);
        registerController(ProductsController.class);
        registerController(InvoiceController.class);
    }
    
    public <T extends Controller> T getController(Class<T> controllerClass) {
        return (T) controllers.get(controllerClass);
    }
    
    public <T extends Service> T getService(Class<T> serviceClass) {
        return (T) services.get(serviceClass);
    }
    
    public <T extends Controller> void registerController(Class<T> controllerClass) {
        if (controllers.containsKey(controllerClass)) {
            return;
        }
        
        try {
            T controller = controllerClass
                .getConstructor(getClass())
                .newInstance(this);
            
            controllers.put(controllerClass, controller);
            
            System.out.println(
                "controller '"
                + controller.getClass().getSimpleName()
                + "' registered"
            );
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }
    
    public <T extends Service> void registerService(Class<T> serviceClass) {
        if (services.containsKey(serviceClass)) {
            return;
        }
        
        try {
            T service = serviceClass
                .getConstructor(DatabaseManager.class)
                .newInstance(dbManager);
            
            services.put(serviceClass, service);
            
            System.out.println(
                "service '"
                + service.getClass().getSimpleName()
                + "' registered"
            );
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }

    private void setupUISettings() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new Application();
    }
}
