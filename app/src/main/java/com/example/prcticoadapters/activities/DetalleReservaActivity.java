package com.example.prcticoadapters.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.prcticoadapters.R;
import com.example.prcticoadapters.models.Reserva;
import com.example.prcticoadapters.models.ReservaCabaña;
import com.example.prcticoadapters.models.ReservaGlamping;
import com.example.prcticoadapters.models.ReservaHotel;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DetalleReservaActivity extends AppCompatActivity {

    private TextView tvTituloDetalle, tvTipoReservaDetalle;
    private TextView tvCodigoDetalle, tvClienteDetalle, tvFechasDetalle, tvPrecioDetalle;
    private LinearLayout layoutTipoReserva;
    private LinearLayout layoutCaracteristicasHotel, layoutCaracteristicasCabana, layoutCaracteristicasGlamping;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_reserva);

        // Obtener la reserva del intent
        Reserva reserva = (Reserva) getIntent().getSerializableExtra("reserva");
        if (reserva == null) {
            finish();
            return;
        }

        // Inicializar vistas
        initViews();

        // Configurar datos comunes
        configurarDatosComunes(reserva);

        // Configurar detalles específicos según el tipo de reserva
        if (reserva instanceof ReservaGlamping) {
            configurarDetallesGlamping((ReservaGlamping) reserva);
        } else if (reserva instanceof ReservaCabaña) {
            configurarDetallesCabana((ReservaCabaña) reserva);
        } else if (reserva instanceof ReservaHotel) {
            configurarDetallesHotel((ReservaHotel) reserva);
        }
    }

    private void initViews() {
        tvTituloDetalle = findViewById(R.id.tvTituloDetalle);
        tvTipoReservaDetalle = findViewById(R.id.tvTipoReservaDetalle);
        tvCodigoDetalle = findViewById(R.id.tvCodigoDetalle);
        tvClienteDetalle = findViewById(R.id.tvClienteDetalle);
        tvFechasDetalle = findViewById(R.id.tvFechasDetalle);
        tvPrecioDetalle = findViewById(R.id.tvPrecioDetalle);
        layoutTipoReserva = findViewById(R.id.layoutTipoReserva);

        layoutCaracteristicasHotel = findViewById(R.id.layoutCaracteristicasHotel);
        layoutCaracteristicasCabana = findViewById(R.id.layoutCaracteristicasCabana);
        layoutCaracteristicasGlamping = findViewById(R.id.layoutCaracteristicasGlamping);
    }

    private void configurarDatosComunes(Reserva reserva) {
        tvTituloDetalle.setText("Detalles de la Reserva");
        tvTipoReservaDetalle.setText(reserva.getTipoReserva());
        tvCodigoDetalle.setText("Código: " + reserva.getCodigo());
        tvClienteDetalle.setText("Cliente: " + reserva.getCliente());

        String fechas = "Fechas: Del " + dateFormat.format(reserva.getFechaEntrada()) +
                " al " + dateFormat.format(reserva.getFechaSalida());
        tvFechasDetalle.setText(fechas);

        tvPrecioDetalle.setText(String.format("Precio Total: $%.2f", reserva.getPrecioTotal()));

        // Configurar color según tipo de reserva
        int colorBackground;
        if (reserva instanceof ReservaGlamping) {
            colorBackground = R.color.colorGlamping;
        } else if (reserva instanceof ReservaCabaña) {
            colorBackground = R.color.colorCabana;
        } else if (reserva instanceof ReservaHotel) {
            colorBackground = R.color.colorHotel;
        } else {
            colorBackground = R.color.colorEstandar;
        }

        tvTipoReservaDetalle.setBackgroundColor(ContextCompat.getColor(this, colorBackground));
    }

    private void configurarDetallesHotel(ReservaHotel hotel) {
        // Mostrar layout de hotel y ocultar los demás
        layoutCaracteristicasHotel.setVisibility(View.VISIBLE);
        layoutCaracteristicasCabana.setVisibility(View.GONE);
        layoutCaracteristicasGlamping.setVisibility(View.GONE);

        // Configurar detalles específicos de hotel
        TextView tvTipoHabitacion = findViewById(R.id.tvTipoHabitacion);
        TextView tvDesayuno = findViewById(R.id.tvDesayuno);
        TextView tvHuespedes = findViewById(R.id.tvHuespedes);

        tvTipoHabitacion.setText("Tipo de Habitación: " + hotel.getTipoHabitacion());
        tvDesayuno.setText("Desayuno: " + (hotel.isIncluyeDesayuno() ? "Incluido" : "No incluido"));
        tvHuespedes.setText("Número de Huéspedes: " + hotel.getNumeroHuespedes());
    }

    private void configurarDetallesCabana(ReservaCabaña cabana) {
        // Mostrar layout de cabaña y ocultar los demás
        layoutCaracteristicasHotel.setVisibility(View.GONE);
        layoutCaracteristicasCabana.setVisibility(View.VISIBLE);
        layoutCaracteristicasGlamping.setVisibility(View.GONE);

        // Configurar detalles específicos de cabaña
        TextView tvMetrosCuadrados = findViewById(R.id.tvMetrosCuadrados);
        TextView tvChimenea = findViewById(R.id.tvChimenea);
        TextView tvCapacidad = findViewById(R.id.tvCapacidad);

        tvMetrosCuadrados.setText(String.format("Metros Cuadrados: %.2f m²", cabana.getMetrosCuadrados()));
        tvChimenea.setText("Chimenea: " + (cabana.isTieneChimenea() ? "Sí" : "No"));
        tvCapacidad.setText("Capacidad Máxima: " + cabana.getCapacidadMaxima() + " personas");
    }

    private void configurarDetallesGlamping(ReservaGlamping glamping) {
        // Mostrar layout de glamping y ocultar los demás
        layoutCaracteristicasHotel.setVisibility(View.GONE);
        layoutCaracteristicasCabana.setVisibility(View.GONE);
        layoutCaracteristicasGlamping.setVisibility(View.VISIBLE);

        // Configurar detalles específicos de glamping
        TextView tvMetrosCuadradosGlamping = findViewById(R.id.tvMetrosCuadradosGlamping);
        TextView tvChimeneaGlamping = findViewById(R.id.tvChimeneaGlamping);
        TextView tvCapacidadGlamping = findViewById(R.id.tvCapacidadGlamping);
        TextView tvTipoExperiencia = findViewById(R.id.tvTipoExperiencia);
        TextView tvActividades = findViewById(R.id.tvActividades);

        tvMetrosCuadradosGlamping.setText(String.format("Metros Cuadrados: %.2f m²", glamping.getMetrosCuadrados()));
        tvChimeneaGlamping.setText("Chimenea: " + (glamping.isTieneChimenea() ? "Sí" : "No"));
        tvCapacidadGlamping.setText("Capacidad Máxima: " + glamping.getCapacidadMaxima() + " personas");
        tvTipoExperiencia.setText("Tipo de Experiencia: " + glamping.getTipoExperiencia());

        // Configurar actividades
        StringBuilder sbActividades = new StringBuilder();
        for (String actividad : glamping.getActividadesIncluidas()) {
            sbActividades.append("- ").append(actividad).append("\n");
        }
        tvActividades.setText(sbActividades.toString().trim());
    }
}