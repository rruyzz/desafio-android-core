package dominando.android.desafio.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.desafio.ui.Pratos
import dominando.android.desafio.R
import dominando.android.desafio.adapters.CardapioAdapter
import kotlinx.android.synthetic.main.fragment_prato.view.*
import kotlinx.android.synthetic.main.layout_cardapio.*
import kotlinx.android.synthetic.main.layout_cardapio.view.*
import kotlinx.android.synthetic.main.recycle_restaurante.view.*

class CardapioFragment : Fragment(), CardapioAdapter.onPratoClickListener {
    private val cardapio = criarCardapio()
    private val adapter : CardapioAdapter =
        CardapioAdapter(cardapio,
            this
        )

//    private val args by navArgs<CardapioFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.layout_cardapio, container, false)
        arguments?.getString("nome")?.let{
            view.nome_restaurante_banner.text = it
        }
        arguments?.getInt("foto")?.let{
            view.imgBanner.setImageResource(it)
        }

        val recyclerViewCardapio = view.findViewById<RecyclerView>(R.id.recycler_view_pratos)
        recyclerViewCardapio.adapter = adapter
        recyclerViewCardapio.layoutManager = GridLayoutManager(context, 2)
        recyclerViewCardapio.setHasFixedSize(true)

//        view.restaurante_nome.text = args.restaurantes.nome
//        view.image_restaurante.setImageResource(args.restaurantes.image)
        view.btnVoltar.setOnClickListener{
            findNavController().navigate(R.id.action_cardapioFragment_to_restaurantesFragment)

        }

        return view

    }

    fun criarCardapio(): ArrayList<Pratos>{

        val salada = Pratos(
            "Salada com Molho Gengibre",
            R.drawable.aoyama
        )
        val lista = ArrayList<Pratos>()
        for(x in 0..9) lista.add(salada)

        return lista

    }

    override fun pratoClick(position: Int) {
        val prato = cardapio.get(position)
        adapter.notifyItemChanged(position)
        val bundle2 = bundleOf("nome" to prato.nome, "foto" to prato.image)

        findNavController().navigate(R.id.action_cardapioFragment_to_pratoFragment, bundle2)

    }
    companion object{
        fun newInstance() = CardapioFragment()
    }
}
