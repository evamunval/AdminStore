abstract class Person {
    protected int userID;
    protected String name;
    protected String surname;

    public Person(int userID, String name, String surname) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
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

}

