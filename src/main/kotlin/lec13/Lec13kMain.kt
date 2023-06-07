package lec13

import lec13.JavaHouse.LivingRoom

// Lec 13. 코틀린에서 중첩 클래스를 다루는 방법
// 1. 중첩 클래스의 종류
// 2. 코틀린의 중첩 클래스와 내부 클래스

// 1. 중첩 클래스의 종류
// Java에서의 중첩 클래스 : 어딘가에 소속되어 있는 클래스, 여러 종류가 있었다.
// 1) static을 사용하는 중첩 클래스 : Class 안에 static을 붙인 Class. 밖의 Class 직접 참조 불가 - 중첩 Class
// 2) static을 사용하지 않는 중첩 클래스
//  (1) 내부 클래스(Inner Class) : Class 안의 Class, 밖의 Class 직접 참조 가능. - 중첩 Class
//  (2) 지역 클래스(Local Class) : 메소드 내부에 Class를 정의(거의 안씀)
//  (3) 익명 클래스(Anonymous Class) : 일회성 Class

// 2. 코틀린의 중첩 클래스와 내부 클래스
// Java에서 말하는 권장되는 중첩 클래스를 코틀린으로 작성한 것이 아래의 코드
// 클래스 안의 클래스 : 바깥 클래스 참조 없음. 권장되는 유형
class House(
    private val address: String,
    private val livingRoom: LivingRoom
) {
    class LivingRoom(
        private val area: Double
    )
}

// Java에서 말하는 권장되지 않는 중첩 클래스를 코틀린으로 작성한 것이 아래의 코드
// 클래스 안의 inner 클래스 : 바깥 클래스 참조 있음
// (바깥 클래스에 대한 참조를 가지고 있는)
class House2(
    private val address: String,
    private val livingRoom: LivingRoom
) {
    inner class LivingRoom(                 // inner라는 키워드를 직접적으로 붙여주어야함
        private val area: Double
    ) {
        val address: String
            get() = this@House2.address     // 바깥클래스 참조를 위해 this@바깥클래스를 사용한다.
    }
}
// 기본적으로 바깥 클래스를 참조하지 않는다.
// 바깥 클래스를 참조하고 싶다면 inner 키워드를 추가한다.

// Lec 13. 코틀린에서 중첩 클래스를 다루는 방법
// 1. 클래스 안에 클래스가 있는 경우 종류는 두 가지였다.
//  1) (Java 기준) static을 사용하는 클래스
//  2) (Java 기준) static을 사용하지 않는 클래스
// 2. 권장되는 클래스는 static을 사용하는 클래스이다.
// 3. 코틀린에서는 이러한 가이드를 따르기 위해
//  1) 클래스 안에 클래스를 사용하면 바깥 클래스에 대한 참조가 없고
//  2) 바깥 클래스를 참조하고 싶다면, inner 키워드를 붙여야 한다.
// 4. 코틀린 inner class에서 바깥 클래스를 참조하려면 this@바깥클래스 를 사용해야 한다.