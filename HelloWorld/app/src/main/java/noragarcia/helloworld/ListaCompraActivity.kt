package noragarcia.helloworld

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import noragarcia.helloworld.databinding.ActivityListaCompraBinding

class ListaCompraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaCompraBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicializar binding
        binding = ActivityListaCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar RecyclerView usando binding
        binding.recyclerListaCompra.layoutManager = LinearLayoutManager(this)

        fun getShopItems(): List<ShopItem> {
            return listOf(
                ShopItem("Pan"),
                ShopItem("Leche"),
                ShopItem("Huevos"),
                ShopItem("Arroz"),
                ShopItem("Pasta"),
                ShopItem("Manzanas")
            )
        }

        binding.recyclerListaCompra.adapter = ListaCompraAdapter(getShopItems())

        // Navegar al pulsar el FAB
        binding.botonAnadir.setOnClickListener {
            val intent = Intent(this, AnadirProductoActivity::class.java)
            startActivity(intent)
        }
    }
}
