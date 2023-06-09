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
fun String.lastChar(): Char {       // String. : String 클래스를 확장하기 위해
    return this[this.length - 1]    // 함수 안에서는 this를 통해 불려진 인스턴스에 접근이 가능하게 됨.
}
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
//fun Person.nextYearAge(): Int {
//    println("확장 함수")
//    return this.age + 1
//}
//
//fun main() {
//    val person = Person("박꿀꿀", 34)
//    println(person.nextYearAge())
//}
// -> 멤버 함수가 출력된 걸 확인할 수 있음.
// - 확장 함수와 멤버 함수의 시그니처가 동일하면 멤버 함수가 우선적으로 호출된다.
// Q3) 확장 함수를 만들었지만, 다른 기능의 똑같은 멤버 함수가 생기면?
// -> 오류가 발생할 수 있다.
// Q4) 확장 함수가 오버라이드 된다면?
//open class Train(
//    val name: String = "새마을기차",
//    val price: Int = 5_000
//)
//
//fun Train.isExpensive(): Boolean {
//    println("Train의 확장함수")
//    return this.price >= 10000
//}
//
//class Srt: Train("SRT", 40_000)
//
//fun Srt.isExpensive(): Boolean {
//    println("Srt의 확장함수")
//    return this.price >= 10000
//}
//
//fun main() {
//    val train: Train = Train()
//    train.isExpensive() // Train의 확장 함수
//
//    val srt1: Train = Srt()
//    srt1.isExpensive()  // Train의 확장 함수
//
//    val srt2: Srt = Srt()
//    srt2.isExpensive()  // Srt의 확장 함수
//    // 해당 변수의 현재 타입. 즉, 정적인 타입에 의해 어떤 확장함수가 호출될지 결정된다.
//}

// 확장함수
// 1) 확장함수는 원본 클래스의 private, protected 멤버 접근이 안된다.
// 2) 멤버함수, 확장함수 중 멤버함수에 우선권이 있다.
// 3) 확장함수는 현재 타입을 기준으로 호출된다.
// 4) 확장함수라는 개념은 확장 프로퍼티와도 연결된다.
// - 원리는 확장함수와 custom getter를 섞어놓은 것 처럼 생겼다.

// Q) Java에서 Kotlin 확장함수를 가져다 사용할 수 있나?
// -> 가능.

// 2. infix 함수
// 중위함수. 함수를 호출하는 새로운 방법
// 보통 방식 : 변수.함수이름(argument)
// 보통 방식 대신 변수 함수이름 argument 방식 사용(변수와 argument가 각각 하나씩만 있는 경우)

//fun Int.add(other: Int): Int {  // add라는 확장함수.
//    return this + other
//}
//
//infix fun Int.add2(other: Int): Int { // add2라는 확장함수. 앞에 infix가 붙으면 호출 방식을 다르게 할 수 있음.
//    // infix는 멤버함수에도 붙일 수 있다.
//    return this + other
//}
//
//fun main() {
//    println(3.add(4))           // add함수를 사용하는 일반적인 방법
//    println(3.add2(4))    // add2함수를 사용하는 일반적인 방법
//    println(3 add2 4)           // add2함수를 부르는 새로운 방법(infix가 앞에 붙어 있기에 가능)
//}

// 3. inline 함수
// - 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우에 사용
//fun main() {
//    3.add(4)
//    println(3.add(4))
//}
//
//inline fun Int.add(other: Int): Int {
//    return this + other
//}
// 사용하는 이유 : 함수를 파라미터로 전달할 때에 오버헤드(over head)를 줄일 수 있다.
// ex) 함수를 계속 중첩해서 사용하는 경우에는 이 함수가 다시 또 다른 함수를 부르고
//     또 다른 함수를 부르면 그 함수 call chain에 overhead가 생기다보니
//     이것을 줄이기 위해서 inline을 사용.
// but, inline 함수의 사용은 성능 측정과 함께 신중하게 사용되어야 한다.
// (코틀린 라이브러리에서는 최적화를 어느정도 해뒀기 때문에 적절하게 inline 함수가 붙어 있다)

// 4. 지역 함수
// - 함수 안에 함수를 선언할 수 있다.
//fun createPerson(firstName: String, lastName: String): Person {
//    if (firstName.isEmpty()) {
//        throw IllegalArgumentException("firstName은 비어있을 수 없습니다. 현재 값 : $firstName")
//    }
//
//    if (lastName.isEmpty()) {
//        throw IllegalArgumentException("lastName은 비어있을 수 없습니다. 현재 값 : $lastName")
//    }
//
//    return Person(firstName, lastName, 1)
//}
// 위의 코드는 두 군데 중복되는 코드가 있음. 지역함수 기능을 이용해서 아래처럼 리펙토링 가능
fun createPerson(firstName: String, lastName: String): Person {
    fun validateName(name: String, fieldName: String) {
        // validateName이라는 것 자체를 함수 안의 함수(fun 안에 fun)를 만든 다음
        // 위의 중복된 부분을 제거해서 validateName이라는 하나의 함수를 만들어 이 함수를 호출하게끔 함.
        if (name.isEmpty()) {
            throw IllegalArgumentException("${fieldName}은 비어있을 수 없습니다. 현재 값 : $name")
        }
    }
    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 1)
}
// 함수로 추출하면 좋을 것 같은데, 이 함수를 지금 함수 내에서만 사용하고 싶을 때 사용할 수 있음.
// but, depth(깊이)가 깊어지기도 하고, 코드가 그렇게 깔끔하지도 않다..
// 이런 코드 같은 경우 Person을 만들어 주는 쪽에서 이런 private validation 코드를 가지고 있고
// Person 클래스에서 검증해주는 것이 훨씬 깔끔하다. -> 지역함수 역시 많이 쓰진 않음

// Lec 16. 코틀린에서 다양한 함수를 다루는 방법
// 1. Java 코드가 있는 상황에서, Kotlin 코드로 추가 기능 개발을 하기 위해 확장함수와 확장프로퍼티가 등장했다.
// - fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
//       // this를 이용해 실제 클래스 안의 값에 접근
//   }
// 2. 확장함수는 원본 클래스의 private, protected 멤버 접근이 안된다.
// 3. 멤버함수, 확장함수 중 멤버함수에 우선권이 있다.
// 4. 확장함수는 현재 타입을 기준으로 호출된다.
// 5. Java에서는 static 함수를 쓰는 것처럼 Kotlin의 확장함수를 쓸 수 있다.
// 6. 함수 호출 방식을 바꿔주는 infix 함수가 존재한다. (a.함수이름(b)가 아니라 a 함수이름 b로)
// 7. 함수를 복사-붙여넣기 하는 inline 함수가 존재한다.
// 8. Kotlin에서는 함수 안에 함수를 선언할 수 있고, 지역함수라고 부른다.

