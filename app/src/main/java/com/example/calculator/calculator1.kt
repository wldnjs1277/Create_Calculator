package com.example.calculator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calculator1.*
import java.util.*



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [calculator1.newInstance] factory method to
 * create an instance of this fragment.
 */
class calculator1 : Fragment(),View.OnClickListener {
    //
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
        //LayoutInflater는xml에 정의된 리소스를 view객체로 반환해주는 역할
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate(객체화시킬 xml파일, 객체화한 뷰를 넣을 레이아웃/컨테이너

        return inflater.inflate(R.layout.fragment_calculator1, container, false)
    }
    //onViewCreated는 onCreateView가 반환하는 view를 매개변수로 가진다
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
    val stack=Stack<Any>()
    override fun onClick(p0: View?) {
        val Text: String = textView.text.toString()
        val Text_D =Text.toDouble()
        /*만들고자 하는 계산기의 기능 숫자를 입력받고 연산자 버튼을 누르면 버튼을 누르기 전에 입력되어있던 숫자는 저장되고
        * 연산자 후에 숫자를 더입력받고 = 버튼을 누르면 연산결과 출력
        * =을 안누르고 추가로 연산자 버튼을 눌러 값을 입력 받아도 연산결과 출력
        * 연산자들에 우선순위가 정해져서 결과가 출력됨
        * 1+3/3을 하면 나누기 먼저 계산되고 더하기를 수행 */
        when(p0?.id)
        {
            R.id.Zero_btn ->{
                if (Text=="0"){
                    textView.text = "0"
                   AC_btn.text=getString(R.string.AC)

                } else{
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
                if(Text==""){
                    textView.text="9"
                }
            }
            R.id.AC_btn ->{

                if (AC_btn.text.equals("C")) {
                    AC_btn.text = getText(R.string.AC)
                    textView.text = "0"

                    //ac버튼을 누르면 카운트도 초기화 시키기
                    if (AC_btn.text.equals("AC")) {
                    }
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
                    //Bundle의 ARG_PARAM1키에 대한 값을 param1로 변경하여 삽입
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}