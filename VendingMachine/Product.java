package VendingMachine;

public class Product {
    private Integer productId;

    private String productName;

    private Integer quantity;

    private Integer price;

    public Product(Integer productId, String productName, Integer quantity, Integer price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void decrementQuantity() {
        if (quantity <= 0) {
            throw new IllegalStateException("Product out of stock");
        }
        quantity--;
    }
}
