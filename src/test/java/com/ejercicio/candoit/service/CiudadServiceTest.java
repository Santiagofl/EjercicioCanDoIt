package com.ejercicio.candoit.service;

import com.ejercicio.candoit.dto.DTOCiudadApiResponse;
import com.ejercicio.candoit.dto.DTOClimaApiResponse;
import com.ejercicio.candoit.model.Ciudad;
import com.ejercicio.candoit.repository.CiudadRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CiudadServiceTest {

    private CiudadRepository ciudadRepository;
    private ForecastApiConsumptionService forecastApiConsumptionService;

    private CiudadService ciudadService;

    @Before
    public void init() {
        ciudadRepository = mock(CiudadRepository.class);
        forecastApiConsumptionService = mock(ForecastApiConsumptionService.class);
        ciudadService = new CiudadServiceImpl(ciudadRepository,forecastApiConsumptionService);
    }

    @Test
    public void queSeGuardenTodosLosDatosDeLaApiEnElRepositorio(){
        //Preparacion
        dadoQueExisteUnaApi(10);

        //Ejecucion
        Boolean resultado = ciudadService.guardarResponseApi();

        entoncesEncuentro(resultado, true);
    }

    @Test
    public void queAlBuscarLasCiudadesMeTraigaUnaLista(){
        //Preparacion
        dadoQueExisteUnaListaDeCiudades(10);

        //Ejecucion
        List<Ciudad> resultado = ciudadService.obtenerDatos();

        entoncesEncuentroCon(resultado, 10);
    }

    private void entoncesEncuentroCon(List<Ciudad> resultado, int cantidadEsperada) {
        assertThat(resultado).hasSize(cantidadEsperada);
    }

    private void dadoQueExisteUnaListaDeCiudades(int cantidad) {
        List<Ciudad> lista = new LinkedList<>();
        for(int i = 0 ; i < cantidad; i++){
            lista.add(new Ciudad());
        }
        when(ciudadService.obtenerDatos()).thenReturn(lista);
    }

    private void entoncesEncuentro(Boolean resultado, boolean resultadoEsperado) {
        assertThat(resultado).isEqualTo(resultadoEsperado);
    }


    private void dadoQueExisteUnaApi(int cantidad) {
        List<DTOCiudadApiResponse> lista = new LinkedList<>();
        for(int i = 0 ; i < cantidad; i++){
            lista.add(new DTOCiudadApiResponse("1",87544,"Pehuajo","Buenos Aires"
                    , new DTOClimaApiResponse("13.9ºC")));
        }
        when(forecastApiConsumptionService.getDatosApiCiudad()).thenReturn(lista);
    }
}
