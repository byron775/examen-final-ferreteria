package com.examen.ferreteria.repository;

import com.examen.ferreteria.dto.ArticuloCategoriaDTO;
import com.examen.ferreteria.entity.Articulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {

    // Endpoint 1: activos + nombre contiene (sin distinguir mayúsculas)
    List<Articulo> findByEstadoTrueAndNombreContainingIgnoreCase(String nombre);

    // Endpoint 2: JOIN a categoría, 5 campos, ordenado por categoría y nombre
    @Query("SELECT new com.examen.ferreteria.dto.ArticuloCategoriaDTO("
         + "a.nombre, a.marca, c.nombre, a.precio, a.stock) "
         + "FROM Articulo a JOIN a.idCategoria c "
         + "WHERE a.estado = true "
         + "ORDER BY c.nombre, a.nombre")
    List<ArticuloCategoriaDTO> reporteArticuloCategoria();
}
