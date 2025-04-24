package com.example.prcticoadapters.models;

import java.util.Date;
import java.util.List;

public class ReservaGlamping extends ReservaCabaña {
    private String tipoExperiencia;
    private List<String> actividadesIncluidas;

    public ReservaGlamping(String codigo, String cliente, Date fechaEntrada, Date fechaSalida,
                           double precioTotal, double metrosCuadrados, boolean tieneChimenea,
                           int capacidadMaxima, String tipoExperiencia, List<String> actividadesIncluidas) {
        super(codigo, cliente, fechaEntrada, fechaSalida, precioTotal, metrosCuadrados, tieneChimenea, capacidadMaxima);
        this.tipoExperiencia = tipoExperiencia;
        this.actividadesIncluidas = actividadesIncluidas;
    }

    public String getTipoExperiencia() {
        return tipoExperiencia;
    }

    public void setTipoExperiencia(String tipoExperiencia) {
        this.tipoExperiencia = tipoExperiencia;
    }

    public List<String> getActividadesIncluidas() {
        return actividadesIncluidas;
    }

    public void setActividadesIncluidas(List<String> actividadesIncluidas) {
        this.actividadesIncluidas = actividadesIncluidas;
    }

    @Override
    public String getTipoReserva() {
        return "Glamping";
    }
}