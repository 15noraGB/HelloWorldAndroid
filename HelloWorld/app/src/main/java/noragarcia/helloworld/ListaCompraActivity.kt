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


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val recycler = findViewById<RecyclerView>(R.id.recyclerListaCompra)
        recycler.layoutManager = LinearLayoutManager(this)


        val listaEstatica = listOf(
            "Pan",
            "Leche",
            "Huevos",
            "Arroz",
            "Pasta",
            "Manzanas"
        )


        recycler.layoutManager = LinearLayoutManager(this)


        recycler.adapter = ListaCompraAdapter(listaEstatica)
    }
}
