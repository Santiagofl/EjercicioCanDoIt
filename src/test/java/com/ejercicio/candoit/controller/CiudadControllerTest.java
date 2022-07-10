package com.ejercicio.candoit.controller;

import com.ejercicio.candoit.model.Ciudad;
import com.ejercicio.candoit.service.CiudadService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CiudadControllerTest {

    private static final String VISTA_LISTA_PUBLICACIONES = "home";
    private CiudadService ciudadService;
    private CiudadController ciudadController;

    @Before
    public void init(){
        ciudadService = mock(CiudadService.class);
        ciudadController = new CiudadController(ciudadService);
    }

    @Test
    public void alIniciarElProyectoMeLlevaAlaPaginaDeInicioConLasCiudades(){
        //Preparacion
        dadoQueTenemosUnaListaDeCiudades(10);

        //Ejecucion
        ModelAndView mav = cuandoBuscoUnaCiudad();

        entoncesEncuentro(mav, 10);
        entoncesMeLLevaALaVista(VISTA_LISTA_PUBLICACIONES, mav.getViewName());
    }

    private void entoncesMeLLevaALaVista(String vistaEsperada, String vistaRecibida) {
        assertThat(vistaRecibida).isEqualTo(vistaEsperada);
    }

    private void entoncesEncuentro(ModelAndView mav, int cantidadEsperada) {
        List<Ciudad> lista = (List<Ciudad>) mav.getModel().get("ciudades");
        assertThat(lista).hasSize(cantidadEsperada);
    }

    private ModelAndView cuandoBuscoUnaCiudad() {
        return ciudadController.irPantallaInicio();
    }

    private void dadoQueTenemosUnaListaDeCiudades(int cantidad) {
        List<Ciudad> lista = new LinkedList<>();
        for(int i = 0 ; i < cantidad; i++){
            lista.add(new Ciudad());
        }
        when(ciudadService.obtenerDatos()).thenReturn(lista);
    }
}
