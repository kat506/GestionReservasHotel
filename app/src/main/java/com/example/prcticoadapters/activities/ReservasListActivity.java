package com.example.prcticoadapters.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prcticoadapters.R;
import com.example.prcticoadapters.Adapters.ReservasAdapter;
import com.example.prcticoadapters.models.Reserva;
import com.example.prcticoadapters.models.ReservaCabaña;
import com.example.prcticoadapters.models.ReservaGlamping;
import com.example.prcticoadapters.models.ReservaHotel;
import com.example.prcticoadapters.utils.ReservasDataProvider;

import java.util.ArrayList;
import java.util.List;

public class ReservasListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReservasAdapter adapter;
    private TextView tvTituloLista;
    private List<Reserva> listaReservas;
    private String tipoFiltro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas_list);

        // Obtener el tipo de filtro del intent
        tipoFiltro = getIntent().getStringExtra("tipoFiltro");
        if (tipoFiltro == null) {
            tipoFiltro = "todas";
        }

        // Configurar vistas
        tvTituloLista = findViewById(R.id.tvTituloLista);
        recyclerView = findViewById(R.id.recyclerViewReservas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Configurar título según el filtro
        configureListTitle();

        // Obtener datos filtrados
        listaReservas = getFilteredReservations();

        // Configurar adaptador
        adapter = new ReservasAdapter(this, listaReservas);
        recyclerView.setAdapter(adapter);
    }

    private void configureListTitle() {
        switch (tipoFiltro) {
            case "hotel":
                tvTituloLista.setText("Reservas de Hotel");
                break;
            case "cabaña":
                tvTituloLista.setText("Reservas de Cabañas");
                break;
            case "glamping":
                tvTituloLista.setText("Reservas de Glamping");
                break;
            default:
                tvTituloLista.setText("Todas las Reservas");
                break;
        }
    }

    private List<Reserva> getFilteredReservations() {
        List<Reserva> todasReservas = ReservasDataProvider.getListaReservas();
        List<Reserva> listaFiltrada = new ArrayList<>();

        if (tipoFiltro.equals("todas")) {
            return todasReservas;
        }

        for (Reserva reserva : todasReservas) {
            if (tipoFiltro.equals("hotel") && reserva instanceof ReservaHotel) {
                listaFiltrada.add(reserva);
            } else if (tipoFiltro.equals("cabaña") && reserva instanceof ReservaCabaña
                    && !(reserva instanceof ReservaGlamping)) {
                listaFiltrada.add(reserva);
            } else if (tipoFiltro.equals("glamping") && reserva instanceof ReservaGlamping) {
                listaFiltrada.add(reserva);
            }
        }

        return listaFiltrada;
    }
}
