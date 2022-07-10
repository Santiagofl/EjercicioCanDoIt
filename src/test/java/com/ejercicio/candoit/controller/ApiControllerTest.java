package com.ejercicio.candoit.controller;

import com.ejercicio.candoit.dto.DTOCiudadApiResponse;
import com.ejercicio.candoit.model.Ciudad;
import com.ejercicio.candoit.service.CiudadService;
import com.ejercicio.candoit.service.ForecastApiConsumptionService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiControllerTest {
    private  CiudadService ciudadService;
    private  ForecastApiConsumptionService forecastApiConsumptionService;
    private  ApiController apiController;


    @Before
    public void init(){
        ciudadService = mock(CiudadService.class);
        forecastApiConsumptionService = mock(ForecastApiConsumptionService.class);
        apiController = new ApiController(forecastApiConsumptionService,ciudadService);

    }

    @Test
    public void queLaApiSeConsuma(){
        //Preparacion
        dadoQueExisteUnaApi(10);

        //Ejecucion
        List<DTOCiudadApiResponse> response = apiController.getDatosForecastApi();

        entoncesEncuentro(response, 10);
    }

    @Test
    public void queSePasenLosDatosDeLaApiAlService(){
        //Preparacion
        dadoQuePasamosDatosDeLaApi();

        //Ejecucion
        Boolean resultado = apiController.guardarReponseApi();

        entoncesEncuentroQueElGuardadoFue(resultado, true);
    }

    private void entoncesEncuentroQueElGuardadoFue(Boolean resultado, Boolean resultadoEsperado) {
        assertThat(resultado).isEqualTo(resultadoEsperado);
    }

    private void dadoQuePasamosDatosDeLaApi() {
        when(ciudadService.guardarResponseApi()).thenReturn(true);
    }

    private void entoncesEncuentro(List<DTOCiudadApiResponse> response, int cantidadEsperada) {
        assertThat(response).hasSize(cantidadEsperada);
    }

    private void dadoQueExisteUnaApi(int cantidad) {
        List<DTOCiudadApiResponse> lista = new LinkedList<>();
        for(int i = 0 ; i < cantidad; i++){
            lista.add(new DTOCiudadApiResponse());
        }
        when(forecastApiConsumptionService.getDatosApiCiudad()).thenReturn(lista);
    }


}
