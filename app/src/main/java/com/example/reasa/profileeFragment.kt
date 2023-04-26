package com.example.reasa

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.reasa.databinding.FragmentHomeBinding
import com.example.reasa.databinding.FragmentProfileeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


@Suppress("UNREACHABLE_CODE")
class profileeFragment : Fragment() {

    private lateinit var binding: FragmentProfileeBinding

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

        val sharedPreferences = this.getActivity()?.getSharedPreferences("pref", Context.MODE_PRIVATE)

        binding = FragmentProfileeBinding.inflate(inflater, container, false)


        binding.delete.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext()).setTitle("Alert").setMessage("Do you want to delete your account?").setPositiveButton("Yes"
            ){p0, p1 ->
                val editor = sharedPreferences?.edit()
                editor?.putString("mail", "")
                editor?.apply()
                findNavController().navigate(R.id.action_homeFragment_to_firstFragment)
            }
                .setNegativeButton("No", object : DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(requireContext(), "You don't log out", Toast.LENGTH_SHORT).show()
                    }
                })
                .show()
        }

        binding.log.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext()).setTitle("Alert").setMessage("Do you want to log out?").setPositiveButton("Yes"
            ){p0, p1 ->
                findNavController().navigate(R.id.action_homeFragment_to_firstFragment)
            }
                .setNegativeButton("No", object : DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(requireContext(), "Your account will not be deleted", Toast.LENGTH_SHORT).show()
                    }
                })
                .show()
        }

        return binding.root

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            profileeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}