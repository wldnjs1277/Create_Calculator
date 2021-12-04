package com.example.calculator

import java.util.*



fun main(){
postfix("(3+4)*(1-2)")
}
//만드는중
fun postfix(input:String) {
    var stack = Stack<String>()
    var result = StringBuilder()  // StringBuilder 코틀린에서 동적으로 문자열을 조작가능
    for (i in 0 until input.length) {
        when (input[i].toString()) {
            "(" -> {
                stack.push("(")
            }
            ")" -> {
                if (!stack.isEmpty()) {
                    for (j in 0 until stack.size) {
                        //result.append(stack.pop())
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
            else -> result.append(input[i].toString())
        }
    }
    for(k in 0 until stack.size){
        result.append(stack.pop())
    }


    println(result)
}



