package com.example.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.diseno_ux.R

class AumentoCreditoActivity : ComponentActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var ingresoEditText: EditText
    private lateinit var cargarComprobanteButton: Button
    private lateinit var cargarIneButton: Button
    private lateinit var enviarSolicitudButton: Button
    private lateinit var volverButton: Button

    private var comprobanteCargado = false
    private var ineCargado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aumetocredito)

        nombreEditText = findViewById(R.id.nombre)
        ingresoEditText = findViewById(R.id.ingreso)
        cargarComprobanteButton = findViewById(R.id.cargarComprobanteButton)
        cargarIneButton = findViewById(R.id.cargarIneButton)
        enviarSolicitudButton = findViewById(R.id.enviarSolicitudButton)
        volverButton = findViewById(R.id.volverButton)

        // Cargar Comprobante de Domicilio (PDF)
        cargarComprobanteButton.setOnClickListener {
            cargarArchivo("pdf")
        }

        // Cargar INE (Imagen)
        cargarIneButton.setOnClickListener {
            cargarArchivo("image")
        }

        // Enviar Solicitud
        enviarSolicitudButton.setOnClickListener {
            enviarSolicitud()
        }

        // Volver a la pantalla anterior
        volverButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun cargarArchivo(tipo: String) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = if (tipo == "pdf") "application/pdf" else "image/*"
        startActivityForResult(intent, if (tipo == "pdf") 1 else 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null) {
            val archivo = data.data
            if (requestCode == 1) {
                comprobanteCargado = true
                Toast.makeText(this, "Comprobante de Domicilio cargado", Toast.LENGTH_SHORT).show()
            } else if (requestCode == 2) {
                ineCargado = true
                Toast.makeText(this, "Imagen del INE cargada", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "No se seleccionó ningún archivo.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun enviarSolicitud() {
        val nombre = nombreEditText.text.toString()
        val ingreso = ingresoEditText.text.toString()

        if (nombre.isEmpty()) {
            Toast.makeText(this, "El campo 'Nombre del Cliente' es obligatorio.", Toast.LENGTH_SHORT).show()
            return
        }

        if (ingreso.isEmpty()) {
            Toast.makeText(this, "El campo 'Ingreso Mensual' es obligatorio.", Toast.LENGTH_SHORT).show()
            return
        }

        if (!comprobanteCargado) {
            Toast.makeText(this, "Debes cargar el comprobante de domicilio.", Toast.LENGTH_SHORT).show()
            return
        }

        if (!ineCargado) {
            Toast.makeText(this, "Debes cargar la imagen de tu INE.", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Solicitud enviada para análisis.", Toast.LENGTH_SHORT).show()
    }
}
