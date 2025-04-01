package com.example.littlenotestar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilitar el modo Edge to Edge
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajustar el padding para los system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar las fuentes personalizadas para los TextView
        TextView tvLittle = findViewById(R.id.tvLittle);
        TextView tvNoteStar = findViewById(R.id.tvNoteStar);

        // Asignar la fuente Chewy a "Little"
        Typeface chewyFont = ResourcesCompat.getFont(this, R.font.chewy);
        tvLittle.setTypeface(chewyFont);

        // Asignar la fuente League Spartan a "NoteStar"
        Typeface leagueFont = ResourcesCompat.getFont(this, R.font.le2); // Asegúrate de que el nombre sea correcto
        tvNoteStar.setTypeface(leagueFont);

        // Redirigir a la siguiente actividad después de 3 segundos
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, SiguienteActivity.class);
            startActivity(intent);
            finish();
        }, 3000); // 3000 milisegundos = 3 segundos
    }
}
