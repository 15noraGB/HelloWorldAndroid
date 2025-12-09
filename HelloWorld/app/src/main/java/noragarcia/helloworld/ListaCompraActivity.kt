package noragarcia.helloworld

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import noragarcia.helloworld.databinding.ActivityListaCompraBinding

class ListaCompraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaCompraBinding
    private lateinit var adapter: ListaCompraAdapter
    private val shopItems = mutableListOf<ShopItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListaCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar lista con productos existentes
        shopItems.addAll(
            listOf(
                ShopItem("Pan", quantity = 1),
                ShopItem("Leche", quantity = 3),
                ShopItem("Huevos", quantity = 12),
                ShopItem("Arroz", quantity = 2),
                ShopItem("Pasta", quantity = 2),
                ShopItem("Manzanas", quantity = 10)
            )
        )

        // Comprobar si viene un producto nuevo por Intent
        val nombre = intent.getStringExtra("nombre")
        val cantidad = intent.getStringExtra("cantidad")
        if (!nombre.isNullOrEmpty() && !cantidad.isNullOrEmpty()) {
            shopItems.add(ShopItem(nombre, cantidad.toInt()))
        }

        // Configurar RecyclerView
        adapter = ListaCompraAdapter(shopItems)
        binding.recyclerListaCompra.layoutManager = LinearLayoutManager(this)
        binding.recyclerListaCompra.adapter = adapter

        // Navegar al pulsar el FAB
        binding.botonAnadir.setOnClickListener {
            val intent = Intent(this, AnadirProductoActivity::class.java)
            startActivity(intent)
        }
    }
}
