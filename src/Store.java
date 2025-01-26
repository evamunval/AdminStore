import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Store {
    private Client client;
    private Product product;
    //Declaraciones arraylist
    private ArrayList<Client> clientArrayList;
    private ArrayList<Product> productArrayList;
    private int clientID;
    private Timestamp timestamp;
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    private final LocalDateTime localDateTime;
    private Scanner sc;

    public Store(){
        this.client = new Client();
        this.product = new Product();
        this.sc = new Scanner(System.in);
        this.clientID = clientID;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.localDateTime = timestamp.toLocalDateTime();

        //instancia del arraylist desde la referencia
        this.clientArrayList = new ArrayList<>();
        //creación clientes
        clientArrayList.add(new Mage(01, "Paco","Garcia",20.23, true));
        clientArrayList.add(new Warrior(02, "Gilberto","Suarez",80.99, true));
        clientArrayList.add(new Mage(03, "Adrian","Gonzalez",100.08, true));
        clientArrayList.add(new Warrior(04, "Eva","Munar",500.99, true));
        clientArrayList.add(new Mage(05, "Raul","Gil",700.99, true));
        //creacion productos
        this.productArrayList = new ArrayList<>();
        productArrayList.add(new Weapon(1,"Espada Maestra","+101",5,180.59, WeaponType.SWORD));
        productArrayList.add(new Weapon(2,"Espada del caos","+200",2,203.66, WeaponType.SWORD));

        productArrayList.add(new Weapon(4,"Escudo Hyliano","+40",1,300.33, WeaponType.SHIELD));
        productArrayList.add(new Weapon(5,"Escudo del lobo","+80",7,110.36, WeaponType.SHIELD));

        productArrayList.add(new Weapon(7,"Armadura Dragón","+150",4,400.23, WeaponType.ARMOUR));
        productArrayList.add(new Weapon(8,"Armadura Rubí","+180",8,600.22, WeaponType.ARMOUR));

        productArrayList.add(new Potion(9,"Pocion de Vida Mediana","+30",20,20.30, PotionType.HEAL));
        productArrayList.add(new Potion(10,"Pocion de Vida Pequeña","+15",50,7.30, PotionType.HEAL));

        productArrayList.add(new Potion(11,"Superpoción de maná","+30",5,40.30, PotionType.MANA));
        productArrayList.add(new Potion(12,"Pocion de Mana","+15",10,10.22, PotionType.MANA));

        productArrayList.add(new Book(13,"Recetas de Campo","J.C.Rowling",1,1425, false));
        productArrayList.add(new Book(14,"Magia Negra","NightShade",1,1500, false));
    }

    public void printMainMenu(){
        System.out.println("Página principal de gestión, elige una opción:");
        System.out.println("1. Alta de Clientes y/o Productos");
        System.out.println("2. Modificación de Clientes y/o Productos");
        System.out.println("3. Eliminar Clientes y/o Productos");
        System.out.println("4. Compra y Alquileres");
        System.out.println("5. Salir");
    }

    public void printRegisterMenu(){
        System.out.println("Alta de Clientes y/o Productos:");
        System.out.println("1. Alta de Clientes");
        System.out.println("2. Alta de Productos");
        System.out.println("3. Volver al menu principal");
    }

    public void printModifyMenu(){
        System.out.println("Modificación de Clientes y/o Productos");
        System.out.println("1. Modificación de Clientes");
        System.out.println("2. Modificacion de Productos");
        System.out.println("3. Volver al menu principal");
    }

    public void printModifyClientMenu(){
        System.out.println("Que campo quiere modificar del cliente?");
        System.out.println("1. Nombre del Cliente");
        System.out.println("2. Apellido del Cliente");
        System.out.println("3. Dinero del Cliente");
        System.out.println("4. Salir");
    }

    public void printModifyProductMenu(){
        System.out.println("Que campo quiere modificar del producto?");
        System.out.println("1. Nombre del Producto");
        System.out.println("2. Tipo del Producto");
        System.out.println("3. Precio del Producto");
        System.out.println("4. Salir");
    }

    public void printSalesMenu(){
        System.out.println("Compra y Alquileres:");
        System.out.println("1. Comprar Equipo");
        System.out.println("2. Comprar Pociones");
        System.out.println("3. Alquiler Libros");
        System.out.println("4. Devolver Libros");
        System.out.println("5. Volver al menu principal");
    }

    public void printDeleteMenu(){
        System.out.println("Eliminación de Clientes y/o Productos:");
        System.out.println("1. Eliminación de Clientes");
        System.out.println("2. Eliminación de Productos");
        System.out.println("3. Volver al menu principal");
    }

    public void mainMenu(){
        printMainMenu();
        int userInput = 0;
        while (userInput != 5) {
            try {
                userInput = sc.nextInt();
                switch (userInput) {
                    case 1:
                        // Alta de Clientes y/o Productos
                        printRegisterMenu();
                        registerMenu();
                        break;
                    case 2:
                        // Modificacion de Clientes y/o Productos
                        printModifyMenu();
                        modifyMenu();
                        break;
                    case 3:
                        // Eliminar Clientes y/o Productos
                        printDeleteMenu();
                        deleteMenu();
                        break;
                    case 4:
                        //Compra y Alquileres
                        printSalesMenu();
                        salesMenu();
                    case 5:
                        // Salir
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número válido.");
                sc.nextLine();
                printMainMenu();
            }
        }
    }

    public void registerMenu() {
        int inputRegister = 0;
        while (inputRegister != 3) {
            try {
                inputRegister = sc.nextInt();
                switch (inputRegister) {
                    case 1:
                        // Alta de Clientes
                        registerClient(clientArrayList);
                        break;
                    case 2:
                        // Alta de Productos
                        registerProduct(productArrayList);
                        break;
                    case 3:
                        //Salida menu principal
                        mainMenu();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número válido.");
                sc.nextLine();
                printRegisterMenu();
            }
        }
    }

    public void modifyMenu(){
        int inputModification = 0;
        while (inputModification != 3) {
            try {
                inputModification = sc.nextInt();
                switch (inputModification) {
                    case 1:
                        // Modificacion de Clientes
                        chooseClient(clientArrayList);
                        break;
                    case 2:
                        // Modificacion de Productos
                        chooseProduct(productArrayList);
                        break;
                    case 3:
                        //Salida menu principal
                        mainMenu();
                    default:
                        System.out.println("Opción no válida");
                }
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número válido.");
                sc.nextLine();
                printRegisterMenu();
            }
        }
    }

    public void deleteMenu(){
        int inputErase = 0;
        while (inputErase != 3) {
            try {
                inputErase = sc.nextInt();
                switch (inputErase) {
                    case 1:
                        // Eliminar Clientes
                        deleteClient(clientArrayList);
                        mainMenu();
                        break;
                    case 2:
                        // Eliminar Productos
                        deleteProduct(productArrayList);
                        mainMenu();
                        break;
                    case 3:
                        //Salida menu principal
                        mainMenu();
                    default:
                        System.out.println("Opción no válida");
                }
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número válido.");
                sc.nextLine();
                printRegisterMenu();
            }
        }
    }

    public void salesMenu(){
        int salesInput = 0;
        while (salesInput != 5) {
            try {
                salesInput = sc.nextInt();
                sc.nextLine();
                switch (salesInput) {
                    case 1:
                        System.out.println("Introduce el id del cliente:");
                        clientID = sc.nextInt();
                        sc.nextLine();

                        for (Client client : clientArrayList) {
                            Client tempClient = new Client();
                            tempClient.setUserID(clientID);
                            if (client.compareTo(tempClient) == 0 && client instanceof Warrior) {
                                System.out.println("1. Comprar Equipo");
                                gearSales();
                            }
                        }
                        System.out.println("Solo pueden comprar equipo los guerreros.");
                        printSalesMenu();
                        break;
                    case 2:
                        System.out.println("2. Comprar Pociones");
                        potionSales();
                        break;
                    case 3:
                        System.out.println("Introduce el id del cliente:");
                        clientID = sc.nextInt();
                        sc.nextLine();

                        for (Client client : clientArrayList) {
                            Client tempClient = new Client();
                            tempClient.setUserID(clientID);
                            if (client.compareTo(tempClient) == 0 && client instanceof Mage) {
                                System.out.println("3. Alquiler Libros");
                                bookBorrow();
                            }
                        }
                        System.out.println("Solo pueden alquilar libros los magos.");
                        printSalesMenu();
                        break;
                    case 4:
                        System.out.println("Introduce el id del cliente:");
                        clientID = sc.nextInt();
                        sc.nextLine();

                        for (Client client : clientArrayList) {
                            Client tempClient = new Client();
                            tempClient.setUserID(clientID);
                            if (client.compareTo(tempClient) == 0 && client instanceof Mage) {
                                System.out.println("3. Devolución Libros");
                                bookReturn();
                            }
                        }
                        System.out.println("Solo pueden devolver libros los magos.");
                        printSalesMenu();
                        break;
                    case 5:
                        System.out.println("4. Volver al menu principal");
                        mainMenu();
                        break;
                    default:
                        System.out.println("Opción no valida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número válido.");
                sc.nextLine();
                printSalesMenu();
            }
        }
    }

    public boolean gearSales(){
        for(Product product : productArrayList) {
            if (product instanceof Weapon) {
                    System.out.println("Producto: " + product.getNameProduct() + '\n' +
                            "ID: " + product.getProductID() + '\n' +
                            "Stock: " + product.getStock() + '\n' +
                            "Precio: " + product.getPrice() + '\n');
            }
        }

        System.out.println("Introduce el nombre del elemento a comprar: ");
        String inputElement = sc.nextLine();

        for(Product product : productArrayList) {
            if(inputElement.equals(product.getNameProduct()) && product.getPrice() <= client.getMoney() && product.getStock() > 0){
                client.money -= product.getPrice();
                product.stock--;
                System.out.println("Compra realizada!");
                mainMenu();
                return true;
            }
        }
        System.out.println("No se ha podido realizar la compra!");
        mainMenu();
        return false;
    }

    public boolean potionSales(){
        for(Product product : productArrayList) {
            if(product instanceof Potion){
                System.out.println("Producto: " + product.getNameProduct() + '\n' +
                        "ID: " + product.getProductID() + '\n' +
                        "Stock: " + product.getStock() + '\n' +
                        "Precio: " + product.getPrice() + '\n');
            }
        }

        System.out.println("Introduce el id del cliente:");
        int id = sc.nextInt();
        sc.nextLine();

        for(Client client : clientArrayList) {
            if(client.getUserID() == id){
                System.out.println("Introduce el nombre del elemento a comprar: ");
                String inputElement = sc.nextLine();
                for(Product product : productArrayList) {
                    if((inputElement.equals(product.getNameProduct())) && (product.getPrice() <= client.getMoney()) && (product.getStock() > 0)){
                        client.money -= product.getPrice();
                        product.stock--;
                        System.out.println("Compra realizada!");
                        mainMenu();
                        return true;
                    }
                }
            }
        }
        System.out.println("No se ha podido realizar la compra!");
        mainMenu();
        return false;
    }

    public boolean bookBorrow(){
        LocalDateTime date = localDateTime.plusMonths(1);
        Timestamp dueDate = Timestamp.valueOf(date);
        for(Product product : productArrayList) {
            if(product instanceof Alquilable) {
                Alquilable alquilable = (Alquilable) product;
                if (product instanceof Book) {
                    Book book = (Book) product;
                    System.out.println("Producto: " + ((Book) product).getTitle() + '\n' +
                            "Autor: " + ((Book) product).getAuthor() + '\n' +
                            "Año de Publicación: " + ((Book) product).getYearOfPublication() + '\n' +
                            "Stock: " + product.getStock() + '\n' +
                            "Prestado: " + alquilable.isBorrowed());
                }
            }
        }

        System.out.println("Introduce el nombre del libro que quieras alquilar: ");
        String inputElement = sc.nextLine();

        for(Product product : productArrayList) {
            if(product instanceof Book && product instanceof Alquilable){
                Alquilable alquilable = (Alquilable) product;
                Book book = (Book) product;

                if(inputElement.equals(((Book) product).getTitle()) && product.getStock() > 0){
                    if(!alquilable.isBorrowed()){
                        alquilable.lent();
                        product.stock--;
                        System.out.println("Alquiler realizado: " + sdf1.format(timestamp) + "\n" + "Fecha de devolución: " + sdf2.format(dueDate));
                        salesMenu();
                        return true;
                    }
                }
            }
        }

        System.out.println("No se ha podido realizar el alquiler!" + "\n" + "Fecha de devolución:" + sdf2.format(dueDate));
        salesMenu();
        return false;
    }

    public boolean bookReturn() {
        for (Product product : productArrayList) {
            if (product instanceof Alquilable && product instanceof Book) {
                Alquilable alquilable = (Alquilable) product;
                Book book = (Book) product;

                if (alquilable.isBorrowed()) {
                    System.out.println("Producto: " + book.getTitle() + '\n' +
                            "Autor: " + book.getAuthor() + '\n' +
                            "Año de Publicación: " + book.getYearOfPublication() + '\n' +
                            "Prestado: " + alquilable.isBorrowed());
                }
            }
        }

        System.out.println("Introduce el nombre del libro que quieras devolver: ");
        String inputElement = sc.nextLine();

        for (Product product : productArrayList) {
            if (product instanceof Alquilable && product instanceof Book) {
                Alquilable alquilable = (Alquilable) product;
                Book book = (Book) product;

                if (inputElement.equals(book.getTitle())) {
                    if (alquilable.isBorrowed()) {
                        alquilable.bringBack();
                        product.stock++;

                        System.out.println("Devolución realizada con éxito!");
                        salesMenu();
                        return true;
                    }
                }
            }
        }
        System.out.println("No se ha podido realizar la devolución. El libro no existe o no está prestado.");
        salesMenu();
        return false;
    }

    public void registerClient(ArrayList<Client> clientArrayList){
        Client c = new Client();

        System.out.println("Introduzca el Id del cliente: ");
        c.setUserID(sc.nextInt());
        sc.nextLine();
        System.out.println("Introduzca el nombre del cliente: ");
        c.setName(sc.nextLine());
        System.out.println("Introduzca el apellido del cliente: ");
        c.setSurname(sc.nextLine());
        System.out.println("Introduzca el dinero del cliente: ");
        c.setMoney(sc.nextDouble());
        clientArrayList.add(c);
        System.out.println(c);
        mainMenu();
    }

    public void registerProduct(ArrayList<Product> productArrayList){
        Product p = new Product();

        System.out.println("Introduzca el Id del producto: ");
        p.setProductID(sc.nextInt());
        sc.nextLine();
        System.out.println("Introduzca el nombre del producto: ");
        p.nameProduct = sc.nextLine();
        System.out.println("Introduzca las estadísticas del producto: ");
        p.stats = sc.nextLine();
        System.out.println("Introduzca el precio del producto: ");
        p.price = sc.nextDouble();
        System.out.println("Introduzca el stock del producto: ");
        p.stock = sc.nextInt();

        productArrayList.add(p);
        System.out.println(p);

        //Clonacion
        Product clone = new Product();
        p.cloneTo(clone);
        System.out.println("Clon del producto creado: " + clone);
        //Agregar al ArrayList
        productArrayList.add(clone);
    }

    //Attention please, metodo complicado
    public void chooseClient(ArrayList<Client> clientArrayList){
        System.out.println("Introduzca el Id del cliente a modificar: ");
        int choosedId = sc.nextInt();
        sc.nextLine();

        boolean clientFound = false;
        for(Client c : clientArrayList){
            if(c.getUserID() == choosedId){
                clientFound = true;
                System.out.println("Modificación exitosa!");
                modifyClientMenu(c);
            }
            if(!clientFound){
                System.out.println("Cliente no encontrado.");
            }
        }
    }

    public void modifyClientMenu(Client c){
        printModifyClientMenu();
        int inputModifyClient = 0;

        while (inputModifyClient != 4) {
            try {
                inputModifyClient = sc.nextInt();
                sc.nextLine();
                switch (inputModifyClient) {
                    case 1:
                        System.out.println("Introduzca el nuevo nombre del cliente");
                        c.name = sc.nextLine();
                        System.out.println(c);
                        mainMenu();
                        break;
                    case 2:
                        System.out.println("Introduzca el nuevo apellido del cliente");
                        c.surname = sc.nextLine();
                        System.out.println(c);
                        mainMenu();
                        break;
                    case 3:
                        System.out.println("Introduzca el nuevo dinero del cliente");
                        c.money = sc.nextDouble();
                        System.out.println(c);
                        mainMenu();
                        break;
                    case 4:
                        mainMenu();
                        break;
                    default:
                        System.out.println("Opción no valida!");
                }
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número válido.");
                sc.nextLine();
                printRegisterMenu();
            }
        }
    }

    //Attention please, metodo complicado
    public void chooseProduct(ArrayList<Product> productArrayList){
        System.out.println("Introduzca el Id del producto a modificar: ");
        int choosedId = sc.nextInt();
        sc.nextLine();

        boolean productFound = false;
        Iterator <Product> iterator = productArrayList.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getProductID() == choosedId){
                productFound = true;
                System.out.println("Modificación exitosa!");
                modifyProductMenu(iterator.next());
            }
            if(!productFound){
                System.out.println("Producto no encontrado.");
            }
        }
    }

    public void modifyProductMenu(Product p){
        printModifyProductMenu();
        int inputModifyProduct = 0;

        while (inputModifyProduct != 4) {
            inputModifyProduct = sc.nextInt();
            sc.nextLine();
            try {
                switch (inputModifyProduct) {
                    case 1:
                        System.out.println("Introduzca el nuevo nombre del producto");
                        p.nameProduct = sc.nextLine();
                        System.out.println(p);
                        mainMenu();
                        break;
                    case 2:
                        System.out.println("Introduzca el nuevo stock del producto");
                        p.stock = sc.nextInt();
                        System.out.println(p);
                        mainMenu();
                        break;
                    case 3:
                        System.out.println("Introduzca el nuevo precio del producto");
                        p.price = sc.nextDouble();
                        System.out.println(p);
                        mainMenu();
                        break;
                    case 4:
                        mainMenu();
                        break;
                    default:
                        System.out.println("Opción no valida!");
                }
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número válido.");
                sc.nextLine();
                printRegisterMenu();
            }
        }
    }

    public void deleteClient(ArrayList <Client> clientArrayList){
        System.out.println("Introduzca el Id del cliente: ");
        int choosedID = sc.nextInt();
        sc.nextLine();

        boolean clientFound = false;
        for(Client c : clientArrayList){
            if(c.getUserID() == choosedID){
                clientFound = true;
                clientArrayList.remove(c);
                System.out.println("Eliminado con exito!");
            }
            if(!clientFound){
                System.out.println("Cliente no encontrado.");
            }
        }
    }

    public void deleteProduct(ArrayList <Product> productArrayList){
        System.out.println(productArrayList);

        System.out.println("Introduzca el Id del producto: ");
        int choosedID = sc.nextInt();
        sc.nextLine();

        boolean productFound = false;
        for(Product p : productArrayList){
            if(p.getProductID() == choosedID){
                productFound = true;
                productArrayList.remove(p);
                System.out.println("Eliminado con exito!");
            }
            if(!productFound){
                System.out.println("Producto no encontrado.");
            }
        }
    }
}
