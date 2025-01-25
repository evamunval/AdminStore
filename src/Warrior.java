public class Warrior extends Client{
    protected boolean fight;

    public Warrior(int userId, String name, String surname, double money, boolean fight) {
        super(userId, name, surname, money);
        this.fight = fight;
    }

    public boolean getFight() {
        return fight;
    }
    public void setFight(boolean fight) {
        this.fight = fight;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Guerrero = " + fight + '\n';
    }
}
