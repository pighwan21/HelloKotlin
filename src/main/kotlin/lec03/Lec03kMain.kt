package lec03

// Lec 03. 코틀린에서 Type을 다루는 방법
// 1. 기본 타입
// 2. 타입 캐스팅
// 3. Kotlin의 3가지 특이한 타입
// 4. String Interpolation, String indexing

// 1. 기본 타입
// Byte, Short, Int, Long, Float, Double, 부호 없는 정수들
// 코틀린에서는 선언된 기본값을 보고 타입을 추론한다.
// val number1 = 3    // Int
// val number2 = 3L   // Long
// val number3 = 3.0f // Float
// val number4 = 3.0  // Double
// Java와 다른 내용 - java : 기본 타입 간의 변환은 암시적으로 이루어질 수 있다.
//                  kotlin : 기본 타입 간의 변환은 명시적으로 이루어져야 한다.

//fun main() {
//    val number1: Int = 3
////    val number2: Long = number1 // 에러
//    val number2: Long = number1.toLong() // .toLong()을 이용해 명시적으로 Long타입으로 바꿔줌
//    println(number1 + number2)
//
//    // 변수가 nullable이라면 적절한 처리가 필요하다.
//    val number3: Int? = 4
//    val number4: Long = number3?.toLong() ?: 0
//}

// 2. 타입 캐스팅
//fun main() {
//    printAgeIfPerson(Person("", 100))
//}
//
//fun printAgeIfPerson(obj: Any?) {
////    if(obj is Person) {             // is : java의 instanceof와 같음. !is로 아니라면~ 으로도 사용가능
////                                      !is : not is
////        val person = obj as Person  // as : java의 (타입)
////        println(person.age)
////        println(obj.age)            // 로 smart cast 가능.
////    }
//    val person = obj as? Person
//    println(person?.age)
//
//    // value is Type - value가 Type이면 true
//    //               - value가 Type이 아니면 false
//
//    // value !is Type - value가 Type이면 false
//    //                - value가 Type이 아니면 true
//
//    // value as Type  - value가 Type이면 Type으로 타입 캐스팅
//    //                - value가 Type이 아니면 예외발생(ClassCastException)
//
//    // value as? Type - value가 Type이면 Type으로 타입 캐스팅
//    //                - value가 null이면 null
//    //                - value가 Type이 아니면 null
//}

// 3. Kotlin의 특이한 타입 3가지
// 1) Any
// 2) Unit
// 3) Nothing
// 4) String interpolation / String indexing

// 1) Any
// - Java의 Object 역할. (모든 객체의 최상위 타입)
// - 모든 Primitive Type의 최상의 타입도 Any이다.
//  (Java의 경우 Primitive Type은 Object가 최상위 타입이 아님)
//  (코틀린에서는 Primitive Type과 Reference Type 구분 없이 Int, Long을 쓰기 때문에
//   Primitive Type에 대해서도 최상위 Type이 Any로 간주된다.)
// - Any 자체로는 null을 포함할 수 없어 null을 포함하고 싶다면, Any?로 표현(진짜 최상위는 Any?로 볼수있음)
// - Any에 equals / hashCode / toString 존재.(자바에서는 Object에 equals, hashCode, toString이 존재)
//  (shift2번 눌러서 Any.kt에 들가보셈)
//  (Java의 Object 클래스가 Kotlin의 Any클래스구나~ 하고 생각하면 됨)

// 2) Unit
// - Java의 void와 동일한 역할(타입 추론이 가능하기에 생략 가능)
// - void와 다르게 Unit은 그 자체로 타입 인자로 사용가능.(제네릭에서)
// - 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미. 즉, 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현

// 3) Nothing
// - 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
// - 무조건 예외를 반환하는 함수나 무한 루프 함수 등에 사용(실제 코딩에서 많이 쓰지 않음)
// fun fail(message: String): Nothing {
//   throw IllegalArgumentException(message)
// }

// 4) String interpolation / String indexing
fun main() {
//    val person = Person("박꿀꿀", 34)
//    val log = "사람의 이름은 ${person.name}이고 나이는 ${person.age}세 입니다."
//    // ${변수}를 사용하면 값이 들어간다.
//    println(log)

//    {}(중괄호)를 생략할 수도 있다 -> $변수를 사용할 수도 있다.
    val name = "왕돼지"
    val age = 34
    val log = "사람의 이름: $name 나이: $age"
    println(log)
// 변수 이름만 사용하더라도 ${변수}를 사용하는 것이 가독성, 일괄 변환, 정규식 활용 측면에서 더 좋다.

//    여러 줄에 걸친 문자열을 작성해야 할 때 큰 따옴표 세 개(""")를 쓰면 좀더 편하게 할 수 있다.
    val nickName = "왕돼지콧구멍"
    val withoutIndent =
        """
            king
            pig
            ${nickName}
        """.trimIndent()
    println(withoutIndent)

//    문자열에서 특정 문자를 가져오는 것도 Java와 차이가 있음 -> 마치 Java의 배열처럼 대괄호를 통해서
    val str = "ABCDE"
    val ch = str[1]
    println(ch)
    println(str[0])
    println(str[2])
}

// Lec 03. 코틀린에서 Type을 다루는 방법
// 1. 코틀린의 변수는 초기값을 보고 타입을 추론하며, 기본 타입들 간의 변환은 명시적으로 이루어진다.
// 2. 코틀린에서는 is, !is, as, as?를 이용해 타입을 확인하고 캐스팅한다.
// 3. 코틀린의 Any는 Java의 Object와 같은 최상위 타입이다.
// 4. 코틀린의 Unit은 Java의 void와 동일하다.
// 5. 코틀린에 있는 Nothing은 정상적으로 끝나지 않는 함수의 반환을 의미한다.
// 6. 문자열을 가공할 때 ${변수}와 """ """를 사용하면 깔끔한 코딩이 가능하다.
// 7. 문자열에서 문자를 가져올때는 Java의 배열처럼 []를 사용한다.