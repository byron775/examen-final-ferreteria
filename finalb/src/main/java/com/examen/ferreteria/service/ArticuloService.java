package com.examen.ferreteria.service;

import com.examen.ferreteria.dto.ArticuloCategoriaDTO;
import com.examen.ferreteria.dto.ArticuloDTO;
import com.examen.ferreteria.repository.ArticuloRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArticuloService {

    private final ArticuloRepository articuloRepository;

    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public List<ArticuloDTO> mostrarActivosFiltro(String nombre) {
        return articuloRepository.findByEstadoTrueAndNombreContainingIgnoreCase(nombre).stream()
                .map(a -> new ArticuloDTO(a.getNombre(), a.getMarca(), a.getPrecio(), a.getStock()))
                .toList();
    }

    public List<ArticuloCategoriaDTO> reporteArticuloCategoria() {
        return articuloRepository.reporteArticuloCategoria();
    }
}
