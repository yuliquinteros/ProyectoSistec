package com.ada.sistec.proyectoFinal.repository;

import com.ada.sistec.proyectoFinal.model.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface RolRepository extends CrudRepository<Rol, Integer> {

    @Query(value = "select r.* from usuario as u, rol as r where u.id_rol = r.id and u.id = :userId", nativeQuery = true)
    Collection<Rol> getRolesByUser(@Param("userId") String userId);

}
