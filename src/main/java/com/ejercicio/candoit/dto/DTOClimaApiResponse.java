package com.ejercicio.candoit.dto;


public class DTOClimaApiResponse {

    private String tempDesc;

    public String getTempDesc() {
        return tempDesc;
    }
    public void setTempDesc(String tempDesc) {
        this.tempDesc = tempDesc;
    }
    @Override
    public String toString() {
        return "DTOClimaApiResponse{" +
                "tempDesc='" + tempDesc + '\'' +
                '}';
    }
}
