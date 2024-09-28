//Product
package Product; 
public class Product implements java.io.Serializable 
{
    private String productName;
    private double productPrice;
    private int quantity;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = 1;
    }

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity ) {
        this.quantity = quantity;
    }
}
