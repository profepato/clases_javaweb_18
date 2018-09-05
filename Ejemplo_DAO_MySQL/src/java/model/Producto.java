package model;

public class Producto {
    private String id;
    private String nombre;
    private int stock;
    private int precio;

    public String getId() {
        return id;
    }

    public Producto setId(String id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getStock() {
        return stock;
    }

    public Producto setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public int getPrecio() {
        return precio;
    }

    public Producto setPrecio(int precio) {
        this.precio = precio;
        return this;
    }
    
    
}
