package com.example.prcticoadapters.utils;

import com.example.prcticoadapters.models.Reserva;
import com.example.prcticoadapters.models.ReservaCabaña;
import com.example.prcticoadapters.models.ReservaGlamping;
import com.example.prcticoadapters.models.ReservaHotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservasDataProvider {

    private static List<Reserva> listaReservas = new ArrayList<>();
    private static boolean datosInicializados = false;

    public static void inicializarDatos() {
        if (datosInicializados) {
            return;
        }

        // Crear fechas de ejemplo
        Calendar cal = Calendar.getInstance();

        // Fecha 1: actual
        Date fechaActual = cal.getTime();

        // Fecha 2: actual + 5 días
        cal.add(Calendar.DAY_OF_MONTH, 5);
        Date fecha5Dias = cal.getTime();

        // Fecha 3: actual + 10 días
        cal.add(Calendar.DAY_OF_MONTH, 5);
        Date fecha10Dias = cal.getTime();

        // Fecha 4: actual + 15 días
        cal.add(Calendar.DAY_OF_MONTH, 5);
        Date fecha15Dias = cal.getTime();

        // Fecha 5: actual + 20 días
        cal.add(Calendar.DAY_OF_MONTH, 5);
        Date fecha20Dias = cal.getTime();

        // Fecha 6: actual + 25 días
        cal.add(Calendar.DAY_OF_MONTH, 5);
        Date fecha25Dias = cal.getTime();

        // Agregar reserva estándar
        listaReservas.add(new Reserva(
                "RES001",
                "Rodrigo García",
                fechaActual,
                fecha5Dias,
                350.0
        ));

        // Agregar reservas de hotel
        listaReservas.add(new ReservaHotel(
                "HOT001",
                "Juan Villazon",
                fecha5Dias,
                fecha10Dias,
                1000.0,
                "Habitación Superior",
                true,
                2
        ));


        listaReservas.add(new ReservaHotel(
                "HOT002",
                "Carlos Escobar",
                fecha10Dias,
                fecha15Dias,
                350.0,
                "Habitación Superior",
                false,
                1
        ));

        listaReservas.add(new ReservaHotel(
                "HOT003",
                "Ksthleen Barrientos",
                fecha10Dias,
                fecha15Dias,
                700.0,
                "Suite Ejecutiva",
                true,
                3
        ));

        listaReservas.add(new ReservaHotel(
                "HOT004",
                "Didier Flores",
                fecha5Dias,
                fecha20Dias,
                550.0,
                "Suite Ejecutiva",
                true,
                4
        ));

        listaReservas.add(new ReservaHotel(
                "HOT005",
                "Franco Avaro",
                fecha5Dias,
                fecha15Dias,
                700.0,
                "Habitación Estándar",
                false,
                1
        ));

        // Agregar reservas de cabaña
        listaReservas.add(new ReservaCabaña(
                "CAB001",
                "Claudia Rodriguez",
                fecha15Dias,
                fecha20Dias,
                890.0,
                85.5,
                true,
                2
        ));

        listaReservas.add(new ReservaCabaña(
                "CAB002",
                "Lorando Rola",
                fechaActual,
                fecha10Dias,
                1200.0,
                120.0,
                true,
                6
        ));

        listaReservas.add(new ReservaCabaña(
                "CAB003",
                "Carla Cespedes",
                fecha15Dias,
                fecha20Dias,
                1200.0,
                90,
                false,
                2
        ));

        listaReservas.add(new ReservaCabaña(
                "CAB004",
                "Thyara Graña",
                fecha15Dias,
                fecha20Dias,
                500.0,
                40.5,
                false,
                1
        ));

        listaReservas.add(new ReservaCabaña(
                "CAB005",
                "Luis Gonzales",
                fecha15Dias,
                fecha25Dias,
                390.0,
                89.5,
                true,
                5
        ));

        // Agregar reservas de glamping
        listaReservas.add(new ReservaGlamping(
                "GLA001",
                "Maria Lopez",
                fecha5Dias,
                fecha15Dias,
                950.0,
                45.0,
                false,
                2,
                "Aventura Natural",
                Arrays.asList("Senderismo", "Observación de estrellas", "Yoga")
        ));

        listaReservas.add(new ReservaGlamping(
                "GLA002",
                "Edan Barrientos",
                fecha20Dias,
                fecha25Dias,
                1100.0,
                60.0,
                true,
                3,
                "Experiencia Premium",
                Arrays.asList("Masaje relajante", "Paseo en bote", "Cena en la naturaleza")
        ));

        listaReservas.add(new ReservaGlamping(
                "GLA003",
                "Manuel Quispe",
                fecha10Dias,
                fecha15Dias,
                1500.0,
                90.0,
                true,
                6,
                "Gastronómica y Cultural",
                Arrays.asList("Cena gourmet al aire libre", "Cata de vinos", "Talleres de cocina tradicional")
        ));

        listaReservas.add(new ReservaGlamping(
                "GLA004",
                "Marco Benite",
                fecha10Dias,
                fecha25Dias,
                720.0,
                60.0,
                true,
                2,
                "Relajación y Bienestar",
                Arrays.asList("Sesión de spa al aire libre", "Baños en tina de hidromasaje", "Clases de meditación al amanecer")
        ));

        listaReservas.add(new ReservaGlamping(
                "GLA005",
                "Erwin Moreno",
                fecha20Dias,
                fecha25Dias,
                300.0,
                45.0,
                false,
                1,
                "Aventura Natural",
                Arrays.asList("Senderismo", "Observación de estrellas", "Yoga")
        ));

        datosInicializados = true;
    }

    public static List<Reserva> getListaReservas() {
        if (!datosInicializados) {
            inicializarDatos();
        }
        return listaReservas;
    }
}
