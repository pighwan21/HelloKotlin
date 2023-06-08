package lec16

// Lec 16. 코틀린에서 다양한 함수를 다루는 방법
// 1. 확장 함수
// 2. infix 함수
// 3. inline 함수
// 4. 지역 함수

// 1. 확장 함수
// [확장 함수가 나오게 된 배경]
// Kotlin은 Java와 100% 호환하는 것을 목표로 하고 있다.
// 기존 Java 코드 위에 자연스럽게 Kotlin 코드를 추가할 수는 없을까 하는 고민을 하게 됨.
// 코틀린 코드를 추가로 쌓을 수 있게 되면 Java 코드는 그대로 둔 상태로 추가적인 기능을 만들 때
// val, var 혹은 null-safety 같은 코틀린 특성을 사용할 수 있을테니.
// Java로 만들어진 라이브러리를 유지보수, 확장할 때 Kotlin 코드를 덧붙이고 싶어 라는 니즈가 생기게 됨.
// 어떤 클래스 안에 있는 메소드처럼 호출할 수 있지만, 함수는 밖에 만들 수 있게 하자는 개념이 나옴.
// (함수의 코드 자체는 클래스 밖에 있는데, 마치 클래스 안에 있는 멤버함수처럼 호출해서 쓰는 것)

// 문자열의 가장 끝에 있는 문자를 가져오는 기능의 코드.
//fun String.lastChar(): Char {       // String. : String 클래스를 확장하기 위해
//    return this[this.length - 1]    // 함수 안에서는 this를 통해 불려진 인스턴스에 접근이 가능하게 됨.
//}
// 위의 코드 정리
// fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {      // 확장하려는 클래스 : 수신객체 타입
//   // this(수신객체)를 이용해 실제 클래스 안의 값에 접근
// }

//fun main() {
//    val str = "ABC"
//    str.lastChar()
//    // lastChar(str) 이런 식으로 함수를 호출하는 게 아니라
//    // 그냥 멤버 함수인 것처럼 str에 있는 것처럼 사용하게 됨.
//    println(str)
//    println(str.lastChar())
//}
// Q1) 확장함수가 public이고 확장함수에서 수신객체클래스의 private 함수를 가져오면 캡슐화가 깨지는 것이 아닌가?
// -> 확장함수는 클래스에 있는 private 또는 protected 멤버를 가져올 수 없다.
// Q2) 멤버함수와 확장함수의 시그니처가 같다면?
fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

fun main() {
    val person = Person("박꿀꿀", 34)
    println(person.nextYearAge())
}
// -> 멤버 함수가 출력된 걸 확인할 수 있음.
// - 확장 함수와 멤버 함수의 시그니처가 동일하면 멤버 함수가 우선적으로 호출된다.
// Q3) 확장 함수를 만들었지만, 다른 기능의 똑같은 멤버 함수가 생기면?
// -> 오류가 발생할 수 있다.
// Q4) 확장 함수가 오버라이드 된다면?
open class Train(
    val name: String = "새마을기차",
    val price: Int = 5_000
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return this.price >= 10000
}

class Srt: Train("SRT", 40_000)

fun Srt.isExpensive(): Boolean {
    println("Srt의 확장함수")
    return this.price >= 10000
}

// ->
