public class Potion extends Product{
    PotionType potion;

    public Potion(int productId, String nameProduct, String stats, int stock, double price, PotionType potion) {
        super(productId, nameProduct, stats, stock, price);
        this.potion = potion;
    }
}
