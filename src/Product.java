public class Product {
    protected int productID;
    protected String nameProduct;
    protected String stats;
    protected int stock;
    protected double price;

    public Product(int productID, String nameProduct, String stats, int stock, double price) {
        this.productID = productID;
        this.nameProduct = nameProduct;
        this.stats = stats;
        this.stock = stock;
        this.price = price;
    }

    public Product() {
        this.productID = productID;
        this.nameProduct = nameProduct;
        this.stats = stats;
        this.stock = stock;
        this.price = price;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    public int getProductID() {
        return productID;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public String getNameProduct() {
        return nameProduct;
    }

    @Override
    public String toString() {
        return "---PRODUCTO---\n" +
                "Id= " + productID + '\n' +
                "Nombre= " + nameProduct + '\n' +
                "Estadisticas= " + stats + '\n' +
                "Stock= " + stock + '\n' +
                "Precio= " + price + '\n';
    }
}
