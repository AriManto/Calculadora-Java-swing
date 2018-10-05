package InventarioAlmacen;

public class Producto {
    private String nombre, marca;
    private double precio;
    private int stock;

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}

    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}

    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}


    public String toString(){
        return "Nombre: "+this.nombre.toUpperCase() +" | Marca: " +this.marca.toUpperCase()+" | Precio: $"+this.precio+" | Stock: "+this.stock;
    }

    Producto(String nombre, String marca, double precio, int stock){
        this.nombre=nombre;
        this.marca=marca;
        this.precio=precio;
        this.stock=stock;
    }
}
