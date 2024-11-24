package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.diseno_ux.R
import com.example.loginapp.LoginActivity
import com.example.pagos.PagoActivity
import com.example.productosdisponibles.ProductosDisponiblesActivity

class CreditActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.informacion)
    }

    // Función para volver al login
    fun volver(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    // Función para abrir la página de productos disponibles
    fun abrirProductosDisponibles(view: View) {
        val intent = Intent(this, ProductosDisponiblesActivity::class.java)
        startActivity(intent)
    }

    // Función para abrir la sección de pagos
    fun abrirPagos(view: View) {
        val intent = Intent(this, PagoActivity::class.java)
        startActivity(intent)
    }

    // Función para solicitar aumento de crédito
    fun aumentoCredito(view: View) {
        val intent = Intent(this, AumentoCreditoActivity::class.java)
        startActivity(intent)
    }
}
