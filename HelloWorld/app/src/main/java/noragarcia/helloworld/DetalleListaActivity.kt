package noragarcia.helloworld

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_lista)

        val txtDetalle = findViewById<TextView>(R.id.txtDetalle)

        val item = intent.getParcelableExtra<ShopItem>("shop_item")

        item?.let {
            txtDetalle.text = "Producto: ${it.name}\nCantidad: ${it.quantity}"
        }
    }
}
