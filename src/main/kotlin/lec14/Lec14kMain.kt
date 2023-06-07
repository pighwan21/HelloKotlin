package lec14

// Lec 14. 코틀린에서 다양한 클래스를 다루는 방법
// 1. Data Class
// 2. Enum Class
// 3. Sealed Class, Sealed Interface

// 1. Data Class
// - class 앞에 data를 붙여주면 이걸 Data Class라 한다.
// - Data Class에서는 자동으로 equals와 hashCode와 toString을 만들어준다.
//data class PersonDto(
//    val name: String,
//    val age: Int
//    // 여기에 named argument까지 활용하면 builder pattern을 쓰는 것 같은 효과도 있음
//    // 사실상 builder, equals, hashCode, toString이 모두 있는 것.
//    // 참고로 Java에서도 JDK16부터 Kotlin의 data class 같은 record class를 도입했음.
//)
//
//fun main() {
//    val dto1 = PersonDto("박꿀꿀", 100)
//    val dto2 = PersonDto("박꿀꿀", 200)
//    println(dto1 == dto2)
//    println(dto1)
//}

// 2. Enum Class
enum class Country(
    private val code: String
) {
    KOREA("KO"),
    AMERICA("US");
}

// when은 Enum Class 혹은 Sealed Class와 함께 사용할 경우, 더욱더 진가를 발휘한다.
fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}
// Enum에 대한 분기처리를 할 때 코틀린에서는 when을 사용해서 조금 더 읽기 쉬운 코드로 바꿀 수 있음
// 컴파일러가 Country의 모든 타입을 알고 있기 때문에 다른 타입에 대한 로직, 즉 else를 아예 작성하지 않아도 된다.
// 심지어 return 하는 경우에도 아예 쓰지 않아도 괜찮음.
// Enum에 변화가 있으면 알 수 있다 <- 사라지건 빠지건 이 경우에 IDE단에서 warning을 줌.

// 3. Sealed Class, Sealed Interface
// - sealed의 뜻: 봉인을 한
// - Sealed Class가 생긴 이유 : 상속이 가능하도록 추상클래스를 만들었는데, 외부에서는 이 클래스를 상속받지 않았으면 좋겠어!!
//                            우리가 작성한 클래스만 하위 클래스가 되도록 봉인하자! 는 의미.
// - Sealed Class :
// 1) 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다. 즉, 런타임 때 클래스 타입이 추가될 수 없다.
// 2) 하위 클래스는 같은 패키지에 있어야 한다.
// 3) Enum과 다른 점 (1) 클래스를 상속받을 수 있다.
//                  (2) 하위 클래스는 멀티 인스턴스가 가능하다.

sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class Avante : HyundaiCar("아반떼", 1_000L)
class Sonata : HyundaiCar("소나타", 2_000L)
class Grandeur : HyundaiCar("그렌저", 3_000L)

// 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다. 즉, 런타임 때 클래스 타입이 추가될 수 없다!
private fun handleCar(car: HyundaiCar) {
    when (car) {
        is Avante -> TODO()
        is Grandeur -> TODO()
        is Sonata -> TODO()
    }
}

fun main() {
    handleCar(Avante())
}

// 추상화가 필요한 Entity or DTO에 sealed class를 활용.
// 참고로 JDK17에서도 Sealed Class가 추가되었음.(문법은 조금 다름)


// Lec 14. 코틀린에서 다양한 클래스를 다루는 방법
// 1. Kotlin의 Data class를 사용하면 equals, hashCode, toString을 자동으로 만들어준다.
// 2. kotlin의 Enum Class는 Java의 Enum Class와 동일하지만, when과 함께 사용함으로써 큰 장점을 갖게 된다.
// 3. Enum Class보다 유연하지만, 하위 클래스를 제한하는 Sealed Class 역시 when과 함께 주로 사용된다.


