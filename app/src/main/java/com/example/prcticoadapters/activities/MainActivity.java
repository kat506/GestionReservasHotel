// MainActivity.java
package com.example.prcticoadapters.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prcticoadapters.R;
import com.example.prcticoadapters.utils.ReservasDataProvider;

public class MainActivity extends AppCompatActivity {

    private Button btnVerReservas, btnVerHoteles, btnVerCabanas, btnVerGlamping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar los datos
        ReservasDataProvider.inicializarDatos();

        // Configurar vistas
        btnVerReservas = findViewById(R.id.btnVerReservas);
        btnVerHoteles = findViewById(R.id.btnVerHoteles);
        btnVerCabanas = findViewById(R.id.btnVerCabanas);
        btnVerGlamping = findViewById(R.id.btnVerGlamping);

        // Configurar listeners de botones
        btnVerReservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReservasListActivity.class);
                intent.putExtra("tipoFiltro", "todas");
                startActivity(intent);
            }
        });

        btnVerHoteles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReservasListActivity.class);
                intent.putExtra("tipoFiltro", "hotel");
                startActivity(intent);
            }
        });

        btnVerCabanas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReservasListActivity.class);
                intent.putExtra("tipoFiltro", "cabaña");
                startActivity(intent);
            intent.putExtra("tipoFiltro", "cabaña");
                startActivity(intent);
            }
        });

        btnVerGlamping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReservasListActivity.class);
                intent.putExtra("tipoFiltro", "glamping");
                startActivity(intent);
            }
        });
    }
}