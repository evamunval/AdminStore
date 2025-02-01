public class Warrior extends Client{
    protected boolean fight;

    public Warrior(int userId, String name, String surname, double money, boolean fight) {
        super(userId, name, surname, money);
        this.fight = fight;
    }

    public Warrior(){}

    public boolean getFight() {
        return fight;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Guerrero = " + getFight() + '\n';
    }
}
//uno quitar los dos toString,
//gestionar tipo de cliente con ambos getters
//sumar toStringlciente con warrior y mago por separado
//usar ternaria para opcion 2
