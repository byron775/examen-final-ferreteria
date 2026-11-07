package com.examen.ferreteria.repository;

import com.examen.ferreteria.dto.ClienteFacturaDTO;
import com.examen.ferreteria.dto.ClienteFacturaDetalleDTO;
import com.examen.ferreteria.entity.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Endpoint 3: Factura -> Cliente, solo facturas activas, ordenado por fecha
    @Query("SELECT new com.examen.ferreteria.dto.ClienteFacturaDTO("
         + "c.nombre, c.apellido, c.nit, f.fechaFactura, f.total) "
         + "FROM Factura f JOIN f.idCliente c "
         + "WHERE f.estado = true "
         + "ORDER BY f.fechaFactura")
    List<ClienteFacturaDTO> reporteClienteFactura();

    // Endpoint 4: tres JOIN, siete campos, solo facturas activas
    @Query("SELECT new com.examen.ferreteria.dto.ClienteFacturaDetalleDTO("
         + "c.nombre, c.apellido, f.fechaFactura, a.nombre, "
         + "d.cantidad, d.precioUnitario, d.subtotal) "
         + "FROM FacturaDetalle d "
         + "JOIN d.idFactura f "
         + "JOIN f.idCliente c "
         + "JOIN d.idArticulo a "
         + "WHERE f.estado = true "
         + "ORDER BY f.fechaFactura")
    List<ClienteFacturaDetalleDTO> reporteClienteFacturaDetalle();
}
