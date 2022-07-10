package com.ejercicio.candoit.service;


import com.ejercicio.candoit.dto.DTOCiudadApiResponse;
import com.ejercicio.candoit.model.Ciudad;
import com.ejercicio.candoit.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service @Transactional @EnableScheduling
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository ciudadRepository;
    private final ForecastApiConsumptionService forecastApiConsumptionService;

    @Autowired
    public CiudadServiceImpl(CiudadRepository ciudadRepository, ForecastApiConsumptionService forecastApiConsumptionService) {
        this.ciudadRepository = ciudadRepository;
        this.forecastApiConsumptionService = forecastApiConsumptionService;
    }

    @Override
    public void guardarVarios(List<Ciudad> ciudadList) {
         ciudadRepository.saveAll(ciudadList);
    }

    @Scheduled(cron = "0 0/5 * * * *")
    @Override
    public void guardarResponseApi() {
        List<Ciudad> listado = ciudadRepository.findAll();
        if(listado.isEmpty()){
            List<DTOCiudadApiResponse> datosApiCiudad = forecastApiConsumptionService.getDatosApiCiudad();
            List<Ciudad> ciudads = new ArrayList<>();
            datosApiCiudad.forEach( response ->{
                ciudads.add(new Ciudad(null,response.getInt_number(),response.getName(), response.getProvince(),
                        response.getWeather().getTempDesc()));
            });
            this.guardarVarios(ciudads);
        }else{
            this.updateApi(listado);
        }
    }
    @Override
    public void updateApi(List<Ciudad> ciudades) {
            List<DTOCiudadApiResponse> datosApiCiudad = forecastApiConsumptionService.getDatosApiCiudad();
            for (Ciudad ciudad:ciudades) {
                DTOCiudadApiResponse responseSearch = getDTO(ciudad.getNumero(),datosApiCiudad);
                ciudad.setLocalidad(responseSearch.getName());
                ciudad.setProvincia(responseSearch.getProvince());
                ciudad.setTemperatura(responseSearch.getWeather().getTempDesc());
                ciudadRepository.save(ciudad);
            }
    }

    @Override
    public List<Ciudad> obtenerDatos() {
        return ciudadRepository.findAll();
    }

    private DTOCiudadApiResponse getDTO(Integer intNumber, List<DTOCiudadApiResponse> datosApiCiudad){
        for (DTOCiudadApiResponse datos: datosApiCiudad) {
            if(datos.getInt_number().equals(intNumber)){
                return datos;
            }
        }
        return null;
    }
}
