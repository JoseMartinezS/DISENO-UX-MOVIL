package com.example.pagos

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.diseno_ux.R

class PagoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagos) // Asegúrate de que el XML se llama activity_main.xml

        // Botón de "Volver a Comprar" para Producto 1
        val btnBuy1: Button = findViewById(R.id.btn_buy_1)
        btnBuy1.setOnClickListener {
            Toast.makeText(this, "Has seleccionado Electrodoméstico para comprar nuevamente.", Toast.LENGTH_SHORT).show()
        }

        // Botón de "Volver a Comprar" para Producto 2
        val btnBuy2: Button = findViewById(R.id.btn_buy_2)
        btnBuy2.setOnClickListener {
            Toast.makeText(this, "Has seleccionado Ropa para comprar nuevamente.", Toast.LENGTH_SHORT).show()
        }

        // Botón "Volver" para ir a otra actividad
        val btnBack: Button = findViewById(R.id.backButton)
        btnBack.setOnClickListener {
            // Aquí puedes hacer algo como iniciar otra actividad o simplemente finalizar la actividad
            finish() // Cierra la actividad actual
        }
    }
}
