package dominando.android.desafio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dominando.android.desafio.R
import dominando.android.desafio.Restaurantes

class RestaurantesAdapter(
    private val listaRestaurante: ArrayList<Restaurantes>,
    private val listener: OnRestauranteClickListener
) : RecyclerView.Adapter<RestaurantesAdapter.RestaurantesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_restaurante, parent, false)
        return RestaurantesHolder(view)
    }

    override fun getItemCount(): Int = listaRestaurante.size

    override fun onBindViewHolder(holder: RestaurantesHolder, position: Int) {
        var restauranteItem = listaRestaurante[position]

        holder.textNome.text = restauranteItem.nome
        holder.textEndereco.text = restauranteItem.endereco
        holder.textHorario.text = restauranteItem.horario
        holder.imageRestaurante.setImageResource(restauranteItem.image)

//        holder.itemView.setOnClickListener{
//            MainActivity.fm.beginTransaction().replace(R.id.restaurantesFragment, CardapioFragment(), null).addToBackStack(null).commit()
//        }

    }

    interface OnRestauranteClickListener{
        fun restauranteClick(position: Int)
    }

    inner class RestaurantesHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageRestaurante: ImageView = itemView.findViewById(R.id.image_restaurante)
        val textNome: TextView = itemView.findViewById(R.id.nome_restaurante)
        val textEndereco: TextView = itemView.findViewById(R.id.endereco_restaurante)
        val textHorario: TextView = itemView.findViewById(R.id.horario_restaurante)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(RecyclerView.NO_POSITION != position)
                listener.restauranteClick(position)
        }

    }

}