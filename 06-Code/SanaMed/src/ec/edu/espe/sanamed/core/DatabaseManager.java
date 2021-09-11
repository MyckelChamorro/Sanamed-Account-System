package ec.edu.espe.sanamed.core;

import com.mongodb.client.MongoCollection;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author 
 */
public class DatabaseManager {
    private MongoClient mongoClient;
    private MongoDatabase database;
    
    public DatabaseManager() {
        mongoClient = MongoClients.create("mongodb+srv://Esteban:pooEspe123@cluster0.seaw1.mongodb.net/Sanamed?retryWrites=true&w=majority");
        database = mongoClient.getDatabase("sanamedpharmacy");
    }
    
    public MongoCollection getCollection(String name) {
        return database.getCollection(name);
    }
}
