package inventory;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        IAddProduct addProduct = new Inventory();
        IUpdateProduct updateProduct = (IUpdateProduct) addProduct;
        IDeleteProduct deleteProduct = (IDeleteProduct) addProduct;
        IGetProduct getProduct = (IGetProduct) addProduct;

        Product product1 = new Product(1, "Product A", 10, 99.99);
        Product product2 = new Product(2, "Product B", 5, 49.99);

        addProduct.addProduct(product1);
        addProduct.addProduct(product2);

        System.out.println("Initial Inventory:");
        System.out.println(getProduct.toString());

        updateProduct.updateProduct(1, "Updated Product A", 20, 89.99);
        System.out.println("Inventory after updating Product 1:");
        System.out.println(getProduct.toString());

        deleteProduct.deleteProduct(2);
        System.out.println("Inventory after deleting Product 2:");
        System.out.println(getProduct.toString());
    }
}
