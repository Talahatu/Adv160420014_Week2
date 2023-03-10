package com.ubaya.adv160420014week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }
    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
        // Inflate the layout for this fragment
        super.onViewCreated(view, savedInstanceState)
        btnStart.setOnClickListener{
            val name = txtAnswer.text.toString()
            val action = MainFragmentDirections.actionGameFragment(name)
            Navigation.findNavController(it).navigate(action)
        }
    }
}