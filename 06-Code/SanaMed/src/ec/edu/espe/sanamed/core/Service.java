package ec.edu.espe.sanamed.core;

/**
 *
 * @author 
 */
public abstract class Service {
    protected final DatabaseManager database;
    
    public Service(DatabaseManager database) {
        this.database = database;
    }
}
