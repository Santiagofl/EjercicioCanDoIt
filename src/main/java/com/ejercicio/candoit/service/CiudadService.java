package com.ejercicio.candoit.service;


import com.ejercicio.candoit.model.Ciudad;

import java.util.List;

public interface CiudadService {
    void guardarVarios(List<Ciudad> ciudadList);
    void guardarResponseApi();
    void updateApi(List<Ciudad> ciudades);
    List<Ciudad>obtenerDatos();

}
