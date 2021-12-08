package com.example.calculator

import java.util.*



fun main(){
    postfix("(3+4)*(1-2)+1")

}
fun postfix(input:String) {
    val stack = Stack<String>()
    val result = StringBuilder()  // StringBuilder 코틀린에서 동적으로 문자열을 조작가능
    for (i in 0 until input.length) {
        when (input[i].toString()) {
            "(" -> {
                input[i].toString().replace("(", "")
            }
            ")" -> {
                if (!stack.isEmpty()) {
                    for (j in 0 until stack.size) {
                        result.append(stack.pop())
                    }
                }
            }
            "+" -> {
                stack.push("+")
            }
            "-" -> {
                stack.push("-")
            }
            "*" -> {
                stack.push("*")
            }
            "/" -> {
                stack.push("/")
            }
            else -> {
                if (input[i].toString().toInt() in 0..9) {
                    result.append(input[i].toString())
                }
            }
        }
    }
    if (!stack.isEmpty()) {
        for (k in 0 until stack.size) {
            result.append(stack.pop())
        }
    }
    println(result)
}



