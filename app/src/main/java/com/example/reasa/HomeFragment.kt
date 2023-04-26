package com.example.reasa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.reasa.adapters.ButtonAdapter
import com.example.reasa.adapters.ItemAdapter
import com.example.reasa.adapters.RecItemAdapter
import com.example.reasa.databinding.FragmentHomeBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var item : MutableList<ItemList>
lateinit var buttonItem: MutableList<ButtonItem>
lateinit var ritems: MutableList<recitems>

lateinit var adapter: ItemAdapter
lateinit var buttonAdapter: ButtonAdapter
lateinit var recItemAdapter: RecItemAdapter


class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentHomeBinding

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

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        item = mutableListOf<ItemList>()
        item.add(ItemList(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        item.add(ItemList(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        item.add(ItemList(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        item.add(ItemList(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        item.add(ItemList(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        item.add(ItemList(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        adapter = ItemAdapter(item, this)

        binding.rv1.adapter = adapter



        ritems = mutableListOf<recitems>()
        ritems.add(recitems(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        ritems.add(recitems(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        ritems.add(recitems(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        ritems.add(recitems(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        ritems.add(recitems(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        ritems.add(recitems(R.drawable.img_3, "4.7", "Modernica Apart", "New York", "$39 / night"))
        recItemAdapter = RecItemAdapter(ritems, this)

        binding.rv3.adapter = recItemAdapter



        buttonItem = mutableListOf<ButtonItem>()
        buttonItem.add(ButtonItem( "All"))
        buttonItem.add(ButtonItem("House"))
        buttonItem.add(ButtonItem("Apartment"))
        buttonItem.add(ButtonItem("Villa"))
        buttonItem.add(ButtonItem("Hotel"))

        buttonAdapter = ButtonAdapter(buttonItem, this)

        binding.rv2.adapter = buttonAdapter




        binding.notif.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_notificationFragment)
        }


        binding.menubar.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.message -> {
                    findNavController().navigate(R.id.action_homeFragment_to_messageeFragment)
                }
                R.id.profile -> {
                    findNavController().navigate(R.id.action_homeFragment_to_profileeFragment)
                }
                R.id.explore -> {
                    findNavController().navigate(R.id.action_homeFragment_to_exploreeFragment)
                }
            }
            true
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}