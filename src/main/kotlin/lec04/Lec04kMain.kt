package lec04

// Lec 04. 코틀린에서 연산자를 다루는 방법
// 1. 단항 연산자 / 산술 연산자
// 2. 비교 연산자와 동등성, 동일성
// 3. 논리 연산자 / 코틀린에 있는 특이한 연산자
// 4. 연산자 오버로딩

// 1. 단항 연산자 / 산술 연산자
// - 단항 연산자 : ++, --
// - 산술 연산자 : +, - , *, /, %
// - 산술대입 연산자 : +=, -=, *=, /=, %=
// Java와 Kotlin 완전 동일

// 2. 비교 연산자와 동등성, 동일성
// - 비교 연산자 : >, <, >=, <= // Java, Kotlin 사용법은 동일.
//                            // 단, Java와 다르게 객체를 비교할 때 비교 연산자를 사용하면 자동으로 compareTo를 호출해준다.

//fun main() {
//    val money1 = JavaMoney(2_000L)
//    val money2 = JavaMoney(1_000L)
//
//    if(money1 > money2) {   // > 에 마우스 갖다대고 ctrl 왼클릭 해보면 구현되어있는 compareTo로 화면이 이동됨
//                            // Java와 다르게 객체를 비교할 때 비교 연산자를 사용하면 자동으로 compareTo를 호출해줌.
//        println("Money1이 Money2보다 금액이 큽니다용")
//    }
//}

// - 동등성(Equality) : 두 객체의 값이 같은가
// - 동일성(Identity) : 완전히 동일한 객체인가. 즉, 주소가 같은가.(객체 레퍼런스가 같은가)
// 자바에서는 동일성에 ==를 사용, 동등성에 equals를 직접 호출
// 코틀린에서는 동일성에 ===를 사용, 동등성에 ==를 호출(==를 사용하면 간접적으로 equals를 호출해준다)
//fun main() {
//    val money1 = JavaMoney(1_000L)
//    val money2 = money1
//    val money3 = JavaMoney(1_000L)
//
//    println(money1 === money2) // 동일성 : true
//    println(money1 == money2)  // 동등성 : true    // > 와 마찬가지로 equals로 화면이 이동함.
//    println(money1 === money3) // 동일성 : false
//    println(money1 == money3)  // 동등성 : true
//}

// 3. 논리 연산자 / 코틀린에 있는 특이한 연산자
// - 논리 연산자 : &&, ||, !
// Java와 완전히 동일, Java처럼 Lazy 연산을 수행.
//fun main() {
//    if(fun1() || fun2()) {
//        println("본문")   // 만약 if(fun2() && fun1()) {println("본문")} 이었다면 "본문"은 호출되지 않음
//    }
//}
//
//fun fun1(): Boolean {
//    println("fun 1")
//    return true
//}
//
//fun fun2(): Boolean {
//    println("fun 2")
//    return false
//}

// - 코틀린에 있는 특이한 연산자
// - in / !in : 컬렉션이나 범위에 포함되어 있다, 포함되어 있지 않다.
// println(1 in numbers) // 반복문 때 좀 더 자세히 공부할 것임.
// - a..b : a부터 b까지의 범위 객체를 생성한다.
// - a[i] : a에서 특정 Index i로 값을 가져온다.
// val str = "ABC"
// println(str[2])  // C <- 문자열에서 특정 문자를 가져오는 방법
// - a[i] = b : a의 특정 index i에 b를 넣는다.

// 4. 연산자 오버로딩
// - Kotlin에서는 객체마다 연산자를 직접 정의할 수 있다.
// val money1 = Money(1_000L)
// val money2 = Money(2_000L)
// println(money1 + money2) // Money(amount = 3000)

fun main() {
    val money1 = Money(1_000L)
    val money2 = Money(2_000L)
    println(money1.plus(money2))
    println(money1+money2)
}

// Lec 04. 코틀린에서 연산자를 다루는 방법
// 1. 단항 연산자, 산술 연산자, 산술대입 연산자는 Java와 같다.
// 2. 비교 연산자 사용법도 Java와 같다.
// - 단, 객체끼리도 자동 호출되는 compareTo를 이용해 비교 연산자를 사용할 수 있다.
// 3. in, !in, a..b, a[i], a[i] = b와 같이 코틀린에서 새로 생긴 연산자도 있다.
// 4. 객체끼리의 연산자를 직접 정의할 수 있다.