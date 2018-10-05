package InventarioAlmacen;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeProductos extends ArrayList<Producto> {
    private Scanner leer = new Scanner(System.in);
    private void agregarProducto(){
        System.out.println("------------------------------");
        System.out.println("Nombre del producto:");
        String nombre= leer.nextLine();
        System.out.println("Marca:");
        String marca= leer.nextLine();
        System.out.println("Precio:");
        int precio = leer.nextInt();
        System.out.println("Stock:");
        int stock = leer.nextInt();
        this.add(new Producto(nombre,marca,precio,stock));
        System.out.println("Producto agregado exitosamente.");
    }
    private void agregarProducto(String nombre, String marca, double precio, int stock){
       this.add(new Producto(nombre,marca,precio,stock));
    }
    private void mostrarLista(){
        System.out.println("------------------------------");
        System.out.println("Lista de productos:");
        for (Producto producto:this){
            System.out.println(producto.toString());
        }
    }
    private void precioMayor(){
        double precioMayor = 0;
        System.out.println("------------------------------");
        System.out.println("Producto/s más caro/s:");
        for (Producto producto:this) {
            if (producto.getPrecio() > precioMayor) {
                precioMayor = producto.getPrecio();
            }
        }
         for (Producto producto:this){
             if (producto.getPrecio()== precioMayor){
                 System.out.println(producto);
             }
         }
    }
    private void precioMenor(){
        double precioMenor = 0;
        System.out.println("------------------------------");
        System.out.println("Producto/s más barato/s:");
        for (Producto producto:this) {
            if (producto.getPrecio() < precioMenor) {
                precioMenor = producto.getPrecio();
            }
        }
        for (Producto producto:this){
            if (producto.getPrecio()== precioMenor){
                System.out.println(producto);
            }
        }
    }

    private void sinStock(){
        System.out.println("------------------------------");
        System.out.println("Productos sin stock:");
        for (Producto producto:this){
            if (producto.getStock()==0){
                System.out.println(producto);
            }
        }
    }


    private void rangoDePrecios(double precioMin, double precioMax){
        System.out.println("------------------------------");
        System.out.println("Productos entre $"+precioMin+" y $"+precioMax);
        for (Producto producto:this) {
            if ((producto.getPrecio() >= precioMin)&&(producto.getPrecio()<=precioMax)) {
                System.out.println(producto);
            }
        }
    }
    private void rangoDePrecios(){
        System.out.println("Ingrese un precio mínimo:");
        double precioMin=leer.nextDouble();
        System.out.println("Ingrese un precio máximo: ");
        double precioMax=leer.nextDouble();
        System.out.println("------------------------------");
        System.out.println("Productos entre $"+precioMin+" y $"+precioMax);
        for (Producto producto:this) {
            if ((producto.getPrecio() >= precioMin)&&(producto.getPrecio()<=precioMax)) {
                System.out.println(producto);
            }
        }
    }


    private void productosPorMarca(){
        System.out.println("------------------------------");
        System.out.println("Ingrese la marca a buscar:");
        String marca = leer.nextLine();
        for (Producto producto:this){
            if (producto.getMarca().equalsIgnoreCase(marca)){
                System.out.println(producto);
            }
        }
    }

    private void productosPorMarca(String marca){
        System.out.println("------------------------------");
        for (Producto producto:this){
            if (producto.getMarca().equalsIgnoreCase(marca)){
                System.out.println(producto);
            }
        }
    }

    private void consultarPrecio(){
        System.out.println("------------------------------");
        System.out.println("Ingrese nombre del producto:");
        String nombre = leer.nextLine();
        for(Producto producto:this){
            if (producto.getNombre().equalsIgnoreCase(nombre)){
                System.out.println(producto.getNombre()+" = $"+producto.getPrecio());
            }
        }
    }

    public static void main(String[] args) {
        ListaDeProductos lista = new ListaDeProductos();
        lista.agregarProducto("jabon","dove",35,60);
        lista.agregarProducto("bizcochos dulces","don satur",20,0);
        lista.agregarProducto("detergente","magistral",65,20);
        lista.agregarProducto("gaseosa","coca cola",65,32);
        lista.agregarProducto("gaseosa", "sprite",60,40);
        lista.agregarProducto("cerveza","brahma",55,24);
        lista.agregarProducto("cerveza","stella artois",70,20);
        lista.agregarProducto("alfajor triple","jorgelin",25,0);
        lista.agregarProducto("papel higienico","elite",65,28);
        lista.agregarProducto("galletitas","bagley",25,19);
        lista.agregarProducto("servilletas", "elite", 35,27);
        lista.agregarProducto("mayonesa", "natura", 20,27);
        lista.rangoDePrecios(20,30);
        lista.rangoDePrecios();
        //lista.consultarPrecio();
        //lista.sinStock();
        //lista.precioMayor();
        //lista.precioMenor();
        //lista.mostrarLista();
        //lista.productosPorMarca();
    }
}