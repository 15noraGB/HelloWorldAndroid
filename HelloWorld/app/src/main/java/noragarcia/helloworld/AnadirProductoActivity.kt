package noragarcia.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AnadirProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_anadir_producto)

        // Ajustar padding para sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombreEditText = findViewById<EditText>(R.id.productTextName)
        val cantidadEditText = findViewById<EditText>(R.id.cantidadTextName)
        val saveButton = findViewById<Button>(R.id.botonSave)

        saveButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val cantidad = cantidadEditText.text.toString()

            if (nombre.isNotEmpty() && cantidad.isNotEmpty()) {
                // Crear Intent para volver a ListaCompraActivity
                val intent = Intent(this, ListaCompraActivity::class.java).apply {
                    putExtra("nombre", nombre)
                    putExtra("cantidad", cantidad)
                }
                startActivity(intent)
                finish() // cerrar esta Activity
            } else {
                Toast.makeText(this, "Rellena ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
