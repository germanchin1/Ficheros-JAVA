package org.example.demojdbc.model;

import java.math.BigDecimal;

public class Producto {

    private int id;
    private String nombre;
    private double precio;

    // Constructor con parámetros (id, nombre, precio)
    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Constructor sin parámetros (por si lo necesitas para la persistencia, como cuando usas BeanUtils o frameworks de reflexión)
    public Producto() {}

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
