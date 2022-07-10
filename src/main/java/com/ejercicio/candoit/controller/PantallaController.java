package com.ejercicio.candoit.controller;

import com.ejercicio.candoit.model.Ciudad;
import com.ejercicio.candoit.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PantallaController {

    private CiudadService ciudadService;

    @Autowired
    public PantallaController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView irPantallaInicio() {
        ModelMap modelo = new ModelMap();
        List<Ciudad> ciudades = ciudadService.obtenerDatos();
        modelo.put("ciudades", ciudades);
        return new ModelAndView("home", modelo);
    }
}
