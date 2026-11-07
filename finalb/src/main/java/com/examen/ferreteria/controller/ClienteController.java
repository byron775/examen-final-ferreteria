package com.examen.ferreteria.controller;

import com.examen.ferreteria.dto.ClienteFacturaDTO;
import com.examen.ferreteria.dto.ClienteFacturaDetalleDTO;
import com.examen.ferreteria.service.ClienteService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/reporteClienteFactura")
    public List<ClienteFacturaDTO> reporteClienteFactura() {
        return clienteService.reporteClienteFactura();
    }

    @GetMapping("/reporteClienteFacturaDetalle")
    public List<ClienteFacturaDetalleDTO> reporteClienteFacturaDetalle() {
        return clienteService.reporteClienteFacturaDetalle();
    }
}
