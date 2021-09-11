package ec.edu.espe.sanamed.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class Invoice {
    private Customer customer;
    private List<InvoiceItem> items = new ArrayList<>();

    public Invoice(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }
    
    public void addItem(InvoiceItem item) {
        items.add(item);
    }
    
    public void addItems(List<InvoiceItem> items) {
        items.addAll(items);
    }
}
