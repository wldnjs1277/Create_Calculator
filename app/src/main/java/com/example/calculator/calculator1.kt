package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calculator1.*

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

        Zero_btn.setOnClickListener(this)
        One_btn.setOnClickListener(this)
        Two_btn.setOnClickListener(this)
        Three_btn.setOnClickListener(this)
        Four_btn.setOnClickListener(this)
        Five_btn.setOnClickListener(this)
        Six_btn.setOnClickListener(this)
        Seven_btn.setOnClickListener(this)
        Eight_btn.setOnClickListener(this)
        Nine_btn.setOnClickListener(this)

        Plus_btn.setOnClickListener(this)
        Minus_btn.setOnClickListener(this)
        P_M_btn.setOnClickListener(this)
        Multiplicaton.setOnClickListener(this)
        Dvison_btn.setOnClickListener(this)
        AC_btn.setOnClickListener(this)
        percent.setOnClickListener(this)
        Equals.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        var Text = textView.text.toString()
        when(p0?.id)
        {
            R.id.Zero_btn ->{
                if (Text=="0"){
                    textView.text = "0"
                }else{
                    textView.append("0")
                }
            }
            R.id.One_btn ->{
                if (Text=="0"){
                    textView.text = "1"
                } else{
                    textView.append("1")
                }
            }
            R.id.Two_btn ->{
                if (Text=="0"){
                    textView.text = "2"
                } else{
                    textView.append("2")
                }
            }
            R.id.Three_btn ->{
                if (Text=="0"){
                    textView.text = "3"
                } else{
                    textView.append("3")
                }
            }
            R.id.Four_btn ->{
                if (Text=="0"){
                    textView.text = "4"
                } else{
                    textView.append("4")
                }
            }
            R.id.Five_btn ->{
                if (Text=="0"){
                    textView.text = "5"
                } else{
                    textView.append("5")
                }
            }
            R.id.Six_btn ->{
                if (Text=="0"){
                    textView.text = "6"
                } else{
                    textView.append("6")
                }
            }
            R.id.Seven_btn ->{
                if (Text=="0"){
                    textView.text = "7"
                } else{
                    textView.append("7")
                }
            }
            R.id.Eight_btn ->{
                if (Text=="0"){
                    textView.text = "8"
                } else{
                    textView.append("8")
                }
            }
            R.id.Nine_btn ->{
                if (Text=="0"){
                    textView.text = "9"
                } else{
                    textView.append("9")
                }
            }
            R.id.AC_btn ->{

                textView.text ="0"
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
                if (Text=="0"){
                    textView.text = "0"
                } else{
                   var Pe=(Text.toDouble()/100).toString()
                    textView.text=Pe
                }
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