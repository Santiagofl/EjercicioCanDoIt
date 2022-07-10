package com.ejercicio.candoit.controller;

import com.ejercicio.candoit.dto.DTOCiudadApiResponse;
import com.ejercicio.candoit.service.CiudadService;
import com.ejercicio.candoit.service.ForecastApiConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final CiudadService ciudadService;

    private final ForecastApiConsumptionService forecastApiConsumptionService;

    @Autowired
    public ApiController(ForecastApiConsumptionService forecastApiConsumptionService, CiudadService ciudadService) {
        this.forecastApiConsumptionService = forecastApiConsumptionService;
        this.ciudadService = ciudadService;
    }

    @RequestMapping(path="/api", method = RequestMethod.GET)
    public List<DTOCiudadApiResponse> getDatosForecastApi() {
        List<DTOCiudadApiResponse> response = forecastApiConsumptionService.getDatosApiCiudad();
        return response;
    }
    @RequestMapping(path="/alta-masiva", method = RequestMethod.POST)
    public void guardarReponseApi() {
         ciudadService.guardarResponseApi();
    }

}
