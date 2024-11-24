package com.example.productosdisponibles

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.diseno_ux.R

class ProductosDisponiblesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.productos_disponibles)

        // Configurar botón de volver
        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            // Vuelve a la actividad anterior
            finish() // Finaliza esta actividad para regresar a la anterior
        }
    }
}
