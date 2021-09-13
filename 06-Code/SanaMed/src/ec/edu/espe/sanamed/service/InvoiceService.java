package ec.edu.espe.sanamed.service;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.sanamed.core.DatabaseManager;
import ec.edu.espe.sanamed.core.Service;
import ec.edu.espe.sanamed.model.Invoice;
import ec.edu.espe.sanamed.model.InvoiceItem;
import ec.edu.espe.sanamed.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author 
 */
public class InvoiceService extends Service {
    private MongoCollection collection;
    
    public InvoiceService(DatabaseManager database) {
        super(database);
        collection = database.getCollection("invoices");
    }
    
    public void add(Invoice invoice) {
        List<Document> items = new ArrayList<>();
        
        for (InvoiceItem item : invoice.getItems()) {
            Product product = item.getProduct();
            Document productDocument = new Document()
                .append("_id", new ObjectId())
                .append("id", product.getId())
                .append("description", product.getDescription())
                .append("type", product.getType())
                .append("price", product.getPrice())
                .append("name", product.getName());
            
            Document document = new Document()
                .append("_id", new ObjectId())
                .append("product", productDocument)
                .append("total", item.getTotal());
            
            items.add(document);
        }
        
        Document customerDocument = new Document()
            .append("_id", new ObjectId())
            .append("name", invoice.getCustomer().getName())
            .append("address", invoice.getCustomer().getAddress())
            .append("email", invoice.getCustomer().getEmail())
            .append("branchOffice", invoice.getCustomer().getBrainchOffice())
            .append("phone", invoice.getCustomer().getPhone());
        
        Document document = new Document()
            .append("_id", new ObjectId())
            .append("customer", customerDocument)
            .append("items", items);
        
        collection.insertOne(document);
    }
}
