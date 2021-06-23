package com.ada.sistec.proyectoFinal.repository;

import com.ada.sistec.proyectoFinal.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("from Usuario where nom_y_ap like %:nom_y_ap%")
    Iterable<Usuario> getUsuarioByName(@Param("nom_y_ap") String nom_y_ap);


}
