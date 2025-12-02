package noragarcia.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import noragarcia.helloworld.databinding.ActivityResultadoHelloWorldBinding

class ResultadoHelloWorldActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoHelloWorldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoHelloWorldBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperamos el nombre enviado desde HelloWorldActivity
        val nombre = intent.getStringExtra("nombre")

        // Mostramos el mensaje en el TextView usando binding
        binding.textViewTitle.text = if (!nombre.isNullOrEmpty()) {
            "Holis! Bienvenido a mi app, $nombre"
        } else {
            "Holis! Bienvenido a mi app"
        }
    }
}
