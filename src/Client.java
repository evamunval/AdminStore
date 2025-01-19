public class Client extends Person {
    protected double money;

    public Client(int userID, String name, String surname, double money) {
        super(userID, name, surname);
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "---CLIENT---" +
                "userId=" + userID +
                ", nameUser='" + name + '\'' +
                ", surnameUser='" + surname + '\'' +
                ", money=" + money +
                '}';
    }
}

