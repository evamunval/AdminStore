public class Book extends Product{
    protected boolean borrow;
    protected String title;
    protected String author;
    protected int yearOfPublication;

    public Book(int productID, String title, String author, int stock, int yearOfPublication, boolean borrow) {
        super(productID, stock);
        this.title = title;
        this.author = author;
        this.borrow = borrow;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYearOfPublication() {
        return yearOfPublication;
    }
    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
    public void setBorrow(boolean borrow) {
         this.borrow = false;
    }
    public boolean getBorrow() {
        return borrow;
    }

    @Override
    public String toString() {
        return "\n---LIBRO---\n" +
                "Título: " + title + '\n' +
                "Autor: " + author + '\n' +
                "Año de Publicación: " + yearOfPublication + '\n' +
                "Stock: " + stock + '\n' +
                "Prestado: " + borrow + '\n';
    }
}
