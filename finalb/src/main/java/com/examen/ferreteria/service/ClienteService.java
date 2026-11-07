package com.examen.ferreteria.service;

import com.examen.ferreteria.dto.ClienteFacturaDTO;
import com.examen.ferreteria.dto.ClienteFacturaDetalleDTO;
import com.examen.ferreteria.repository.ClienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteFacturaDTO> reporteClienteFactura() {
        return clienteRepository.reporteClienteFactura();
    }

    public List<ClienteFacturaDetalleDTO> reporteClienteFacturaDetalle() {
        return clienteRepository.reporteClienteFacturaDetalle();
    }
}
