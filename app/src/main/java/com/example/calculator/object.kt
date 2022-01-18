package com.example.calculator

/*TODO
   객체란 무엇인가?
*   객체란 하나의 역할을 수행하는 메소드와 변수의 묶음
*   Java에서는 new를 이용하여 객체를 생성하지만
*   코틀린에서는 new를 사용하지 않는다.
*   -------------------------
*  Instance란?
*   class로부터 생성된 객체를 Instance라고 한다.
*   객체 지향 언어적 관점에서 객체는 선언, 인스턴스는 그 객체가 메모리에 할당되어 사용될때를 의미.
    -------------------------
   객체지향이란?
    프로그래밍의 페러다임 중 하나이다.
    객체지향언어는 상태와 행위로 이루어진 객체라는 기본다위로 나누고 객체들간의 상호작용을 통해 프로그램을 설계하는 것
    객체지향의 장점으로는 재사용이 용이하고 생산성이높고 유지보수가 용이하다.
    단점으로는 설계시간이 오래걸리고 실행속도가 느리다.
    -------------------------
    ActivityLifeCycle이란?
    앱이 생성되어 실행되고 종료될때 까지의 상태변화를 알려주는 과정
    수명주기 단계 간에 전환을 위해서 onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy() 6개의 콜백메서드가 존재한다.
    -onCreate() 액티비티가 생성될때 실행됨 필수적으로 구현해야 한다.
    -onCreate()메서드는 savedInstanceState를 매개변수로 받고
    savedInstanceState는 활동의 이전 저장 상태가 포함된 Bundle 객체이다. 처음생생된 Bundle객체의 값은 null이다.
    --------------------------
    -onStart() onCreate()다음 단계 이고 사용자에게 보이기 시작하는단계
    -onStart() 호출 후 Activity는 onResume()상태로 변경된다.
    Activity가 사용자에게 표시되고 앱은 Activity를 포그라운드에 보내 상호작용할 수 있도록 준한다.
    --------------------------
    -onResume() onStart()다음 단계인 메소드
    사용자와 상호작용하는 단계이고 Activity에서 포커스가 없어질 때까지 상태가 지속된다.
    Activity가 포그라운드에 표시된다.
    포커스가 사라지면 Activity가 일시정지 상태가 되고 일시정지 상태가 되면 onPause() 메소드가 호출된다.
    일시정지 상태에서 다시 Activity가 활성화 되면 onResume()이 호출된다.
    onResume()이 호출되면 Activity가 재개될때 필요한 초기화 작업을 수행한다.
    -------------------------
    -onPause()
    시스템은 사용자가 Activity를 떠나는 것을 나타내는 첫 번째 신호로 이 메서드를 호출한다.
    Activity가 포그라운드에 있지 않게 되었다는 것을 나타낸다
    -------------------------
    -onStop()
    Activity가 사용자에게 더이상 표시 되지 않으면 정지 상태가 되고 onStop() 메서드를 호출 한다.
    정지상태에서 다시 시작되어 상호작용하거나( onRestart()를 호출 ) 실행을 종료하고 사라진다. ( onDestroy()를 호출 )
    -------------------------
    -onDestroy()
    Activity가 소멸되기 전에 호출된다.
    사용자가 Activity를 완전히 종료해서 onDestroy()가 호출되는 경우
    화면구성이 변경되어 onDestroy()를 호출하는 경우
    화면구성이 변경되어 onDestroy()를 호출된 경우에는 새로운 Activity가 onCreate()된다.
    -------------------------
    Bundle이란?
    여러기자 티입의 값을 저장하는 map 클래스이다
    map클래스는 키와 값을 한 쌍으로 저장하는 방식
    Bundle의 용도로는 Activity 간의 데이터를 전달하거나 savedInstanceState라는 매개변수를 이용하여 이전상태를 저장한다.
    -------------------------
    상속이란?
    클래스를 선언할 때 다른 클래스를 참조해 작성하는 개념
    상속을 하게 되면 클래스가 계층구조를 가지게 된다.
    상위클래스를 지정하기 위해서 상속받을 클래스 : 뒤에 상속할 클래스가 온다.
    상위 클래스에 정의된 함수나 프로퍼티를 상속받아 정의하는 클래스에서 사용 가능 하다.
    클래스 앞에 open을 명시하여야 상속이 가능하다.
    -------------------------
    Super와 this
    Super는 상위 클래스의 메서드나 프로퍼티 생성자를 사용하는 키워드
    this는 현재 클래스의 메서드나 프로퍼티 생성자를 사용하는 키워드
    -------------------------
    override
    부모클래스에 open을 붙여주어야 override 가능하다.
    override를 하기 위해서는 override를 붙여 줘야 하고 상위 클래스의 함수명 메게변수를 같게 해야 한다.
    override는 상위 클래스의 메서드를 하위 클래스에서 재정의 하여 사용하는 것을 말한다.
    */


open class test{
    open fun test1(){
        println( "test class의 test1")
    }
}
fun main(){
    val check = test()
    check.test1()
    val check2 = test2()
    check2.test1()
    check2.test2()
}
class test2:test(){
    override fun test1(){
        println("test2클래스의 test1")
    }
    fun test2(){
        super.test1()
    }


}
