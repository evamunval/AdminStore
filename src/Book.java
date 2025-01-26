public class Book extends Product implements Alquilable{
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
    public String getAuthor() {
        return author;
    }
    public int getYearOfPublication() {
        return yearOfPublication;
    }

    //Métodos de la interfaz propia Alquilable
    @Override
    public boolean isBorrowed() {
        return borrow;
    }

    @Override
    public void lent() {
        if (!borrow) {
            borrow = true;
            System.out.println("El libro \"" + title + "\" ha sido alquilado.");
        } else {
            System.out.println("El libro \"" + title + "\" ya está alquilado.");
        }
    }

    @Override
    public void bringBack() {
        if (borrow) {
            borrow = false;
            System.out.println("El libro \"" + title + "\" ha sido devuelto.");
        } else {
            System.out.println("El libro \"" + title + "\" no estaba alquilado.");
        }
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
