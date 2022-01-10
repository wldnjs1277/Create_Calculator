package com.example.calculator

/*TODO
   객체란 무엇인가?
*   객체란 하나의 역할을 수행하는 메소드와 데이터의 묶음
*   Java에서는 new를 이용하여 객체를 생성하지만
*   코틀린에서는 new를 사용하지 않는다.
*  --------------------------
*  Instance란?
*   class로부터 생성된 객체를 Instance라고 한다.
*   객체 지향 언어적 관점에서 객체는 선언, 인스턴스는 그 객체가 메모리에 할당되어 사용될때를 의미.
*
* */
fun main(){
    val c = test()
    println(c.age)

}
class test(){
    var name = "aaa"
    var age=27

}