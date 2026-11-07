package com.examen.ferreteria.dto;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteFacturaDetalleDTO {

    private String nombreCliente;
    private String apellidoCliente;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Guatemala")
    private Date fechaFactura;
    private String nombreArticulo;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    public ClienteFacturaDetalleDTO() {
    }

    // Mismo ORDEN que el SELECT new ... del @Query
    public ClienteFacturaDetalleDTO(String nombreCliente, String apellidoCliente, Date fechaFactura, String nombreArticulo, Integer cantidad, BigDecimal precioUnitario, BigDecimal subtotal) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.fechaFactura = fechaFactura;
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
