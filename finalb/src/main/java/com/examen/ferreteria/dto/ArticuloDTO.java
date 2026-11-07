package com.examen.ferreteria.dto;

import java.math.BigDecimal;

public class ArticuloDTO {

    private String nombre;
    private String marca;
    private BigDecimal precio;
    private Integer stock;

    public ArticuloDTO() {
    }

    // Mismo ORDEN que el SELECT new ... del @Query
    public ArticuloDTO(String nombre, String marca, BigDecimal precio, Integer stock) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
