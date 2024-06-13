/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package westmarket1;

/**
 *
 * @author dark_
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private int precio;
    private int stock;
    private Categoria categoria;

    public Producto(int codigo, String descripcion, int precio, int stock, Categoria categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void imprimirListado() {
        System.out.println("Código: " + codigo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: " + precio);
        System.out.println("Categoría: " + categoria);
        System.out.println("Stock: " + stock);
        System.out.println("--------------------------------------------");
    }

    public void imprimirListadoSimple() {
        System.out.println("Código: " + codigo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("--------------------------------------------");
    }
}

    

