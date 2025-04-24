package com.example.prcticoadapters.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prcticoadapters.R;
import com.example.prcticoadapters.activities.DetalleReservaActivity;
import com.example.prcticoadapters.models.Reserva;
import com.example.prcticoadapters.models.ReservaCabaña;
import com.example.prcticoadapters.models.ReservaGlamping;
import com.example.prcticoadapters.models.ReservaHotel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ReservasAdapter extends RecyclerView.Adapter<ReservasAdapter.ViewHolder> {

    private List<Reserva> listaReservas;
    private Context context;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    public ReservasAdapter(Context context, List<Reserva> listaReservas) {
        this.context = context;
        this.listaReservas = listaReservas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reserva, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Reserva reserva = listaReservas.get(position);

        // Configurar el color de fondo según el tipo de reserva
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

        holder.tvTipoReserva.setBackgroundColor(ContextCompat.getColor(context, colorBackground));
        holder.tvTipoReserva.setText(reserva.getTipoReserva());

        holder.tvCodigo.setText("Código: " + reserva.getCodigo());
        holder.tvCliente.setText("Cliente: " + reserva.getCliente());

        String fechas = "Del " + dateFormat.format(reserva.getFechaEntrada()) +
                " al " + dateFormat.format(reserva.getFechaSalida());
        holder.tvFechas.setText(fechas);

        holder.tvPrecio.setText(String.format("Precio: $%.2f", reserva.getPrecioTotal()));

        // Configurar el click listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleReservaActivity.class);
                intent.putExtra("reserva", reserva);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaReservas.size();
    }

    public void actualizarLista(List<Reserva> nuevaLista) {
        this.listaReservas = nuevaLista;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTipoReserva, tvCodigo, tvCliente, tvFechas, tvPrecio;
        public LinearLayout layoutItemBackground;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTipoReserva = itemView.findViewById(R.id.tvTipoReserva);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvCliente = itemView.findViewById(R.id.tvCliente);
            tvFechas = itemView.findViewById(R.id.tvFechas);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            layoutItemBackground = itemView.findViewById(R.id.layoutItemBackground);
        }
    }
}