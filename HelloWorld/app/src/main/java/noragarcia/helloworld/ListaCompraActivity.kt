package noragarcia.helloworld

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListaCompraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_compra)

        val recycler = findViewById<RecyclerView>(R.id.recyclerListaCompra)
        recycler.layoutManager = LinearLayoutManager(this)

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

        recycler.adapter = ListaCompraAdapter(getShopItems())
    }
}
