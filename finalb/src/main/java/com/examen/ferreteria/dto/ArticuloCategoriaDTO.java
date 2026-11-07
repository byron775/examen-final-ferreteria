package com.examen.ferreteria.dto;

import java.math.BigDecimal;

public class ArticuloCategoriaDTO {

    private String nombreArticulo;
    private String marca;
    private String nombreCategoria;
    private BigDecimal precio;
    private Integer stock;

    public ArticuloCategoriaDTO() {
    }

    // Mismo ORDEN que el SELECT new ... del @Query
    public ArticuloCategoriaDTO(String nombreArticulo, String marca, String nombreCategoria, BigDecimal precio, Integer stock) {
        this.nombreArticulo = nombreArticulo;
        this.marca = marca;
        this.nombreCategoria = nombreCategoria;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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
