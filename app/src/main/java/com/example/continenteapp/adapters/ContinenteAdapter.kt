package com.example.continenteapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation.findNavController
import com.example.continenteapp.ProjetoTerraControllers.ControllerContinente
import com.example.continenteapp.ProjetoTerraModellBins.Continente
import com.example.continenteapp.R
import com.example.continenteapp.databinding.ContinenteItemBinding

class ContinenteAdapter(context : Context, continentes : ArrayList<Continente>) : ArrayAdapter<Continente>(context, 0, continentes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val continente: Continente? = getItem(position)
        val inflater = LayoutInflater.from(context)

        var localView: ContinenteItemBinding = ContinenteItemBinding.inflate(inflater,parent, false )

        localView.id.text = continente!!.id.toString()
        localView.nome.text = continente!!.nome
        localView.area.text = continente!!.area.toString()

        localView.buttonDelete.setOnClickListener {
            try {
                val controller = ControllerContinente(this.context)
                controller.excluir(continente)
                findNavController(localView!!.root).navigate(R.id.action_ContinentList_to_FirstFragment)
            }catch (e: Exception) {
                throw e;
            }
        }

        return localView!!.root
    }

}