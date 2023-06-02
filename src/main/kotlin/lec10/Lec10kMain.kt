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
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직입니다~ 뿌우")
    }

    override val legCount: Int  // Animal에 있는 legCount는 final이라서 override 할 수 없다는 에러가 뜸
                                // Animal의 legCount 부분에 open을 붙여줘야함.
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act()
        // Java와의 차이점 : 특정 상위 인터페이스의 함수를 override할 때 문법이 좀 다름.
        // Kotlin에서는 super 뒤에 꺽쇄로 타입을 표현하고 그 다음 함수를 불러줌.
    }

    override fun fly() {
        println("날아올라~")
    }
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
    fun act() {
        println("어푸 어푸")
    }
}
