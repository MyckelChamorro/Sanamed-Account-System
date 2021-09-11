package ec.edu.espe.sanamed.core;

/**
 *
 * @author 
 */
public abstract class Controller {
    protected final Application app;
    
    public Controller(Application app) {
        this.app = app;
    }
    
    public abstract void initialize();
}
