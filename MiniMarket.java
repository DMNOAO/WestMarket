/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package westmarket1;

/**
 *
 * @author dark_
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MiniMarket {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Categoria> categorias = new ArrayList<>();

    public static void main(String[] args) {
        inicializarCategorias();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--- West Market ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Imprimir productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    registrarProducto(scanner);
                    break;
                case 2:
                    imprimirProductos();
                    break;
                case 3:
                    eliminarProducto(scanner);
                    break;
                case 4:
                    System.out.println("Ha salido del sistema");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void inicializarCategorias() {
        categorias.add(new Categoria(1, "Bebidas"));
        categorias.add(new Categoria(2, "Congelados"));
        categorias.add(new Categoria(3, "Lácteos"));
        categorias.add(new Categoria(4, "Aseo"));
    }

    private static void registrarProducto(Scanner scanner) {
        int codigo = leerEntero(scanner, "Ingrese código: ");
        String descripcion = leerString(scanner, "Ingrese descripción: ");
        int precio = leerEntero(scanner, "Ingrese precio: ");
        int stock = leerEntero(scanner, "Ingrese stock: ");
        Categoria categoria = seleccionarCategoria(scanner);

        Producto producto = new Producto(codigo, descripcion, precio, stock, categoria);
        productos.add(producto);
        System.out.println("El producto ha sido ingresado");
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        int intentos = 0;
        while (intentos < 3) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Entrada no válida. Intente nuevamente.");
                scanner.next(); 
                intentos++;
            }
        }
        System.out.println("Número máximo de intentos alcanzado. Terminando aplicación.");
        System.exit(0);
        return -1;
    }

    private static String leerString(Scanner scanner, String mensaje) {
        int intentos = 0;
        while (intentos < 3) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            if (!entrada.isEmpty()) {
                return entrada;
            } else {
                System.out.println("Entrada no válida. Intente nuevamente.");
                intentos++;
            }
        }
        System.out.println("Número máximo de intentos alcanzado. Terminando aplicación.");
        System.exit(0);
        return null; 
    }

    private static Categoria seleccionarCategoria(Scanner scanner) {
        System.out.println("Categorías");
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getCodigo() + ". " + categoria.getNombre());
        }
        int codigo = leerEntero(scanner, "Asigne una categoría al producto: ");
        for (Categoria categoria : categorias) {
            if (categoria.getCodigo() == codigo) {
                return categoria;
            }
        }
        System.out.println("Categoría no válida. Terminando aplicación.");
        System.exit(0);
        return null; 
    }

    private static void imprimirProductos() {
        System.out.println("--- Listado de productos ---");
        for (Producto producto : productos) {
            producto.imprimirListado();
        }
    }

    private static void eliminarProducto(Scanner scanner) {
        System.out.println("--- Productos ingresados ---");
        for (Producto producto : productos) {
            producto.imprimirListadoSimple();
        }
        int codigo = leerEntero(scanner, "Ingrese el código del producto que desea eliminar: ");
        productos.removeIf(producto -> producto.getCodigo() == codigo);
        System.out.println("El producto ha sido eliminado");
    }
}

    
    

