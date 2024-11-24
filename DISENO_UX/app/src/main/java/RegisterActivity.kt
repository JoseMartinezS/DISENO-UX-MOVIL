package com.example.registro

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.diseno_ux.R

class RegisterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        val etNombre = findViewById<EditText>(R.id.et_nombre)
        val etApellido = findViewById<EditText>(R.id.et_apellido)
        val etCorreo = findViewById<EditText>(R.id.et_correo)
        val etTelefono = findViewById<EditText>(R.id.et_telefono)
        val etContraseña = findViewById<EditText>(R.id.et_contraseña)
        val etConfirmarContraseña = findViewById<EditText>(R.id.et_confirmar_contraseña)
        val btnVolver = findViewById<Button>(R.id.btn_volver)
        val btnRegistrarse = findViewById<Button>(R.id.btn_registrarse)

        btnVolver.setOnClickListener {
            Toast.makeText(this, "Volviendo al inicio...", Toast.LENGTH_SHORT).show()
            finish() // Vuelve a la actividad anterior
        }

        btnRegistrarse.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val correo = etCorreo.text.toString()
            val telefono = etTelefono.text.toString()
            val contraseña = etContraseña.text.toString()
            val confirmarContraseña = etConfirmarContraseña.text.toString()

            if (nombre.isBlank() || apellido.isBlank() || correo.isBlank() || telefono.isBlank() || contraseña.isBlank() || confirmarContraseña.isBlank()) {
                Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (contraseña != confirmarContraseña) {
                Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                Toast.makeText(this, "Correo electrónico no válido.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Registro exitoso. ¡Bienvenido, $nombre!", Toast.LENGTH_LONG).show()

            // Aquí puedes agregar la lógica para guardar el usuario o navegar a otra pantalla
        }
    }
}
