package lec12

// Lec 12. 코틀린에서 object 키워드를 다루는 방법
// 1. static 함수와 변수
// 2. 싱글톤
// 3. 익명 클래스

// 1. static 함수와 변수
//class Person(
//    private var name: String,
//    private var age: Int
//) {
//    // Kotlin에는 static이란게 없음. 대신 해서 있는 것이 companion object(동행 객체)
//    // static : 클래스가 인스턴스화 될 때 새로운 값이 복제되는게 아니라 정적으로 인스턴스끼리의 값을 공유
//    // compaion object : 클래스와 동행하는 유일한 프로젝트
//    companion object {  // static 대신 companion object 사용!
//        private val MIN_AGE = 1             // 런타임 시에 변수가 할당됨
//        // private const val MIN_AGE = 1    // const를 붙여주면 컴파일 시에 변수가 할당됨
//        // const : 진짜 상수에 붙이기 위한 용도. 기본 타입과 String에 붙일 수 있음.
//        fun newBaby(name: String): Person {
//            return Person(name, MIN_AGE)
//        }
//    }
//}

// Java와의 차이점
// companion object, 즉 동반객체도 하나의 객체로 간주된다. 때문에 이름을 붙일 수도 있고, interface를 구현할 수도 있다.
class Person(
    private var name: String,
    private var age: Int
) {
    companion object Factory : Log {
        private val MIN_AGE = 1

        @JvmStatic  // Java에서 Kotlin companion object를 사용하려면 @JvmStatic을 붙여줘야함.
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스의 동행객체 Factory에용")
        }
    }
}

interface Log {
    fun log()
}
// companion object에 유틸성 함수들을 넣어도 되지만, 최상단 파일을 활용하는 것을 권장함.

// 2. 싱글톤 : 단 하나의 인스턴스만을 갖는 클래스
// 앞에 object를 붙여주면 됨.
// ex) object Singleton
// 코틀린에서 직접적으로 싱글톤 객체를 만들 일은 거의 없음.
//object Singleton {
//    var a: Int = 0
//}
//
//fun main() {
//    println(Singleton.a)
//    Singleton.a += 10
//    println(Singleton.a)
//}

// 3. 익명 클래스 : 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스
private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}

fun main() {
    moveSomething(object : Movable {     // Kotlin에서는 object: 타입이름
        override fun move() {
            println("무브 무브")
        }

        override fun fly() {
            println("난다요~ 난다요~")
        }
    })
}

// Lec 12. 코틀린에서 object 키워드를 다루는 방법
// 1. Java의 static 변수와 함수를 만들려면, Kotlin에서는 companion object를 사용해야 한다.
// 2. companion object도 하나의 객체로 간주되기 때문에 이름을 붙일 수 있고, 다른 타입을 상속받을 수도 있다.
// 3. Kotlin에서 싱글톤 클래스를 만들 때 object 키워드를 사용한다.
// 4. Kotlin에서 익명 클래스를 만들 때 object: 타입을 사용한다.