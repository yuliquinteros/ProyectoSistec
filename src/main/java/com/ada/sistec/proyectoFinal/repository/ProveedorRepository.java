package com.ada.sistec.proyectoFinal.repository;

import com.ada.sistec.proyectoFinal.model.Producto;
import com.ada.sistec.proyectoFinal.model.Proveedor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProveedorRepository extends CrudRepository<Proveedor, Integer> {

    @Query("from Proveedor where nombre like %:nombre%")
    Iterable<Proveedor> getProveedorByName(@Param("nombre") String nombre);


}
