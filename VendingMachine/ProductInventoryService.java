package VendingMachine;

import java.util.Map;

public class ProductInventoryService {
    private Map<Integer, Product> productInventory;

    public ProductInventoryService(Map<Integer, Product> productInventory) {
        this.productInventory = productInventory;
    }

    public Product getProduct(Integer productId) {
        Product selectedProduct = productInventory.get(productId);
        return selectedProduct;
    }

    public void decrementProduct(Product product) {
        product.decrementQuantity();
    }
}
