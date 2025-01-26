public class Product implements Cloneable{
    protected int productID;
    protected String nameProduct;
    protected String stats;
    protected int stock;
    protected double price;

    //Constructor default
    public Product() {
        this.productID = productID;
        this.nameProduct = nameProduct;
        this.stats = stats;
        this.stock = stock;
        this.price = price;
    }

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

    public void setProductID(int productID) {
        this.productID = productID;
    }
    public int getProductID() {
        return productID;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
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

    //Constructor para crear el objeto clonado
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
