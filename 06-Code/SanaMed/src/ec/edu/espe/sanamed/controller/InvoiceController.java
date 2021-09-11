package ec.edu.espe.sanamed.controller;

import ec.edu.espe.sanamed.core.Application;
import ec.edu.espe.sanamed.core.Controller;
import ec.edu.espe.sanamed.model.Invoice;
import ec.edu.espe.sanamed.service.InvoiceService;
import ec.edu.espe.sanamed.service.ProductService;
import ec.edu.espe.sanamed.view.CreateInvoiceView;

/**
 *
 * @author 
 */
public class InvoiceController extends Controller {
    private InvoiceService invoiceService;
    
    public InvoiceController(Application app) {
        super(app);
        invoiceService = app.getService(InvoiceService.class);
    }

    @Override
    public void initialize() {
        MainController mainController = app.getController(MainController.class);
        mainController.registerWindowView("invoices::new", new CreateInvoiceView(this));
    }
    
    public ProductService getProductService() {
        return app.getService(ProductService.class);
    }

    public void saveInvoice(Invoice invoice) {
        invoiceService.add(invoice);
    }
}
