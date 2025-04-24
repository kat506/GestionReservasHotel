package com.example.prcticoadapters.models;

import java.util.Date;

public class ReservaHotel extends Reserva {
    private String tipoHabitacion;
    private boolean incluyeDesayuno;
    private int numeroHuespedes;

    public ReservaHotel(String codigo, String cliente, Date fechaEntrada, Date fechaSalida,
                        double precioTotal, String tipoHabitacion, boolean incluyeDesayuno,
                        int numeroHuespedes) {
        super(codigo, cliente, fechaEntrada, fechaSalida, precioTotal);
        this.tipoHabitacion = tipoHabitacion;
        this.incluyeDesayuno = incluyeDesayuno;
        this.numeroHuespedes = numeroHuespedes;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public boolean isIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public void setIncluyeDesayuno(boolean incluyeDesayuno) {
        this.incluyeDesayuno = incluyeDesayuno;
    }

    public int getNumeroHuespedes() {
        return numeroHuespedes;
    }

    public void setNumeroHuespedes(int numeroHuespedes) {
        this.numeroHuespedes = numeroHuespedes;
    }

    @Override
    public String getTipoReserva() {
        return "Hotel";
    }
}