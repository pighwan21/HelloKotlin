package lec02

// Lec 02. 코틀린에서 null을 다루는 방법
// 1. Kotlin에서의 null 체크
// 2. Safe Call과 Elvis 연산자
// 3. 널 아님 단언!!
// 4. 플랫폼 타입
fun main(args: Array<String>) {

    val str: String? = "pig"
    println(str?.length)

    val str2: String? = "king"
    println(str2?.length ?: 0)

    println(startsWithA4("A")) // null이 들어갈 경우 컴파일 에러는 안나지만 런타임에서 nullPointException이 발생

    val person = Person("공부하는 창환이") // 자바 Person을 가져왔음
    startsWithA5(person.name) // @Nullable인 경우 빨간줄, @NotNull일 때는 사용 가능
                              // 어노테이션 정보가 없다면 컴파일에러가 아닌 런타임 오류가 발생(NullPointException)
}

fun startsWithA0(str: String): Boolean {
    return str.startsWith("A")
} // Kotlin에서는 null이 가능한 타입을 완전히 다르게 취급한다!

// null이 들어갈 수 없는 boolean이 반환
fun startsWithA1(str: String?): Boolean {
//    if(str == null) {
//        throw IllegalArgumentException("null이 들어왔습니다.")
//    }
//    return str.startsWith("A")

    // Safe Call(?.)과 Elvis 연산자(?:)를 사용한 리펙토링
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다")
}

// null이 들어갈 수 있는 Boolean이 반환
fun startsWithA2(str: String?): Boolean? { // null이 들어갈 수 있는 Boolean type이기에 ?를 붙여줌
//    if(str == null) {
//        return null
//    }
//    return str.startsWith("A")

    // Safe Call(?.)과 Elvis 연산자(?:)를 사용한 리펙토링
    return str?.startsWith("A")
}

// null이 들어갈 수 없는 boolean이 반환
fun startsWithA3(str: String?): Boolean { // 들어오는 파라미터는 null일 수 있고, 나가는 리턴타입은 null일 수 없음
    // str.startsWith("A") 를 바로 쓸 경우 위의 str:String?과 다른 타입으로 간주되어 컴파일 에러
//
//    if(str == null) {
//        return false
//    }
//    return str.startsWith("A") // 코틀린은 이 문맥상 위에서 null을 한 번 체크해주면
//                                     // 아래에서 null이 아니겠거니 하고 컴파일러가 자동으로 추측해줌

    // Safe Call(?.)과 Elvis 연산자(?:)를 사용한 리펙토링
    return str?.startsWith("A") ?: false
}

// null이 가능한 타입만을 위한 기능은 없나?! -> Safe Call, Elvis 연산자

// 1. Safe Call(안전한 호출) : null이 아니면 실행하고, null이면 실행하지 않는다(그대로 null)
// val str: String? = "ABC"
// str.length // 불가능
// str?.length // 가능
// ?. : null이 아니면 뒤에 딸려오는 함수나 프로퍼티 등을 실행시키고, 그게 아니면 이 값 그대로가 null이 된다.

// 2. Elvis 연산자 : 앞의 연산 결과가 null이면 뒤의 값을 사용
// val str: String? = "ABC"
// str?.length ?: 0
// ?: 연산결과가 null이면 뒤의 값을 사용

// 예시(자바 -> 코틀린. Elvis 연산자를 이용하면 if문을 안쓰고도 early return이 가능)
// public long calculate(Long number) {
// if(number == null) {
//   return 0;
// }
// // 다음 로직
// }

// fun calculate(number: Long?): Long{
//   number ?: return 0
// // 다음 로직
// }

// 3. 널 아님 단언!!(!!) : nullable type이지만, 아무리 생각해도 null이 될 수 없는 경우
fun startsWithA4(str: String?): Boolean {
    return str!!.startsWith("A")
}

// 4. 플랫폼 타입 : Kotlin에서 Java 코드를 가져다 사용할 때 어떻게 처리될까?
fun startsWithA5(str: String): Boolean {
    return str.startsWith("A")
}

// Lec 02. 코틀린에서 null을 다루는 방법
// 1. 코틀린에서 null이 들어갈 수 있는 타입은 완전히 다르게 간주된다.
// - 한번 null 검사를 하면 non-null임을 컴파일러가 알 수 있다.
// 2. null이 아닌 경우에만 호출되는 Safe Call(?.)이 있다.
// 3. null인 경우에만 호출되는 Elvis 연산자(?:)가 있다.
// 4. null이 절대 아닐 때 사용할 수 있는 널 아님 단언(!!)이 있다.
// 5. Kotlin에서 Java 코드를 사용할 때 플랫폼 타입 사용에 유의해야 한다.
// - Java 코드를 읽으면 Null 가능성 확인 // Kotlin으로 wrapping