package com.example.prcticoadapters.models;

import java.util.Date;

public class ReservaCabaña extends Reserva {
    private double metrosCuadrados;
    private boolean tieneChimenea;
    private int capacidadMaxima;

    public ReservaCabaña(String codigo, String cliente, Date fechaEntrada, Date fechaSalida,
                         double precioTotal, double metrosCuadrados, boolean tieneChimenea,
                         int capacidadMaxima) {
        super(codigo, cliente, fechaEntrada, fechaSalida, precioTotal);
        this.metrosCuadrados = metrosCuadrados;
        this.tieneChimenea = tieneChimenea;
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public boolean isTieneChimenea() {
        return tieneChimenea;
    }

    public void setTieneChimenea(boolean tieneChimenea) {
        this.tieneChimenea = tieneChimenea;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public String getTipoReserva() {
        return "Cabaña";
    }
}