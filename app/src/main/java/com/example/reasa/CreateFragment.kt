package com.example.reasa

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.reasa.databinding.FragmentCreateBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CreateFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentCreateBinding

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

        binding = FragmentCreateBinding.inflate(inflater, container, false)

        binding.signup.setOnClickListener{
            findNavController().navigate(R.id.action_createFragment_to_congratsFragment)
        }

        binding.signin.setOnClickListener {
            findNavController().navigate(R.id.action_createFragment_to_haveAccFragment)
        }

        binding.signup.setOnClickListener {
            val sharedPreference = this.getActivity()?.getSharedPreferences("pref", Context.MODE_PRIVATE)
            val name = sharedPreference?.getString("mail", "")
            if (name != null) {
                if(!name.equals(binding.email)){
                    Toast.makeText(requireContext(),"Wrong mail", Toast.LENGTH_SHORT).show()
                }else{
                    findNavController().navigate(R.id.action_createFragment_to_congratsFragment)
                }
            }
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}