package com.ejercicio.candoit.repository;

import com.ejercicio.candoit.SpringTest;
import com.ejercicio.candoit.model.Ciudad;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CiudadRepositoryTest extends SpringTest {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Test
    @Transactional
    @Rollback
    public void busquedaPublicacionesConDevolucion(){

        dadoQueExisteUnaListaDeCiudades();

        List<Ciudad> ciudades = ciudadRepository.findAll();

        entoncesMeDevuelveUnaListaDePublicacionesQueCoinciden(ciudades,5);
    }
    @Test
    @Transactional
    @Rollback
    public void busquedaPublicacionesSinDevolucion(){

        List<Ciudad> ciudades = ciudadRepository.findAll();

        entoncesMeDevuelveUnaListaDePublicacionesQueCoinciden(ciudades,0);
    }


    private void entoncesMeDevuelveUnaListaDePublicacionesQueCoinciden(List<Ciudad> propiedades,int cantidadEsperada) {
        assertThat(propiedades).hasSize(cantidadEsperada);
    }

    private void dadoQueExisteUnaListaDeCiudades() {
        Ciudad ciudad1 = new Ciudad();
        Ciudad ciudad2 = new Ciudad();
        Ciudad ciudad3 = new Ciudad();
        Ciudad ciudad4 = new Ciudad();
        Ciudad ciudad5 = new Ciudad();

        session().save(ciudad1);
        session().save(ciudad2);
        session().save(ciudad3);
        session().save(ciudad4);
        session().save(ciudad5);

    }
}
