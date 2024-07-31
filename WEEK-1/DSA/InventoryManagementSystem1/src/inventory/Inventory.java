package inventory;

import java.util.HashMap;

public class Inventory implements IAddProduct, IUpdateProduct, IDeleteProduct, IGetProduct {
    private HashMap<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    @Override
    public void updateProduct(int productId, String name, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product not found!");
        }
    }

    @Override
    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    @Override
    public Product getProduct(int productId) {
        return products.get(productId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products.values()) {
            sb.append(product).append("\n");
        }
        return sb.toString();
    }
}
