package lec08

// Lec 08. 코틀린에서 함수를 다루는 방법
// 1. 함수 선언 문법
// 2. default parameter
// 3. named argument(parameter)
// 4. 같은 타입의 여러 파라미터 받기(가변인자)

// 1. 함수 선언 문법
//fun max(a: Int, b: Int): Int {
//    if (a > b) {
//        return a
//    } else {
//        return b
//    }
//}
// 위의 코드를 리펙토링 하면 다음과 같다.
//fun max(a: Int, b: Int): Int {
//    return if (a > b) {
//        a
//    } else {
//        b
//    }
//}
// 여기서 한번더 리팩토링 하면 다음과 같다.
//public fun max(a: Int, b: Int): Int =
//    // public : 접근 지시어. 생략 가능 / fun : 함수를 의미하는 키워드 / max : 함수 이름(접근 지시어)
//    // (a: Int, b: Int) : 함수의 매개변수(매개변수명: 타입) / : Int : 함수의 반환 타입(Unit인 경우 생략 가능)
//    // = : 함수가 하나의 결과값이면 block 대신 = 사용 가능
//    // (블록 안에서의 return은 이걸 반환한다는 의미인데 = 은 '이 함수는 이거야' 라는 의미.
//    if (a > b) {
//        a
//    } else {
//        b
//    }
// 또 리팩토링 가능함 ㅋㅋㅋㅋㅋㅋ
fun max(a: Int, b: Int) = if (a > b) a else b // 한 줄로 변경 가능
// 타입이 생략가능한 문법적 이유는 함수를 쓸 때 중괄호 대신 =을 썼기 때문.
// 그래서 반환타입의 생략이 가능해짐.
// block({}, 중괄호) 을 사용하는 경우에는 반환 타입이 Unit이 아니면, 명시적으로 작성해주어야함!

// Tip. 함수는 클래스 안에 있을 수도, 파일 최상단에 있을 수도 있다.
//      또한, 한 파일 안에 여러 함수들이 있을 수도 있다.

// 2. default parameter
fun repeat(
    str: String,
    num: Int = 3,   // = 값 : 이 값이 기본값이 됨. 여기서는 3이 기본값이 됨.
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

//fun main() {
//    repeat("Hello Pig")
//}

// 밖에서 파라미터를 넣어주지 않으면 기본값을 사용하자!
// 물론, Kotlin에도 Java와 동일하게 오버로드 기능은 있다.

// 3. named argument(parameter) : 이름있는 argument파라미터
// 위의 코드에서 "Hello Pig", false를 주고 싶을 때(num은 그대로 기본값을 쓰고)
//fun main() {
//    repeat("Hello Pig", useNewLine = false)
//    // useNewLine = false : 매개변수 이름을 통해 직접 지정. 지정되지 않은 매개변수는 기본값 사용
//}
// 이 기능의 장점 : builder를 직접 만들지 않고 builder의 장점을 가지게 된다.
//fun main() {
//    printNameAndGender(name = "박꿀꿀", gender = "남자")
//}
//
//fun printNameAndGender(name: String, gender: String) {
//    println(name)
//    println(gender)
//}
// 주의할 점 : Kotlin에서 Java함수를 가져다 사용할 때는 named argument를 사용할 수 없다.
// - 코틀린에서 Java 코드를 쓸 때 JVM 상에서 Java가 바이트 코드로 변환됐을 때
//   parameter 이름을 보존하고 있지 않기 때문.

// 4. 같은 타입의 여러 파라미터 받기(가변인자)
fun main() {
    // comma로 구분하는 경우 : Java와 사용법은 동일
    printAll("A", "B", "C") // comma로 구분하는 경우에는 Java와 같음.

    // 배열을 쓰는 경우
    val array = arrayOf("A", "B", "C")
    printAll(*array)  // * spread(스프레드) 연산자. 배열 안에 있는 것들을 마치 그냥 ,(comma)를 쓰는 것처럼 꺼내준다.
//                       배열을 바로 넣는 대신 스프레드 연산자(*)를 붙여주어야 한다.
}

fun printAll(vararg strings: String) {
    // vararg : 발알규먼트. ...을 타입 뒤에 쓰는 Java와 달리 제일 앞에 vararg를 적어주어야한다.
    for (str in strings) {
        println(str)
    }
}

// Lec 08. 코틀린에서 함수를 다루는 방법
// 1. 함수의 문법은 Java와 다르다
// - 접근지시어 fun 함수이름(파라미터): 반환타입 {}
// 2. body가 하나의 값으로 간주되는 경우 block을 없앨 수도 있고, block이 없다면 반환 타입을 없앨 수도 있다.
// - fun max(a: Int, b: Int): Int = if (a > b) a else b
// -> fun max(a: Int, b: Int) = if (a > b) a else b
// 3. 함수 파라미터에 기본값을 설정해줄 수 있다.
// 4. 함수를 호출할 때 특정 파라미터를 지정해 넣어줄 수 있다.
// 5. 가변인자에는 vararg 키워드를 사용하며, 가변인자 함수를 배열과 호출할 때는 *(spread 연산자) 를 붙여주어야 한다.