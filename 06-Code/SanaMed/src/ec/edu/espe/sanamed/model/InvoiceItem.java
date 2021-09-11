package ec.edu.espe.sanamed.model;

/**
 *
 * @author 
 */
public class InvoiceItem {
    private Product product;
    private int total;

    public InvoiceItem(Product product, int total) {
        this.product = product;
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
};