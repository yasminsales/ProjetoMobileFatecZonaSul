package com.example.continenteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.continenteapp.ProjetoTerraControllers.ControllerContinente
import com.example.continenteapp.ProjetoTerraModellBins.Continente
import com.example.continenteapp.databinding.FragmentContinenteBinding
import com.example.continenteapp.databinding.FragmentContinenteEditBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
public const val ARG_ContinenteId = "ContinenteId"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContinenteEditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContinenteEditFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var continenteId: Int = 0


    private var _binding: FragmentContinenteEditBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            continenteId = it.getInt(ARG_ContinenteId)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentContinenteEditBinding.inflate(inflater, container, false)

        return _binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = ControllerContinente(this.context)
        val continenteModel = controller.buscar(Continente(continenteId))

        binding.nomeValue.setText(continenteModel.nome)
        binding.areaValue.setText(continenteModel.area.toString())

        binding.buttonSave.setOnClickListener {

            val name = binding.nomeValue.text.toString()
            val area = binding.areaValue.text.toString()

            controller.alterar(Continente(continenteId, name, area.toInt()))
            findNavController().navigate(R.id.action_ContinentEdit_to_FirstFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContinenteEditFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(continenteId: Int) =
            ContinenteEditFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ContinenteId, continenteId)
                }
            }
    }
}