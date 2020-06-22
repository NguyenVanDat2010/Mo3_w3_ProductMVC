package product.model;

public class Product {
    private int productId;
    private String productName;
    private String description;
    private double productPrice;

    public Product(int productId, String productName, String description, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
