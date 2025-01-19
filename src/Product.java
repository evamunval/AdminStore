public class Product {
    protected int productId;
    protected String nameProduct;
    protected String stats;
    protected int stock;
    protected double price;

    public Product(int productId, String nameProduct, String stats, int stock, double price) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.stats = stats;
        this.stock = stock;
        this.price = price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getProductId() {
        return productId;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public String getNameProduct() {
        return nameProduct;
    }
}
