package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityCalculatorBinding

//AppCompatActivity()를 상속받는 CalculatorActivity class를 정의
class CalculatorActivity : AppCompatActivity() {
    //lateinit을 이용하여 binding: ActivityCalculatorBinding 선언하고 초기화는 나중에 한다.
    private lateinit var binding: ActivityCalculatorBinding
    //expStr=getEmprtyStr()의 결과를 할당한다.
    private var expStr = getEmptyStr()
// oncreate 액티비티가 생성될때
    override fun onCreate(savedInstanceState: Bundle?) {
        // super를 사용하여 onCreate 상위 클래스에서 구현한 onCreate를 호출하여 사용
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        //화면구성 binding.root를 표시
        setContentView(binding.root)
        //numberClickListener를 호출
        numberClickListener()
        //operatorClickListener를 호출
        operatorClickListener()
        //otherClickListener를 호출
        otherClickListener()
    }

    /* 숫자버튼 클릭 리스너 */
    private fun numberClickListener() {
        //리스트를 생성하고 값을 ()안에 있는 값으로 초기화
        listOf(
            binding.ZeroBtn,
            binding.OneBtn, binding.TwoBtn, binding.ThreeBtn,
            binding.FourBtn, binding.FiveBtn, binding.SixBtn,
            binding.SevenBtn, binding.EightBtn, binding.NineBtn
        //listof.forEach listof()에 있는 값을 button으로 받아 반복문 수행
        ).forEach { button ->
            //setOnClickListener 클릭시 수행할동작을 지정한다.
            //버튼이 클릭되었을때 수행할 동작
            button.setOnClickListener {
                //binding.textView.text는 addNumber()의 결과를 할당한다.
                binding.textView.text = addNumber(
                    //oldNumberStr은 binding.textView.text.toString() 한 값
                    oldNumberStr = binding.textView.text.toString(),
                    //newNumberStr은 button.text.toString()한 값
                    newNumberStr = button.text.toString()
                )
            }
        }
    }

    /* 수식버튼 클릭 리스너 */
    private fun operatorClickListener() {
        //list를 생성하고 ()의 값으로 초기화
        listOf(
            binding.PlusBtn, binding.MinusBtn, binding.Multiplicaton, binding.DivisonBtn, binding.percent
        //listof()를 button으로 받아 반복문 수행
        ).forEach { button ->
            button.setOnClickListener {
                //expstr=addop()의 결과를 할당
                expStr = addOp(
                    oldExpStr = expStr,
                    //newNumberStr = binding.textView.text를 string으로 형변환 한 값
                    newNumberStr = binding.textView.text.toString(),
                    //newOpStr = button.text를 string으로 형변환 한 값
                    newOpStr = button.text.toString()
                )
                //binding.textView.text는 getZeroStr()결과를 할당
                binding.textView.text = getZeroStr()
            }
        }
    }

    /* 숫자와 수식이 아닌 버튼 클릭리스너 */
    private fun otherClickListener() {
        //binding.PMBtn이 클릭되었을때 수행할 종작
        binding.PMBtn.setOnClickListener {
            //binding.textView.text는 changeDataMask()결과를 할당
            binding.textView.text = changeDataMask(
                // newNumberStr = binding.textView.text를 string으로 형변환 한 값
                newNumberStr = binding.textView.text.toString()
            )
        }
        //binding.DecimalPoint이 클릭되었을때 수행할 동작
        binding.DecimalPoint.setOnClickListener {
            //binding.textView.text는 changeDataPoint()결과를 할당
            binding.textView.text = changeDataPoint(
                //newNumberStr = binding.textView.text를 string으로 형변환 한 값
                newNumberStr = binding.textView.text.toString()
            )
        }
        //binding.ACBtn이 클릭되었을때 수행할 동작
        binding.ACBtn.setOnClickListener {
            //expStr은 getEmptyStr()의 결과를 할당
            expStr = getEmptyStr()
            //binding.textView.text은 getZeroStr()결과를 할당
            binding.textView.text = getZeroStr()
        }
        //binding.Equals이 클릭되었을때 수행할 동작
        binding.Equals.setOnClickListener {
            //expStr은 addOp()결과를 할당
            expStr = addOp(
                oldExpStr = expStr,
                //newNumberStr = binding.textView.text를 string으로 형변환 한 값
                newNumberStr = binding.textView.text.toString()
            )
            //binding.textView.text는 getCalcResult()결과를 할당
            binding.textView.text = getCalcResult(
                expStr = expStr
            )
            //expStr은 getEmptyStr()결과를 할당
            expStr = getEmptyStr()
        }
    }
}