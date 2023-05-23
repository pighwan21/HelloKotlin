package lec01

fun main() {

    var number1 = 10L // var : Variable(베리어블)의 약자 / '발'로 읽음
    number1 = 5L
    val number2 = 10L // val : Value의 약자 / '밸'로 읽음
//    number2 = 5L // Val cannot be reassigned
    // 코틀린에서는 모든 변수에 수정 가능 여부(var / val)를 명시해주어야 한다.
    // 타입을 의무적으로 작성하지 않아도 되지만, 원한다면 타입을 명시적으로 작성할 수 있다.
    // ex) var number1: Long = 10L
    //     val number2: Long = 10L

    var number5: Long
    number5 = 3
    println(number5)    // 15번째 줄 number5 = 3을 주석친다면(값을 초기화해주지않으면) 컴파일 에러 발생

    val number6: Long
    number6 = 4
    println(number6)

    // 코드를 클린하게 만들기 위해
    // 모든 변수는 우선 val로 만들고 꼭 필요한 경우 var로 변경하자!(디버깅하기도 쉬워짐)

    var number3 = 1_000L // 자바에서 long은 primitive type, Long은 reference type으로 구분하지만 코틀린에서는 그런 구분이 없음

    var number7: Long? = 3_000L // 코틀린에서 null이 변수에 들어갈 수 있다면 "타입?"를 사용해야한다.
    number7 = null              // 코틀린은 변수를 만들어줄 때 변수에 null이 들어갈수 있는지 없는지를 표시해줘야함.

    var penson = Person("박꿀꿀") // 코틀린에서 객체 인스턴스화를 할 때에는 new를 붙이지 않아야 한다.
}


// Lec 01. 코틀린에서 변수를 다루는 방법
// 1. 모든 변수는 var / val을 붙여 주어야 한다.
// - var : 변경 가능하다 / val : 변경 불가능하다(read-only)
// 2. 타입을 명시적으로 작성하지 않아도, 타입이 추론된다.
// 3. Primitive Type과 Reference Type을 구분하지 않아도 된다.
// 4. Null이 들어갈 수 있는 변수는 타입 뒤에 ?를 붙여주어야 한다.
// - 아예 다른 타입으로 간주된다.
// 5. 객체를 인스턴스화 할 때 new를 붙이지 않아야 한다.