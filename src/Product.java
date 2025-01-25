public class Product implements Cloneable{
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

    //Constructor para crear libros
    public Product(int productID, int stock) {
        this.productID = productID;
        this.stock = stock;
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
    public double getPrice() {
        return price;
    }
    public void setStats(String stats) {
        this.stats = stats;
    }
    public String getStats() {
        return stats;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "\n---PRODUCTO---\n" +
                "Id= " + productID + '\n' +
                "Nombre= " + nameProduct + '\n' +
                "Estadisticas= " + stats + '\n' +
                "Stock= " + stock + '\n' +
                "Precio= " + price + '\n';
    }

    public void cloneTo(Product other) {
        other.productID = productID;
        other.nameProduct = nameProduct;
        other.stats = stats;
        other.price = price;
        other.stock = stock;
    }

    @Override
    public Product clone() {
        try {
            Product clone = (Product) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
