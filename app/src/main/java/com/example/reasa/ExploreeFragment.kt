package com.example.reasa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.reasa.adapters.*
import com.example.reasa.databinding.FragmentExploreeBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var btnitem: MutableList<ButtonItem>
lateinit var exitem: MutableList<recitems>

lateinit var btnadapter: BtnExpAdapter
lateinit var recitadapter: ItemExpAdapter


class ExploreeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentExploreeBinding

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

        binding = FragmentExploreeBinding.inflate(inflater, container, false)

        exitem = mutableListOf<recitems>()
        exitem.add(recitems(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_4, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_5, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_6, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_7, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_8, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_4, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_5, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_6, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_7, "4.7", "Modernica Apart", "New York", "$39 / night"))
        exitem.add(recitems(R.drawable.img_8, "4.7", "Modernica Apart", "New York", "$39 / night"))

        recitadapter = ItemExpAdapter(exitem, this)

        binding.rvexp.adapter = recitadapter


        btnitem = mutableListOf<ButtonItem>()
        btnitem.add(ButtonItem( "All"))
        btnitem.add(ButtonItem("House"))
        btnitem.add(ButtonItem("Apartment"))
        btnitem.add(ButtonItem("Villa"))
        btnitem.add(ButtonItem("Hotel"))
        btnadapter = BtnExpAdapter(btnitem, this)

        binding.rvbut.adapter = btnadapter

        binding.backExp.setOnClickListener {
            findNavController().navigate(R.id.action_exploreeFragment_to_homeFragment)
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExploreeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}