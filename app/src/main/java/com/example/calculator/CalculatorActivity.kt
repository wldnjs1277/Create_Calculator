package com.example.calculator.devhyeon.calc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding

    private var expStr = getEmptyStr()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        numberClickListener()
        operatorClickListener()
        otherClickListener()
    }

    /* 숫자버튼 클릭 리스너 */
    private fun numberClickListener() {
        listOf(
            binding.ZeroBtn,
            binding.OneBtn, binding.TwoBtn, binding.ThreeBtn,
            binding.FourBtn, binding.FiveBtn, binding.SixBtn,
            binding.SevenBtn, binding.EightBtn, binding.NineBtn
        ).forEach { button ->
            button.setOnClickListener {
                binding.textView.text = addNumber(
                    oldNumberStr = binding.textView.text.toString(),
                    newNumberStr = button.text.toString()
                )
            }
        }
    }

    /* 수식버튼 클릭 리스너 */
    private fun operatorClickListener() {
        listOf(
            binding.PlusBtn, binding.MinusBtn, binding.Multiplicaton, binding.DivisonBtn, binding.percent
        ).forEach { button ->
            button.setOnClickListener {
                expStr = addOp(
                    oldExpStr = expStr,
                    newNumberStr = binding.textView.text.toString(),
                    newOpStr = button.text.toString()
                )
                binding.textView.text = getZeroStr()
            }
        }
    }

    /* 숫자와 수식이 아닌 버튼 클릭리스너 */
    private fun otherClickListener() {
        binding.PMBtn.setOnClickListener {
            binding.textView.text = changeDataMask(
                newNumberStr = binding.textView.text.toString()
            )
        }

        binding.DecimalPoint.setOnClickListener {
            binding.textView.text = changeDataPoint(
                newNumberStr = binding.textView.text.toString()
            )
        }

        binding.ACBtn.setOnClickListener {
            expStr = getEmptyStr()
            binding.textView.text = getZeroStr()
        }

        binding.Equals.setOnClickListener {
            expStr = addOp(
                oldExpStr = expStr,
                newNumberStr = binding.textView.text.toString()
            )
            binding.textView.text = getCalcResult(
                expStr = expStr
            )
            expStr = getEmptyStr()
        }
    }
}