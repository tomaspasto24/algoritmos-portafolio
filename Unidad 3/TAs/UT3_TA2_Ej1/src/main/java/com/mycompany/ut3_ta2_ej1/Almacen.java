/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut3_ta2_ej1;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author TomasUcu
 */
public class Almacen implements IAlmacen {
    
    private String direccion;
    private String telefono;
    private String nombre;
    private ILista<IProducto> productos;

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Lista getListaProductos() {
        return (Lista) productos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        productos.insertar(new Nodo(unProducto.getEtiqueta(), unProducto));
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return productos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        return productos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return productos.imprimir(separador);
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        IProducto producto = buscarPorCodigo(clave);
        producto.setStock(producto.getStock() + cantidad);
        return true;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        IProducto producto = buscarPorCodigo(clave);
        
        Integer stock = producto.getStock();
        if (stock <= cantidad) {
            producto.setStock(0);
        } else {
            producto.setStock(stock - cantidad);
        }
        return producto.getStock();
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        INodo<IProducto> nodoProducto = productos.buscar(clave);
        if(nodoProducto == null) {
            return null;
        }
        return (Producto) nodoProducto.getDato();
    }

    @Override
    public void listarOrdenadoPorNombre() {
        ListaOrdenada<IProducto> listaOrdenada = new ListaOrdenada<>();
        for() {
            listaOrdenada.insertarOrdenado(new Nodo(producto.getEtiqueta(), producto));
        }
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cantidadProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
