package com.example.continenteapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.continenteapp.ProjetoTerraModellBins.Continente
import com.example.continenteapp.databinding.ContinenteItemBinding

class ContinenteAdapter(context : Context, continentes : ArrayList<Continente>) : ArrayAdapter<Continente>(context, 0, continentes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val continente: Continente? = getItem(position)
        val inflater = LayoutInflater.from(context)

        var localView: ContinenteItemBinding = ContinenteItemBinding.inflate(inflater,parent, false )

        val tvName = localView.nome
        val tvArea = localView.area

        tvName.text = continente!!.nome
        tvArea.text = continente!!.area.toString()

        return localView!!.root
    }

}