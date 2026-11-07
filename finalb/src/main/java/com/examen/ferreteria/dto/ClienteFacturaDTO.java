package com.examen.ferreteria.dto;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteFacturaDTO {

    private String nombreCliente;
    private String apellidoCliente;
    private String nit;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Guatemala")
    private Date fechaFactura;
    private BigDecimal total;

    public ClienteFacturaDTO() {
    }

    // Mismo ORDEN que el SELECT new ... del @Query
    public ClienteFacturaDTO(String nombreCliente, String apellidoCliente, String nit, Date fechaFactura, BigDecimal total) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.nit = nit;
        this.fechaFactura = fechaFactura;
        this.total = total;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
