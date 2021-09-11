package ec.edu.espe.sanamed.controller;

import ec.edu.espe.sanamed.core.Application;
import ec.edu.espe.sanamed.core.Controller;
import ec.edu.espe.sanamed.model.Product;
import ec.edu.espe.sanamed.service.ProductService;
import ec.edu.espe.sanamed.view.AddProductView;
import ec.edu.espe.sanamed.view.ProductsListView;
import java.util.function.BiConsumer;

/**
 *
 * @author 
 */
public class ProductsController extends Controller {
    private ProductService productService;
    
    public ProductsController(Application app) {
        super(app);
        productService = app.getService(ProductService.class);
    }

    @Override
    public void initialize() {
        MainController mainController = app.getController(MainController.class);
        mainController.registerWindowView("products::view", new ProductsListView(this));
        mainController.registerWindowView("products::add", new AddProductView(this));
        mainController.showWindowView("products::view");
    }
    
    public ProductService getProductService() {
        return productService;
    }

    public void addProduct(Product product, BiConsumer<Boolean, String> callback) {
        if (productService.exists(product.getId())) {
            callback.accept(false, "El id ingresado ya existe");
        } else {
            try {
                productService.add(product);
                callback.accept(true, null);
            } catch (Exception e) {
                callback.accept(false, "Ocurrio un error al intentar guardar el producto, intentelo denuevo");
            }
        }
    }
}
