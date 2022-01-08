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
    }//expStr[expStr길이-1]인덱스가 숫자인지 판별하고 expStr을 인자로 받는calcAnswer() 반환
    return if (expStr[expStr.length-1].isDigit()) { //isDigit 입력받은 문자열이 숫자인지 판별
        calcAnswer(expStr)
        //그렇지 않으면 expStr을0번부터 expStr-1한 인덱스까지 자른값을 인자로 받는 calcAnswer()반환
    } else {
        calcAnswer(expStr.substring(0, expStr.length-1))
    }
}

/* 입력된 문자열을 계산하여 반환 */
//데이터 타입이 String인 expStr을 매개변수로 받고 return타입이 String인 calcAnswer함수
private fun calcAnswer(expStr: String): String {
    //infixList는 expStr을 인자로 받는getInfixList() 결과를 할당
    val infixList = getInfixList(expStr)
    //postfix는 infixList를 인자로 받는 inFixToPostFix 결과를 할당
    val postfix = inFixToPostFix(infixList)
    //postfix를 인자로 받는 postfixCalc()를 반환
    return postfixCalc(postfix)
}


/* 입력된 문자열(중위표기법)을 숫자와 수식으로 분리하기 */
//데이터타입이 string인 expStr을 매개변수로 받고 리턴타입이 List<String>인 getInfixList함수
private fun getInfixList(expStr: String): List<String> {
    //infixList는 수정이가능한데이터타입이string인리스트를 초기화 한 결과를 할당
    val infixList = mutableListOf<String>()
    //number는 StringBuilder()를 할당
    val number = StringBuilder()
    //expStr을 공백으로 나누고 나눈것을 반복문 it으로 받고
    expStr.split("").forEach {
        when(it) {
            //it이 "+", "-", "X", "/" 일때 {}를 수행
            "+", "-", "X", "/" -> {
                // infixList에 number를 string혀으로 변환한 것을 추가한다
                infixList.add(number.toString())
                //number를 비우고 반환
                number.clear()
                //infixList에 it을 추가한다
                infixList.add(it)
            }
            //그렇지 않으면 number에 it을 추가
            else -> number.append(it)
        }
    }//number가 비어있지않다면 /infixList number를string으로 형변환 한 값을 추가
    if (number.isNotEmpty()) {
        infixList.add(number.toString())
    }
    //infixList반환
    return infixList
}

/* 중위표기법 to 후위표기법 */
//리스트 타입이 string인 infixList를 매개변수로 받고 리턴타입은 리스트타입이 string인 inFixToPostFix함수
private fun inFixToPostFix(infixList: List<String>): List<String> {
    //TODO 중위표기법 to 후위표기법
    //postfixList는 mutableListOf의 타입이 string인 결과를 할당
    val postfixList = mutableListOf<String>()
    // opPriority는 hashMapOf의<key타입은stringvalue는 Int>apply를 이용하여 {}안의 결과를 할당
    val opPriority = hashMapOf<String,Int>().apply {//hashMapOf(key와value를 가진다)
        //hashMapOf의key값이"+"이면 1을 반환
        this["+"] = 1
        //hashMapOf의key값이"-"이면 1을 반환
        this["-"] = 1
        //hashMapOf의key값이"X"이면 2를 반환
        this["X"] = 2
        //hashMapOf의key값이"/"이면 2를 반환
        this["/"] = 2
    }
    //opStack은 데이터타입이String인Stack을 할당
    val opStack = Stack<String>()
    //postfixList를 반환
    return postfixList
}

/* 후위표기법으로 계산하기 */
// 리스트타입이 string인 tokens을 매개변수로 받고 리턴타입은string인 postfixCalc함수
private fun postfixCalc(tokens: List<String>): String {
    //TODO 후위표기법으로 계산로직 구현
    var answer = ""

    answer = "0"
    return answer
}