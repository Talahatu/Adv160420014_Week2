package com.ubaya.adv160420014week2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var answer: Int = 0
    private var score:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game,container,false)
    }

    private fun randomize(){
        num1.text = (1..100).shuffled().first().toString()
        num2.text = (1..100).shuffled().first().toString()
        answer = num1.text.toString().toInt() + num2.text.toString().toInt()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        randomize()
        arguments?.let {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            textTurns.text = "$playerName's Turn"
        }
        btnSubmit.setOnClickListener {
            val input = txtAnswer.text.toString()
            Log.d("Test Input: ",input)
            Log.d("Test Answer: ",answer.toString())
            if(input!=answer.toString()){
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
            score++
            randomize()
            txtAnswer.setText("")
        }
    }
}