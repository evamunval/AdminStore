public class Client extends Person implements Comparable<Client>{
    protected double money;

    public Client(int userID, String name, String surname, double money) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.money = money;
    }

    public Client() {
        this.userID = 0;
        this.name = "";
        this.surname = "";
        this.money = 0.0;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "---CLIENT---\n" +
                "Id= " + userID + '\n' +
                "Nombre= " + name + '\n' +
                "Apellido= " + surname + '\n' +
                "Dinero= " + money + '\n';
    }

    //Polimorfismo
    @Override
    public int compareTo(Client other) {
        return Integer.compare(this.getUserID(), other.getUserID());
    }
}