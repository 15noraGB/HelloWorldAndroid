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
import noragarcia.helloworld.databinding.ActivityHelloWorldBinding
import noragarcia.helloworld.databinding.ActivityNavegacionBinding

class HelloWorldActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHelloWorldBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHelloWorldBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ajuste de padding por system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.botonDone.setOnClickListener{
            val username = binding.editTextName.text.toString().trim()
            if (username.isEmpty()) {
                // Mostrar mensaje si el campo está vacío
                Toast.makeText(this, "Por favor, rellena el campo", Toast.LENGTH_SHORT).show()
            } else {
                // Si hay nombre, navegamos a la siguiente actividad
                val intent = Intent(this, ResultadoHelloWorldActivity::class.java)
                intent.putExtra("nombre", username)
                startActivity(intent)
            }
        }

    }
}
