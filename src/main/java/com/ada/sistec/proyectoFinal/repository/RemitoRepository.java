package com.ada.sistec.proyectoFinal.repository;

import com.ada.sistec.proyectoFinal.model.Remito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RemitoRepository extends CrudRepository<Remito, Integer> {

    @Query("from Remito where day(fecha) = :day ")
    Iterable<Remito> getRemitoByDate(@Param("day") int day);

    @Query("from Remito where month(fecha) = :month and day(fecha) = :day")
    Iterable<Remito> getRemitoByDate(@Param("month") int month, @Param("day") int day);

}
