package lec10

// Lec 10. 코틀린에서 상속을 다루는 방법
// 1. 추상 클래스
// 2. 인터페이스
// 3. 클래스를 상속할 때 주의할 점
// 4. 상속 관련 지시어 정리

// 1. 추상 클래스
abstract class Animal(
    protected val species: String,
    protected open val legCount: Int    // 추상 프로퍼티가 아니라면, 상속받을 때 꼭 open을 붙여야 한다.
) {
    abstract fun move()
}

class Cat(
    species: String
) : Animal(species, 4) {  // 상속을 할 때는 Java에서 extends 키워드를 사용하는 것과 달리 한칸 띄어쓰고 : 를 사용
    override fun move() {   // Java에서는 Override라는 어노테이션을 썼지만, Kotlin에서는 override라는 지시어를 사용
        println("고양이가 사뿐 사뿐 걸어가~")
    }
}

class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable { // 인터페이스 구현 역시 :을 사용한다.

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직입니다~ 뿌우")
    }

    override val legCount: Int  // Animal에 있는 legCount는 final이라서 override 할 수 없다는 에러가 뜸
                                // Animal의 legCount 부분에 open을 붙여줘야함.
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
        // Java와의 차이점 : 특정 상위 인터페이스의 함수를 override할 때 문법이 좀 다름.
        // Java의 경우 상위 인터페이스의 함수를 Override 할 때 : 인터페이스타입.super.메소드
        // Kotlin에서는 super 뒤에 꺽쇄로 타입을 표현하고 그 다음 함수를 불러줌.
    }

    override fun fly() {
        println("날아올라~")
    }

    override val swimAbility: Int
        get() = 3
}
// Java에서는 legCount에 Override가 가능하지만
// Kotlin에서는 Java와 다르게 프로퍼티를 override할 때 무조건 open을 붙여줘야함.
// Kotlin에서는 legCount에 대한 getter를 아래서 새로 override 하려고 custom getter를 활용한 프로퍼티를 만들게 되면
// "너는 override를 하려면 open이 필요해 위에서 꼭 붙여줘" 라는 말을 하게 됨.
// 공통점 : Java와 Kotlin 모두 추상 클래스는 인스턴스화 할 수 없다.

// 2. 인터페이스
interface Flyable {
    fun act() {     // default를 굳이 쓰지 않아도 default 함수를 만들 수 있음.
        println("파닥 파닥")
    }

    fun fly() // fly라는 추상 메서드. void 쓰지 않아도 되서 생략.
}

interface  Swimable {

    // backing field 없는 프로퍼티 -> 인터페이스에 초기값을 주거나, 클래스에서 오버라이드 해줌
    val swimAbility: Int
    fun act() {
        println(swimAbility)
        println("어푸 어푸")
    }
}
// 공통점 : Java, Kotlin 모두 인터페이스를 인스턴스화 할 수 없다.(인터페이스 자체를 인스턴스화 할 수 없다)
// Kotlin에서는 backing field가 없는 프로퍼티를 interface에 만들 수 있다.

// 3. 클래스를 상속할 때 주의할 점
open class Base(                // Base클래스를 다른 클래스가 상속받을 수 있게 open으로 열어줌
    open val number: Int = 100  // number라는 프로퍼티도 누군가 override할 수 있게끔 open으로 열어줌
) {
    init {                      // 초기화 블록. Base Class를 출력, number라는 값을 print
        println("Base Class")
        println(number)         // Accessing non-final property number in constructor
                                // 상위 클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는
                                // open을 피해야 한다.
    }
}

class Derived(
    override val number: Int    // number라는 프로퍼티를 override
) : Base(number) {              // Base 클래스 상속   :
    init {                      // 하위 구현체인 Derived에서 Derived Class를 출력
        println("Derived Class")
    }
}

fun main() {
    Derived(300)    // Base Class, 0, Derived Class 순으로 출력됨.
}

// 4. 상속 관련 키워드 4가지 정리
// 1) final : override를 할 수 없게 한다. default로 보이지 않게 존재한다.(다른 누군가가 상속받게 하려면 open을 붙여줘야함)
// 2) open : override를 열어 준다.(열려있는데 override를 해도 되고, 안해도 됨)
// 3) abstract : 반드시 override를 해야 한다.
// 4) override : 상위 타입을 오버라이드 하고 있다.(지시어가 아니라 키워드로서 사용함)


// Lec 10. 코틀린에서 상속을 다루는 방법
// 1. 상속 또는 구현을 할 때에 :  :를 사용해야 한다.(Java의 경우 extends, implements를 사용)
// 2. 상위 클래스 상속을 구현할 때 생성자를 반드시 호출해야 한다.
// 3. override를 필수로 붙여야 한다.
// 4. 추상 멤버가 아니면 기본적으로 override가 불가능하다.
// - open을 사용해주어야 한다.
// 5. 상위 클래스의 생성자 또는 초기화 블록에서 open 프로퍼티를 사용하면 얘기치 못한 버그가 생길 수 있다.