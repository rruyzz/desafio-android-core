package dominando.android.desafio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dominando.android.desafio.ui.Pratos
import dominando.android.desafio.R
import kotlinx.android.synthetic.main.fragment_prato.view.*
import kotlinx.android.synthetic.main.recycle_cardapio.view.*

class CardapioAdapter(
    private val cardapio: ArrayList<Pratos>,
    private val listener: onPratoClickListener
) : RecyclerView.Adapter<CardapioAdapter.PratosHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PratosHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_cardapio, parent, false)

        return PratosHolder(view)

    }

    override fun getItemCount(): Int = cardapio.size

    override fun onBindViewHolder(holder: CardapioAdapter.PratosHolder, position: Int) {
        val prato = cardapio[position]
        holder.textNome.text = prato.nome
        holder.imagePrato.setImageResource(prato.image)

    }
    interface onPratoClickListener{
        fun pratoClick(position: Int)
    }

    inner class PratosHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val textNome: TextView = itemView.prato_nome
        val imagePrato : ImageView = itemView.image_prato

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if(RecyclerView.NO_POSITION != position)
                listener.pratoClick(position)
        }

    }

}