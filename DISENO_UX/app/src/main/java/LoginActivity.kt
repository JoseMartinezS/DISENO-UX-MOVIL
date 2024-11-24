package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.CreditActivity
import com.example.diseno_ux.R
import com.example.registro.RegisterActivity
import androidx.activity.ComponentActivity


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val etUsuario: EditText = findViewById(R.id.etUsuario)
        val etContrasena: EditText = findViewById(R.id.etContrasena)
        val btnIngresar: Button = findViewById(R.id.btnIngresar)
        val registerLink: TextView = findViewById(R.id.registerLink)

        btnIngresar.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val contrasena = etContrasena.text.toString()

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Simulación de autenticación
                if (usuario == "admin" && contrasena == "1234") {
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, CreditActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }
        }

        registerLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
