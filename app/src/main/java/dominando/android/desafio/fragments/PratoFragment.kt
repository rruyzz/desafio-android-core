package dominando.android.desafio.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dominando.android.desafio.R
import kotlinx.android.synthetic.main.fragment_prato.*
import kotlinx.android.synthetic.main.fragment_prato.view.*


class PratoFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_prato, container, false)
            arguments?.getString("nome")?.let{
                view.prato_nome_banner.text = it
            }
            arguments?.getInt("foto")?.let{
                view.pratoBanner.setImageResource(it)
            }

            view.btnVoltarCardapio.setOnClickListener {
                findNavController().navigate(R.id.action_pratoFragment_to_cardapioFragment)
            }

            return view
        }
    companion object {
        fun newInstance() = PratoFragment()
    }
}