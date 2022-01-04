package com.example.calculator

import java.util.*


/* 결과 초기화 */
//getEmptyStr()의 결과 값은 ""
fun getEmptyStr() = ""
//getZeroStr()의 결과 값은 0
fun getZeroStr() = "0"

/* 숫자 입력 */
//데이터타입이 string인 oldNumberStr 와 newNumberStr를 매개변수로 받고 return 타입이 string인 addNumber함수
fun addNumber(oldNumberStr: String, newNumberStr: String): String {
    // 조건문 oldNumberStr이 "0"과 같다면 newNumberStr를 반환
    return if (oldNumberStr == "0") {
        newNumberStr
        //그렇지 않으면 스트링템플릿을 이용하여 oldNumberStr와 newNumberStr 출력
    } else {
        "${oldNumberStr}${newNumberStr}"
    }
}

/* 수식 입력 */
/*데이터 타입이 string인 oldExpStr,newNumberStr,newOpStr를 매개변수로 받고
* newOpStr의 값은"" return타입은string인 addOp함수 */
fun addOp(oldExpStr:String, newNumberStr:String, newOpStr: String = ""): String {
    //조건문 newNumberStr을 double로 형변환 한 값이 0.0과 같다면 oldExpStr 반환
    return if (newNumberStr.toDouble()==0.0) {
        oldExpStr
        //그렇지 않으면 스트링템플릿을 이용하여 oldExpStr,newNumberStr.toDouble(),newOpStr 출력
    } else {
        "${oldExpStr}${newNumberStr.toDouble()}${newOpStr}"
    }
}

/* 부호 변경 */
//데이터 타입이 string인 newNumberStr를 매개변수로 받고 return타입이 string인 changeDataMask함수
fun changeDataMask(newNumberStr: String): String {
    //조건문 newNumberStr이 "-"을 포함하고 있으면 newNumberStr.substring을 이용하여 1번째 인덱스 부터 자른 값을 반환
    return if (newNumberStr.contains("-")) {
        newNumberStr.substring(1) //substring은 코틀린에서 문자열을 잘라서 출력할때 사용
    }
    //그렇지 않으면 string템플릿을 이용하여 "-newNumberStr"출력
    else {
        "-${newNumberStr}"
    }
}
/* 소수점 전환 */
//데이터 타입이 string인 newNumberStr을 매개변수로 받고 return타입이 string인 changeDataPoint함수
fun changeDataPoint(newNumberStr: String): String {
    //조건문 newNumberStr이 "." 를 포함하고 있으면 newNumberStr을 반환
    return if (newNumberStr.contains(".")) {
        newNumberStr
        //그렇지 않으면 string템플릿을 이용하여 "newNumberStr."를 출력
    } else {
        "${newNumberStr}."
    }
}

/* 퍼센트 처리 */
fun percentData() {
    //TODO 퍼센트를 클릭했을 때 어떻게 동작하는지 확인하여 처리해야함.
}

/* 계산 */
//데이터타입이 string인 expStr을 매개변수로 받고 return타입이 string인 getCalcResult 함수
fun getCalcResult(expStr: String): String {
    //expStr 이 비어있다면 "0"을 반환
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