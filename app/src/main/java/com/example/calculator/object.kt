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
    객체지향의 장점으로는 재사용이 용의하다. 생산성이높고 유지보수가 용이하다.
    단점으로는 설계시간이 오래걸리고 실행속도가 느리다.
    -------------------------
    ActivityLifeCycle이란?
    앱이 생성되어 실행되고 종료될때 까지의 상태변화를 알려주는 과정
    수명주기 단계 간에 전환을 위해서 onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy() 6개의 콜백메서드가 존재한다.
    onCreate() 액티비티가 생성될때 실행됨 필수적으로 구현해야 한다.
    onCreate()메서드는 savedInstanceState를 매개변수로 받고
    savedInstanceState는 활동의 이전 저장 상태가 포함된 Bundle 객체이다. 처음생생된 Bundle객체의 값은 null이다.

        */
