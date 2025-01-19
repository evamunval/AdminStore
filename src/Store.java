import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private Client client;
    private Product product;
    //declaracion de arraylist
    private ArrayList<Client> clientArrayList;
    private ArrayList<Product> productArrayList;

    public Store(){
        this.client = new Client();
        this.product = new Product();

        //instancia del arraylist desde la variable global
        this.clientArrayList = new ArrayList<>();
        //se crea de cero, un cliente predeterminado
        clientArrayList.add(new Client(01, "Paco","Garcia",600));
        clientArrayList.add(new Client(02, "Gilberto","Suarez",500));

        this.productArrayList = new ArrayList<>();
        productArrayList.add(new Product(01,"101","101",10,20));
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
        System.out.println("1. Comprar Espadas");
        System.out.println("2. Comprar Pociones");
        System.out.println("2. Alquiler Libros");
        System.out.println("3. Volver al menu principal");
    }

    public void printDeleteMenu(){
        System.out.println("Eliminación de Clientes y/o Productos:");
        System.out.println("1. Eliminación de Clientes");
        System.out.println("2. Eliminación de Productos");
        System.out.println("3. Volver al menu principal");
    }

    public void mainMenu(){
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
        int inputModification = sc.nextInt();
        switch (inputModification){
            case 1:
                // Modificacion de Clientes
                //printModifyClientMenu();
                chooseClient(clientArrayList);
                break;
            case 2:
                // Modificacion de Productos
                printModifyProductMenu();
                //ModifyProductMenu();
                break;
            case 3:
                //Salida menu principal
                mainMenu();
            default:
                System.out.println("Opción no válida");
        }
    }

    public void deleteMenu(){
        Scanner sc = new Scanner(System.in);
        int inputErase = sc.nextInt();
        switch (inputErase){
            case 1:
                // Eliminar Clientes
                System.out.println("Eliminación de Clientes");
                break;
            case 2:
                // Eliminar Productos
                System.out.println("Eliminación de Productos");
                break;
            case 3:
                //Salida menu principal
                mainMenu();
            default:
                System.out.println("Opción no válida");
        }
    }

    public void salesMenu(){
        Scanner sc = new Scanner(System.in);
        int salesInput = sc.nextInt();
        switch (salesInput){
            case 1:
                System.out.println("1. Comprar Espadas");
                break;
            case 2:
                System.out.println("2. Comprar Pociones");
                break;
            case 3:
                System.out.println("3. Alquiler Libros");
                break;
            case 4:
                System.out.println("4. Volver al menu principal");
                break;
            default:
                System.out.println("Opción no valida!");
        }
    }

    public void registerClient(ArrayList<Client> clientArrayList){
        Scanner sc = new Scanner(System.in);
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
    }

    public void registerProduct(ArrayList<Product> productArrayList){
        Scanner sc = new Scanner(System.in);
        Product p = new Product();

        System.out.println("Introduzca el Id del producto: ");
        p.setProductId(sc.nextInt());
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el Id del cliente a modificar: ");
        int choosedId = sc.nextInt();

        boolean clientFound = false;
        for(Client c : clientArrayList){
            if(c.getUserID() == choosedId){
                clientFound = true;
                ModifyClientMenu(c);
                break;
            }
        }
        if(!clientFound){
            System.out.println("Cliente no encontrado.");
        }
    }

    public void ModifyClientMenu(Client c){
        Scanner sc = new Scanner(System.in);
        int inputModifyClient = sc.nextInt();

        switch (inputModifyClient){
            case 1:
                System.out.println("Introduzca el nuevo nombre del cliente");
                c.name = sc.nextLine();
                break;
            case 2:
                System.out.println("Introduzca el nuevo apellido del cliente");
                c.surname = sc.nextLine();
                break;
            case 3:
                System.out.println("Introduzca el nuevo dinero del cliente");
                c.money = sc.nextDouble();
                break;
            case 4:
                mainMenu();
                break;
            default:
                System.out.println("Opción no valida!");
        }
    }

    public void ModifyProductMenu(Product p){
        Scanner sc = new Scanner(System.in);
        int inputModifyProduct = sc.nextInt();

        switch (inputModifyProduct){
            case 1:
                System.out.println("Introduzca el nuevo nombre del producto");
                p.nameProduct = sc.nextLine();
                break;
            case 2:
                System.out.println("Introduzca el nuevo stock del producto");
                p.stock = sc.nextInt();
                break;
            case 3:
                System.out.println("Introduzca el nuevo precio del producto");
                p.price = sc.nextDouble();
                break;
            case 4:
                mainMenu();
                break;
            default:
                System.out.println("Opción no valida!");
        }
    }

    public void deleteProduct(ArrayList <Product> products, Product p){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el id del producto: ");
        p.productId = sc.nextInt();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).productId == p.productId) {
                products.remove(i);
            }
        }
    }
}
