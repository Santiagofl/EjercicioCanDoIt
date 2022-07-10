package com.ejercicio.candoit.repository;


import com.ejercicio.candoit.model.Ciudad;

import java.util.List;

public interface CiudadRepository{
    List<Ciudad> findAll();
    void save(Ciudad ciudad);
    void saveAll(List<Ciudad> ciudad);

}
