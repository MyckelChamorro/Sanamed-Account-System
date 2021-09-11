package ec.edu.espe.sanamed.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.sanamed.core.DatabaseManager;
import ec.edu.espe.sanamed.core.Service;
import ec.edu.espe.sanamed.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author 
 */
public class ProductService extends Service {
    MongoCollection collection;
    
    public ProductService(DatabaseManager database) {
        super(database);
        collection = database.getCollection("products");
    }
    
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        FindIterable<Document> documents = collection.find();
        
        for (Document document : documents) {
            Product product = new Product(
                document.getString("id"),
                document.getString("name"),
                document.getString("description"),
                document.getString("type"),
                document.getDouble("price")
            );
            
            products.add(product);
        }
        
        return products;
    }
    
    public boolean exists(String id) {
        return collection.find(
            new Document("id", new Document("$eq", id))).first() != null;
    }
    
    public void add(Product product) {
        Document document = new Document()
            .append("_id", new ObjectId())
            .append("id", product.getId())
            .append("name", product.getName())
            .append("description", product.getDescription())
            .append("type", product.getType())
            .append("price", product.getPrice());
        
        collection.insertOne(document);
    }
}
