package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [calculator1.newInstance] factory method to
 * create an instance of this fragment.
 */
class calculator1 : Fragment(),View.OnClickListener {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator1, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.Zero_btn ->{

            }
            R.id.One_btn ->{

            }
            R.id.Two_btn ->{

            }
            R.id.Three_btn ->{

            }
            R.id.Four_btn ->{

            }
            R.id.Five_btn ->{

            }
            R.id.Six_btn ->{

            }
            R.id.Seven_btn ->{

            }
            R.id.Eight_btn ->{

            }
            R.id.Nine_btn ->{

            }
            R.id.AC_btn ->{

            }
            R.id.Dvison_btn ->{

            }
            R.id.Multiplicaton ->{

            }
            R.id.P_M_btn ->{

            }
            R.id.Plus_btn ->{

            }
            R.id.Minus_btn ->{

            }
            R.id.percent ->{

            }
            R.id.Equals ->{

            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment calculator1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            calculator1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}