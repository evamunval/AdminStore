public class Book {
    protected boolean borrow;
    protected String title;
    protected int number;
    protected String author;
    protected int yearOfPublication;

    public Book(String title, String author, int number, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.number = number;
        this.borrow = false;
        this.yearOfPublication = yearOfPublication;
    }

    public void bringBack() {

    }

    public boolean isBorrowed() {
        return borrow = true;
    }
}
