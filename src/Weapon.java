public class Weapon extends Product {
    WeaponType weapon;

    public Weapon(int productId, String nameProduct, String stats, int stock, double price, WeaponType weapon) {
        super(productId, nameProduct, stats, stock, price);
        this.weapon = weapon;
    }
}
