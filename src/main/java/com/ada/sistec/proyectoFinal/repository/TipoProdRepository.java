package com.ada.sistec.proyectoFinal.repository;

import com.ada.sistec.proyectoFinal.model.TipoProd;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProdRepository extends CrudRepository<TipoProd, Integer> {
}
