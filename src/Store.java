import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private Client client;
    private Product product;
    //declaracion de arraylist
    private ArrayList<Client> clientArrayList;
    private ArrayList<Product> productArrayList;
    private Scanner sc;
    private int clientID;
    private Timestamp timestamp;
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    private final LocalDateTime localDateTime;

    public Store(){
        this.client = new Client();
        this.product = new Product();
        this.sc = new Scanner(System.in);
        this.clientID = clientID;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.localDateTime = timestamp.toLocalDateTime();

        //instancia del arraylist desde la variable global
        this.clientArrayList = new ArrayList<>();
        //se crea de cero, un cliente predeterminado
        clientArrayList.add(new Mage(01, "Paco","Garcia",600, true));
        clientArrayList.add(new Warrior(02, "Gilberto","Suarez",500, true));

        this.productArrayList = new ArrayList<>();
        productArrayList.add(new Weapon(01,"Master Sword","+101",5,149.99, WeaponType.SWORD));
        productArrayList.add(new Potion(02,"Pocion de Vida","+30",20,20.30, PotionType.HEAL));
        productArrayList.add(new Book(03,"Recetas de Campo","J.C.Rowling",1,1425, false));
        productArrayList.add(new Weapon(04,"Link Sword","+10",5,149.99, WeaponType.SWORD));
        productArrayList.add(new Weapon(05,"Shield","+10",1,100.99, WeaponType.SHIELD));
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
        System.out.println("4. Volver al menu principal");
    }

    public void printDeleteMenu(){
        System.out.println("Eliminación de Clientes y/o Productos:");
        System.out.println("1. Eliminación de Clientes");
        System.out.println("2. Eliminación de Productos");
        System.out.println("3. Volver al menu principal");
    }

    public void mainMenu(){
        printMainMenu();
        int userInput = sc.nextInt();

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
                System.out.println("Cerrando programa.");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    public void registerMenu() {
        int inputRegister = sc.nextInt();
        switch (inputRegister){
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
    }

    public void modifyMenu(){
        int inputModification = sc.nextInt();
        switch (inputModification){
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
    }

    public void deleteMenu(){
        int inputErase = sc.nextInt();
        switch (inputErase){
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
    }

    public void salesMenu(){
        int salesInput = 0;
        do {
            salesInput = sc.nextInt();
            sc.nextLine();
            try {
                isStringInt(String.valueOf(salesInput));
                switch (salesInput) {
                    case 1:
                        System.out.println("Introduce el id del cliente:");
                        clientID = sc.nextInt();
                        sc.nextLine();

                        for (Client client : clientArrayList) {
                            if (client.getUserID() == clientID && client instanceof Warrior) {
                                System.out.println("1. Comprar Equipo");
                                GearSales();
                            }
                        }
                        System.out.println("Solo pueden comprar equipo los guerreros.");
                        printSalesMenu();
                        break;
                    case 2:
                        System.out.println("2. Comprar Pociones");
                        PotionSales();
                        break;
                    case 3:
                        System.out.println("3. Alquiler Libros");
                        bookBorrow();
                        break;
                    case 4:
                        System.out.println("4. Volver al menu principal");
                        mainMenu();
                        break;
                    default:
                        System.out.println("Opción no valida!");
                }
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida. Por favor, introduce un número válido.");
            }
        } while (salesInput != 4) ;
    }

    public void isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
        } catch (NumberFormatException ex)
        {
            throw new NumberFormatException("el numerito no es numerico");
        }
    }

    public boolean GearSales(){
        for(Product product : productArrayList) {
            if (product instanceof Weapon) {
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
                    if(inputElement.equals(product.getNameProduct()) && product.getPrice() <= client.getMoney() && product.getStock() > 0){
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

    public boolean PotionSales(){
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
                    if(inputElement.equals(product.getNameProduct()) && product.getPrice() <= client.getMoney() && product.getStock() > 0){
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
            if(product instanceof Book){
                System.out.println("Producto: " + ((Book) product).getTitle() + '\n' +
                        "Autor: " + ((Book) product).getAuthor()+ '\n' +
                        "Año de Publicación: " + ((Book) product).getYearOfPublication()+ '\n' +
                        "Stock: " + product.getStock()+ '\n' +
                        "Prestado: " + ((Book) product).getBorrow());
            }
        }

        System.out.println("Introduce el id del cliente:");
        int id = sc.nextInt();
        sc.nextLine();

        for(Client client : clientArrayList) {
            if(client.getUserID() == id){
                System.out.println("Introduce el nombre del libro que quieras alquilar: ");
                String inputElement = sc.nextLine();
                for(Product product : productArrayList) {
                    if(product instanceof Book){
                        if(inputElement.equals(((Book) product).getTitle()) && product.getStock() > 0){
                            if(!((Book) product).borrow){
                                ((Book) product).borrow = true;
                                product.stock--;
                                System.out.println("Alquiler realizado: " + sdf1.format(timestamp) + "\n" + "Fecha de devolución: " + sdf2.format(dueDate));
                                mainMenu();
                                return true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("No se ha podido realizar el alquiler!" + "\n" + "Fecha de devolución:" + sdf2.format(dueDate));
        mainMenu();
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
                ModifyClientMenu(c);
            }
            if(!clientFound){
                System.out.println("Cliente no encontrado.");
            }
        }
    }

    public void ModifyClientMenu(Client c){
        printModifyClientMenu();
        int inputModifyClient = sc.nextInt();
        sc.nextLine();

        switch (inputModifyClient){
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
    }

    //Attention please, metodo complicado
    public void chooseProduct(ArrayList<Product> productArrayList){
        System.out.println("Introduzca el Id del producto a modificar: ");
        int choosedId = sc.nextInt();
        sc.nextLine();

        boolean productFound = false;
        for(Product p : productArrayList){
            if(p.getProductID() == choosedId){
                productFound = true;
                System.out.println("Modificación exitosa!");
                ModifyProductMenu(p);
            }
            if(!productFound){
                System.out.println("Producto no encontrado.");
            }
        }
    }

    public void ModifyProductMenu(Product p){
        printModifyProductMenu();
        int inputModifyProduct = sc.nextInt();
        sc.nextLine();

        switch (inputModifyProduct){
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
