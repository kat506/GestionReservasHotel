package com.example.prcticoadapters.models;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable {
    private String codigo;
    private String cliente;
    private Date fechaEntrada;
    private Date fechaSalida;
    private double precioTotal;

    public Reserva(String codigo, String cliente, Date fechaEntrada, Date fechaSalida, double precioTotal) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioTotal = precioTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getTipoReserva() {
        return "Reserva Estándar";
    }
}