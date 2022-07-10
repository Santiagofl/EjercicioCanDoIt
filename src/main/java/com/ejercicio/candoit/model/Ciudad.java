package com.ejercicio.candoit.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private String localidad;
    private String provincia;
    private String temperatura;

    public Ciudad(Long id, Integer numero, String localidad, String provincia, String temperatura) {
        this.id = id;

        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
        this.temperatura = temperatura;
    }

    public Ciudad() {

    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id=" + id +
                ", intNumber=" + numero +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", temperatura='" + temperatura + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer intNumber) {
        this.numero = intNumber;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}
