package com.ada.sistec.proyectoFinal.repository;

import com.ada.sistec.proyectoFinal.model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

@Query("from Producto where nombreProd like %:nombreProd%")
    Iterable<Producto> getProductosByNombre(@Param("nombreProd") String nombreProd);
}


