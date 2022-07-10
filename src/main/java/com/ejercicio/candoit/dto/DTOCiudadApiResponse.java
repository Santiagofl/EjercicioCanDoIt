package com.ejercicio.candoit.dto;


public class DTOCiudadApiResponse {
    private String _id;
    private Integer int_number;
    private String name;
    private String province;
    private DTOClimaApiResponse weather;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getInt_number() {
        return int_number;
    }

    public void setInt_number(Integer int_number) {
        this.int_number = int_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public DTOClimaApiResponse getWeather() {
        return weather;
    }

    public void setWeather(DTOClimaApiResponse weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "DTOCiudadApiResponse{" +
                "_id='" + _id + '\'' +
                ", int_number=" + int_number +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", weather=" + weather +
                '}';
    }
}
