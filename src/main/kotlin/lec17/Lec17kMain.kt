package lec17

// Lec 17. 코틀린에서 람다를 다루는 방법
// 1. Java에서 람다를 다루기 위한 노력
// 2. Kotlin에서의 람다
// 3. Closure
// 4. 다시 try with resource
// - Kotlin에서는 try with resource가 없고 use라는 함수를 사용함

// 1. Java에서 람다를 다루기 위한 노력
// Lec17jMain.java 참조(~line136).

// 2. Kotlin에서의 람다
// Java와는 근본적으로 다른 한 가지가 있다.
// Kotlin에서는 함수가 그 자체로 값이 될 수 있다! 변수에 할당할 수도, 파라미터로 넘길 수도 있다!
// Java에서는 마치 함수를 넘겨주는 것처럼 보여지지 함수를 근본적으로 넘길 수는 없었다. -> 코틀린은 가능해짐

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }
}


