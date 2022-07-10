package com.ejercicio.candoit.service;


import com.ejercicio.candoit.dto.DTOCiudadApiResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service @Transactional
public class ForecastApiConsumptionImpl implements ForecastApiConsumptionService {
    @Override
    public List<DTOCiudadApiResponse> getDatosApiCiudad() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ws.smn.gob.ar/map_items/weather";
        ResponseEntity<DTOCiudadApiResponse[]> exchange = restTemplate.exchange(url, HttpMethod.GET, null, DTOCiudadApiResponse[].class);
        List<DTOCiudadApiResponse> listado = Arrays.asList(exchange.getBody());
        return listado;
    }


}
