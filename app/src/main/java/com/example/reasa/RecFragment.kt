package com.example.reasa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.reasa.databinding.FragmentExploreeBinding
import com.example.reasa.databinding.FragmentRecBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class RecFragment : Fragment() {

    private lateinit var binding: FragmentRecBinding

    private var param1: String? = null
    private var param2: String? = null

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
        binding = FragmentRecBinding.inflate(inflater, container, false)

        binding.backRec.setOnClickListener {
            findNavController().navigate(R.id.action_recFragment_to_homeFragment)
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}