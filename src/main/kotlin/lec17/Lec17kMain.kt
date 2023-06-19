package lec17

import java.io.BufferedReader
import java.io.FileReader

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

    // 람다를 만드는 방법 1
    // 우리가 아는 일반적인 함수를 만드는 방법. but, 함수의 이름이 빠짐.
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 람다를 만드는 방법 2
    // 중괄호와 화살표를 이용한 방법.
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }
    // : (Fruit) -> Boolean     함수의 타입 :(파라미터 타입...) -> 반환 타입
    // 소괄호 안에 파라미터 타입들을 적어주고, 여러개면 (Fruit, Boolean, String) 이런식으로 됨.
    // 그 다음 -> 반환 타입


    // 함수를 직접 호출하는 방법 1
    // 소괄호를 통해서 바로 함수를 호출해도 되고
    isApple(fruits[0])
    isApple2(Fruit("사과", 1000))

    // 함수를 직접 호출하는 방법 2
    // invoke라는 걸 명시적으로 작성해서 함수를 호출할 수도 있음.
    isApple.invoke(fruits[0])
    isApple2.invoke(Fruit("바나나", 3000))

//    filterFruits(fruits, isApple)
//    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
//    filterFruits(fruits) { fruit -> fruit.name == "사과" }
//    filterFruits(fruits) { a -> a.name == "사과" }
    filterFruits(fruits) { it.name == "사과" }

    filterFruits(fruits) { fruit ->
        println("사과만 받는다..!!")
        fruit.name == "사과"
    }
    // 람다를 여러줄 작성할 수 있고, (return을 따로 명시해주지 않더라도) 마지막 줄의 결과가 람다의 반환값이다.
}

// Java에 적어둔 filterFruits 코틀린으로 옮겨보기
private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    var results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}
// Predicate 같이 함수 인터페이스를 쓰는게 아니라 함수 자체를 파라미터로 받아서 과일을 필터링 해주는 함수를 만들게 됐음.

// 3. Closure
//fun void() {
//    var targetFruitName = "바나나"
//    targetFruitName = "수박"
//    filterFruits(fruits) { it.name == targetFruitName }
    // 코틀린에서는 가능
    // -> 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있다.
    // 이렇게 해야만, 람다를 진정한 일급 시민으로 간주할 수 있다.
    // 이 데이터 구조를 Closure이라 부른다.
//}

// 4. 다시 try with resource
class FilePrinter {
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}
// use를 타고 들어가보면
// public inline fun <T : Closeable?, R> T.use(block: (T) -> R): R {
// T: Closeable?, T.use : Closeable 구현체에 대한 확장함수이다.
// - Closeable을 구현한 타입 T에 대한 확장 함수.
// inline : inline 함수이다.
// (block: (T) -> R) : 람다를 받게 만들어진 함수이다.
// - 받고 있는 파라미터가 block이라는 이름을 가진 함수이다.
// - T타입의 파라미터가 들어가고 R타입의 반환타입을 갖는

// 실제 use를 사용하는 쪽
// { reader ->
//            println(reader.readLine())
// }
// 실제 람다를 전달하고 있다.
// - reader라는 파라미터를 받고 어떠한 결과를 수행하는 함수를 람다로써 전달해주고 있다.


// Lec 17. 코틀린에서 람다를 다루는 방법
// 1. 함수는 Java에서는 2급시민이지만, Kotlin에서는 1급시민이다.
// - 때문에 함수 자체를 변수에 넣을 수도 있고 파라미터로 전달할 수도 있다.
// - 마치 인터페이스와 람다를 써서 함수를 보내는 것처럼 보여지는 Java와는 조금 달랐음.
// 2. Kotlin에서 함수 타입은 (파라미터 타입, ...) -> 반환타입 이었다.
// 3. Kotlin에서 람다는 두 가지 방법으로 만들 수 있고, { }(중괄호)방법이 더 많이 사용된다.
// - 람다를 만드는 방법 1
// val isApple = fun(fruit: Fruit): Boolean {
//   return fruit.name == "사과"
// }
// - 람다를 만드는 방법 2
// val isApple2 = { fruit: Fruit -> fruit.name == "사과" }
// 4. 함수를 호출하며, 마지막 파라미터인 람다를 쓸 때는 소괄호 밖으로 람다를 뺄 수 있다.
// - filterFruits(fruits) { fruit -> fruit.name == "사과" } // 이 방법을 더 추천하긴함(가독성)
// - filterFruits(fruits) { it.name == "사과" }
// 5. 람다의 마지막 expression 결과는 람다의 반환 값이다.
// - filterFruits(fruits) { fruit ->
//      println("사과만 받는다..!!")
//      fruit.name == "사과"
// }
// - 이렇게 람다를 길게 여러 줄로 쓸 수 있는데 이 중 리턴을 작성하지 않아도 마지막에 들어가는 expression의 최종 결과가 람다의 반환값이 됨.
// 6. Kotlin에서는 Closure를 사용하여 non-final 변수(값이 바뀌는 가변 변수)도 람다에서 참조해서 사용할 수 있다.

