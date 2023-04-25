package com.example.reasa

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.reasa.databinding.FragmentCreateBinding
import com.example.reasa.databinding.FragmentFirstBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FirstFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentFirstBinding

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

        binding = FragmentFirstBinding.inflate(inflater, container, false)

        val sharedPreference = this.getActivity()?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val name = sharedPreference?.getString("mail","")
        if(name.equals("")) {
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                }, 3000    )
        }
        else{
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    findNavController().navigate(R.id.action_firstFragment_to_congratsFragment)
                }, 3000    )
        }
        val binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root


    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}