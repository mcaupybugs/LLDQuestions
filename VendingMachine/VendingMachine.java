package VendingMachine;

import java.util.*;

public class VendingMachine {
    private VendingMachineState currentState;
    private final CoinInventoryService coinInventoryService;
    private final ProductInventoryService productInventoryService;
    private int insertedCash;
    private Product selectedProduct;

    public VendingMachine(Map<Integer, Product> productInventory, Map<Integer, Integer> coinInventory) {
        this.productInventoryService = new ProductInventoryService(productInventory);
        this.coinInventoryService = new CoinInventoryService(coinInventory);
        this.currentState = new IdleState();
        this.insertedCash = 0;
    }

    public VendingMachineState getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }

    public void insertCoins(List<Integer> coins) {
        currentState.insertCoin(this, coins);
    }

    public void selectProduct(Integer productId) {
        currentState.selectProduct(this, productId);
    }

    public void confirmPayment() {
        currentState.confirmPayment(this);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct(this);
    }

    public void cancelTransaction() {
        currentState.cancelTransaction(this);
    }

    public void addInsertedCoins(List<Integer> coins) {
        for (Integer coin : coins) {
            this.insertedCash += coin;
        }
        coinInventoryService.addCoins(coins);
    }

    public void setSelectedProduct(Integer productId) {
        Product product = productInventoryService.getProduct(productId);
        if (product == null || product.getQuantity() == 0) {
            throw new IllegalArgumentException("No product found");
        }
        this.selectedProduct = product;
    }

    public int getInsertedCash() {
        return insertedCash;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public boolean hasSufficientFunds() {
        return selectedProduct != null && insertedCash >= selectedProduct.getPrice();
    }

    public boolean canReturnChange() {
        if (selectedProduct == null) {
            return false;
        }
        int remainingCash = insertedCash - selectedProduct.getPrice();
        return remainingCash >= 0 && coinInventoryService.findChangeAvailable(remainingCash);
    }

    public void performDispense() {
        productInventoryService.decrementProduct(selectedProduct);
    }

    public void performReturnChange() {
        int remainingCash = insertedCash - selectedProduct.getPrice();
        coinInventoryService.returnChange(remainingCash);
        insertedCash = 0;
        selectedProduct = null;
    }

    public void performCancelTransaction() {
        if (insertedCash > 0) {
            coinInventoryService.returnChange(insertedCash);
        }
        resetTransaction();
    }

    public void resetTransaction() {
        insertedCash = 0;
        selectedProduct = null;
    }
}
