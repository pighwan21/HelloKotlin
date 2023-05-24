package lec06

// Lec 06. 코틀린에서 반복문을 다루는 방법
// 1. for-each문(향상된 for문)
// 2. 전통적인 for문
// 3. Progression과 Range // Kotlin에서는 전통적인 for문을 사용할 때 Progression과 Range를 사용함.
// 4. while문

// 반복문 : 무언가를 반복할 때 많이 사용. 리스트와 같은 컬렉션이나 배열과 함께 사용하는 경우가 많음.

// 1. for-each문(향상된 for문)
//fun main() {
//    val numbers = listOf(1L, 2L, 3L)    // listof : 리스트를 만들어 주는 코드(자세한 내용은 컬렉션을 다루는 방법에서 배울 것)
//    for (number in numbers) {
//        println(number)
//    }
//}
// 차이점 : 1) 컬렉션을 만드는 방법이 다름
//         2) : 대신 in을 사용

// 2. 전통적인 for문
//fun main() {
//    // Kotlin에서 1부터 3까지 출력하는 예제(올라가는)
//    for (i in 1..3) {   // 1..3 : 1부터 3까지 라는 의미
//        println(i)
//    }
//
//    // Kotlin에서 3부터 1까지 출력하는 예제(내려가는)
//    for (i in 3 downTo 1) {     // downTo : ~부터 ~까지 내려가는 걸 의미한다고 생각하면 됨
//        println(i)
//    }
//
//    // Kotlin에서 2칸씩 올라가는 경우 출력
//    for (i in 1..5 step 2) { // step 2 : 2씩
//        println(i)
//    }
//
//    // Kotlin에서 2칸씩 내려가는 경우 출력
//    for (i in 5 downTo 1 step 2) {
//        println(i)
//    }
//}

// 3. Progression과 Range
// .. 연산자 : 범위를 만들어 내는 연산자.
// Progression : 등차수열 // 시작값, 끝값, 공차. 총 3개의 변수가 필요.
// ex) 1..3 : 1부터 3의 범위 // 사실은 등차수열을 만들어주는 코드임.
// ex) 3 downTo 1 : 시작값 3, 끝값 1, 공차가 -1인 등차수열
// ex) 1..5 step 2 : 시작값 1, 끝값 5, 공차가 2인 등차수열
// Kotlin에서 전통적인 for문은 등차수열을 이용한다!

// 참고로 downTo와 step도 함수이다.(중위 호출 함수)
// 변수.함수이름(argument) 대신 변수 함수이름 argument 방식

// 4. while문 : java와 완전 동일. do-while문도 마찬가지.
fun main() {
    var i = 1;
    while (i <= 3) {
        println(i)
        i++
    }
}

// Lec 06. 코틀린에서 반복문을 다루는 방법
// 1. for each문에서 Java는 :, Kotlin은 in을 사용한다.
// 2. 전통적인 for문에서 Kotlin은 등차수열과 in을 사용한다.
// 3. 그 외 for문 문법은 모두 동일하다.
// 4. while문과 do while문은 더욱더 놀랍도록 동일하다.