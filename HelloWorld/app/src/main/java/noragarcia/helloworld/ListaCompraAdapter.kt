package noragarcia.helloworld

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaCompraAdapter(
    private val items: List<ShopItem>
) : RecyclerView.Adapter<ListaCompraAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val texto: TextView = view.findViewById(R.id.txtItemCompra)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.texto.text = item.name

        holder.itemView.setOnClickListener {
            // Incrementar cantidad
            item.quantity += 1

            // Abrir DetalleListaActivity pasando el objeto completo
            val context = holder.itemView.context
            val intent = Intent(context, DetalleListaActivity::class.java)
            intent.putExtra("shop_item", item) // Pasamos el objeto Parcelable
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}

