public class Mage extends Client{
    protected boolean read;

    public Mage(int userId, String name, String surname, double money, boolean read) {
        super(userId, name, surname, money);
        this.read = read;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Mago = " + read + '\n';
    }
}
