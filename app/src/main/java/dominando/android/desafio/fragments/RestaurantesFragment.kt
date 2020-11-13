package dominando.android.desafio.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import dominando.android.desafio.R
import dominando.android.desafio.Restaurantes
import dominando.android.desafio.adapters.RestaurantesAdapter


class RestaurantesFragment : Fragment(), RestaurantesAdapter.OnRestauranteClickListener {
    private val listaRestaurantes = criarListaRestaurantes()
    private val adapter: RestaurantesAdapter =
        RestaurantesAdapter(
            listaRestaurantes,
            this
        )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_restaurantes, container, false)


        val recyclerViewRestaurante =
            view.findViewById<RecyclerView>(R.id.recycler_view_restaurante)
        recyclerViewRestaurante.adapter = adapter
        recyclerViewRestaurante.setHasFixedSize(true)

        return view
    }

    private fun criarListaRestaurantes(): ArrayList<Restaurantes> {
        val tony = Restaurantes(
            R.drawable.tony,
            "Tony Roma's",
            "Fecha às 22:00",
            "Avenida Lavandisca, 717 - Indianópolis, São Paulo"
        )
        val aoyama = Restaurantes(
            R.drawable.aoyama,
            "Aoyama - Moema",
            "Fecha às 00:00",
            "Alameda dos Arapanés, 532 - Moema"
        )
        val outback = Restaurantes(
            R.drawable.outback,
            "Outback - Moema",
            "Fecha às 00:00",
            "Av. Moaci, 187 - Moema, São Pualo"
        )
        val sisenor = Restaurantes(
            R.drawable.sisenor,
            "Sí Señor!",
            "Fecha às 01:00",
            "Alameda Jauaperi, 626 - Moema"
        )

        return arrayListOf(tony, aoyama, outback, sisenor)
    }

    override fun restauranteClick(position: Int) {

        val restaurante = listaRestaurantes.get(position)
        adapter.notifyItemChanged(position)
        val bundle = bundleOf("nome" to restaurante.nome, "foto" to restaurante.image)
//        val action =
//            RestaurantesFragmentDirections.actionRestaurantesFragmentToCardapioFragment(
//                restaurante
//            )


        findNavController().navigate(R.id.action_restaurantesFragment_to_cardapioFragment, bundle)
    }
    companion object{
        fun newInstance() = RestaurantesFragment()
    }
}