public class Warrior extends Client{
    protected boolean fight;

    public Warrior(int userId, String name, String surname, double money, boolean fight) {
        super(userId, name, surname, money);
        this.fight = fight;
    }

    public boolean canFight() {
        if (!fight) {
            fight = true;
            return true;
        }
        return false;
    }
}
