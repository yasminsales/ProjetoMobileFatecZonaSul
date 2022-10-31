package com.example.continenteapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.continenteapp.ProjetoTerraControllers.ControllerContinente
import com.example.continenteapp.ProjetoTerraModellBins.Continente
import com.example.continenteapp.adapters.ContinenteAdapter
import com.example.continenteapp.databinding.FragmentContinenteListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContinenteListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContinenteListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentContinenteListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentContinenteListBinding.inflate(inflater, container, false)

        try {
            val controller = ControllerContinente(this.context)
            val items = controller.listar("")
            val itemsArrayList = ArrayList<Continente>(items)
            val adapter = ContinenteAdapter(this.context!!, itemsArrayList)

            _binding!!.continenteList.adapter = adapter
            return _binding!!.root

        } catch (e: Exception) {
            throw e;
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContinenteList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContinenteListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}