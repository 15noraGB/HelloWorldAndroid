package noragarcia.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HelloWorldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hello_world)

        // Ajuste de padding por system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Botón DONE
        val botonDone = findViewById<Button>(R.id.botonDone)
        val editTextName = findViewById<EditText>(R.id.editTextName)

        botonDone.setOnClickListener {
            val nombre = editTextName.text.toString() // recogemos el nombre
            val intent = Intent(this, ResultadoHelloWorldActivity::class.java)
            intent.putExtra("nombreUsuario", nombre)  // pasamos el nombre a la siguiente activity
            startActivity(intent)
        }
    }
}
