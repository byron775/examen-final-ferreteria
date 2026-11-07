package com.examen.ferreteria.controller;

import com.examen.ferreteria.dto.ArticuloCategoriaDTO;
import com.examen.ferreteria.dto.ArticuloDTO;
import com.examen.ferreteria.service.ArticuloService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articulos")
@CrossOrigin(origins = "*")
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/mostrarActivosFiltro")
    public List<ArticuloDTO> mostrarActivosFiltro(@RequestParam String nombre) {
        return articuloService.mostrarActivosFiltro(nombre);
    }

    @GetMapping("/reporteArticuloCategoria")
    public List<ArticuloCategoriaDTO> reporteArticuloCategoria() {
        return articuloService.reporteArticuloCategoria();
    }
}
