package com.example.calculator.devhyeon.calc

import java.util.*


/* 결과 초기화 */
fun getEmptyStr() = ""
fun getZeroStr() = "0"

/* 숫자 입력 */
fun addNumber(oldNumberStr: String, newNumberStr: String): String {
    return if (oldNumberStr == "0") {
        newNumberStr
    } else {
        "${oldNumberStr}${newNumberStr}"
    }
}

/* 수식 입력 */
fun addOp(oldExpStr:String, newNumberStr:String, newOpStr: String = ""): String {
    return if (newNumberStr.toDouble()==0.0) {
        oldExpStr
    } else {
        "${oldExpStr}${newNumberStr.toDouble()}${newOpStr}"
    }
}

/* 부호 변경 */
fun changeDataMask(newNumberStr: String): String {
    return if (newNumberStr.contains("-")) {
        newNumberStr.substring(1)
    } else {
        "-${newNumberStr}"
    }
}
/* 소수점 전환 */
fun changeDataPoint(newNumberStr: String): String {
    return if (newNumberStr.contains(".")) {
        newNumberStr
    } else {
        "${newNumberStr}."
    }
}

/* 퍼센트 처리 */
fun percentData() {
    //TODO 퍼센트를 클릭했을 때 어떻게 동작하는지 확인하여 처리해야함.
}

/* 계산 */
fun getCalcResult(expStr: String): String {
    if (expStr.isEmpty()) {
        return "0"
    }
    return if (expStr[expStr.length-1].isDigit()) {
        calcAnswer(expStr)
    } else {
        calcAnswer(expStr.substring(0, expStr.length-1))
    }
}

/* 입력된 문자열을 계산하여 반환 */
private fun calcAnswer(expStr: String): String {
    val infixList = getInfixList(expStr)
    val postfix = inFixToPostFix(infixList)
    return postfixCalc(postfix)
}


/* 입력된 문자열(중위표기법)을 숫자와 수식으로 분리하기 */
private fun getInfixList(expStr: String): List<String> {
    val infixList = mutableListOf<String>()

    val number = StringBuilder()
    expStr.split("").forEach {
        when(it) {
            "+", "-", "X", "/" -> {
                infixList.add(number.toString())
                number.clear()
                infixList.add(it)
            }
            else -> number.append(it)
        }
    }
    if (number.isNotEmpty()) {
        infixList.add(number.toString())
    }

    return infixList
}

/* 중위표기법 to 후위표기법 */
private fun inFixToPostFix(infixList: List<String>): List<String> {
    //TODO 중위표기법 to 후위표기법
    val postfixList = mutableListOf<String>()

    val opPriority = hashMapOf<String,Int>().apply {
        this["+"] = 1
        this["-"] = 1
        this["X"] = 2
        this["/"] = 2
    }

    val opStack = Stack<String>()

    return postfixList
}

/* 후위표기법으로 계산하기 */
private fun postfixCalc(tokens: List<String>): String {
    //TODO 후위표기법으로 계산로직 구현
    var answer = ""

    answer = "0"
    return answer
}