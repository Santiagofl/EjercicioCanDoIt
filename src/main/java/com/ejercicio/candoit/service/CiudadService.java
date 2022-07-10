package com.ejercicio.candoit.service;


import com.ejercicio.candoit.model.Ciudad;

import java.util.List;

public interface CiudadService {
    void guardarVarios(List<Ciudad> ciudadList);
    Boolean guardarResponseApi();
    void updateApi();
    List<Ciudad>obtenerDatos();

}
