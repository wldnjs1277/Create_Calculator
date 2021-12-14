package com.example.calculator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calculator1.*
import java.text.DecimalFormat



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
//숫자버튼
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
//연산 버튼
        Plus_btn.setOnClickListener(this)
        Minus_btn.setOnClickListener(this)
        P_M_btn.setOnClickListener(this)
        Multiplicaton.setOnClickListener(this)
        Divison_btn.setOnClickListener(this)
        AC_btn.setOnClickListener(this)
        percent.setOnClickListener(this)
        Decimal_point.setOnClickListener(this)
        Equals.setOnClickListener(this)
        //

    }
    var count=0
    override fun onClick(p0: View?) {
        val Text: String = textView.text.toString()
        val Text_D =Text.toDouble()
        val dec = DecimalFormat("#,###")//숫자 단위표기를위한
        when(p0?.id)
        {
            R.id.Zero_btn ->{
                if (Text=="0"){
                    textView.text = "0"
                   AC_btn.text=getString(R.string.AC)

                }else{
                   textView.append("0")
                    AC_btn.text="C"

                }
            }
            R.id.One_btn ->{
                if (Text=="0"){
                    textView.text = "1"
                    AC_btn.text="C"
                } else{
                    textView.append("1")
                }
            }
            R.id.Two_btn ->{
                if (Text=="0"){
                    textView.text = "2"
                    AC_btn.text="C"
                } else{
                    textView.append("2")
                }
            }
            R.id.Three_btn ->{
                if (Text=="0"){
                    textView.text = "3"
                    AC_btn.text="C"
                } else{
                    textView.append("3")
                }
            }
            R.id.Four_btn ->{
                if (Text=="0"){
                    textView.text = "4"
                    AC_btn.text="C"
                } else{
                    textView.append("4")
                }
            }
            R.id.Five_btn ->{
                if (Text=="0"){
                    textView.text = "5"
                    AC_btn.text="C"
                } else{
                    textView.append("5")
                }
            }
            R.id.Six_btn ->{
                if (Text=="0"){
                    textView.text = "6"
                    AC_btn.text="C"
                } else{
                    textView.append("6")
                }
            }
            R.id.Seven_btn ->{
                if (Text=="0"){
                    textView.text = "7"
                    AC_btn.text="C"
                } else{
                    textView.append("7")
                }
            }
            R.id.Eight_btn ->{
                if (Text=="0"){
                    textView.text = "8"
                    AC_btn.text="C"
                } else{
                    textView.append("8")
                }
            }
            R.id.Nine_btn ->{
                if (Text=="0"){
                    textView.text = "9"
                    AC_btn.text="C"
                } else{
                    textView.append("9")
                }
            }
            R.id.AC_btn ->{

                if (AC_btn.text.equals("C")) {
                    AC_btn.text = getText(R.string.AC)
                    textView.text = "0"

                    //ac버튼을 누르면 카운트도 초기화 시키기
                    count=0
                }

            }
            R.id.Divison_btn ->{

            }
            R.id.Multiplicaton ->{

            }
            R.id.P_M_btn ->{
                if(textView.text.contains(getString(R.string.Minus))){
                   if (textView.text.contains(".")){
                       textView.text = (Text_D *-1).toString()
                   }else{
                       textView.text= (Text.toInt()*-1).toString()
                   }
                }else{
                    if(Text=="0"){
                        textView.text="0"
                    }
                    else{
                    textView.text ="-"+Text
                    }
                }

            }
            R.id.Plus_btn -> {
                //+버튼을 처음 누를때와 그다음 누를때 다른데 그걸 count로 세고 onclick안에 count를 정의하여 count++을 사용할때는
                //사용이 되지않아 onclick밖에 정의
                //계속 수정하기
                val firstinput = textView.text.toString().toInt()
               if(count==0){
                   textView.text="1"
                   count++
               }else if(count>0){
                   textView.append(firstinput.toString())
               }
            }

            R.id.Minus_btn ->{

            }
            R.id.percent ->{
                if (Text=="0"){
                    textView.text = "0"
                } else{
                   val pe=(Text_D/100).toString()
                    textView.text=pe
                }
            }
            R.id.Decimal_point ->{
               if(Text.contains(".")){
                return
               }else{
                   textView.append(".")
                   AC_btn.text="C"
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