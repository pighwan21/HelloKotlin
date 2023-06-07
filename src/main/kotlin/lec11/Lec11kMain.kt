package lec11

// Lec 11. 코틀린에서 접근 제어를 다루는 방법
// 1. Java와 Kotlin의 가시성 제어 차이
// 2. Kotlin 파일의 접근 제어
// 3. 다양한 구성요소의 접근 제어
// 4. Java와 Kotlin을 함께 사용할 경우 주의할 점

// 1. Java와 Kotlin의 가시성 제어 차이
// 접근 제어 : public, protected, default, private
// 1) public : 모든 곳에서 접근 가능 -> 동일
// 2) protected : 같은 패키지 또는 하위 클래스에서만 접근 가능 -> 선언된 클래스 또는 하위 클래스에서만 접근 가능
// - kotlin에서는 패키지를 namespace를 관리하기 위한 용도(어떤 클래스가 어떤 패키지에 있구나~)로만 사용.
// - 가시성 제어(같은 패키지에 있으니까 너네끼리는 소통할 수 있어~)에는 사용되지 않는다.
// 3) default : 같은 패키지에서만 접근 가능 -> internal : 같은 모듈에서만 접근 가능
// - 모듈 : 한 번에 컴파일 되는 Kotlin 코드
//         (1) IDEA Module
//         (2) Maven Project
//         (3) Gradle Source Set
//         (4) Ant Task <Kotlinc>의 호출로 컴파일 파일의 집합
// - 패키지를 접근 제어로 쓰지 않다보니 아예 사라지고 internal이라는 새로운 가시성 제어 지시어가 생김.
// 4) private : 선언된 클래스 내에서만 접근 가능 -> 동일

// 코틀린에서는 패키지라는 개념을 접근 제어에 사용하지 않기 때문에
// protected에서는 패키지가 빠지고, default는 아예 사라지고
// 대신에 모듈을 접근 제어하는 기능인 internal이 새로 생겼다.
// Java의 기본 접근 지시어(아무것도 안붙였을 때)는 dafault
// Kotlin의 기본 접근 지시어는 public

// 2. Kotlin 파일의 접근 제어
// Kotlin은 .kt 파일에 변수, 함수, 클래스 여러개를 바로 만들 수 있다.(지금 내가 하는 것처럼)
// Kotlin 파일에서의 접근 제어자
// 1) public : 기본값. 어디서든 접근할 수 있다.
// 2) protected : 파일(최상단)에는 사용 불가능.
// 3) internal : 같은 모듈에서만 접근 가능.
// 4) private : 같은 파일 내에서만 접근 가능.

// 3. 다양한 구성요소의 접근 제어
// 클래스, 생성자, 프로퍼티
// 1) 클래스 안의 멤버
// (1) public : 모든 곳에서 접근 가능
// (2) protected : 선언된 클래스 또는 하위 클래스에서만 접근 가능
// (3) internal : 같은 모듈에서만 접근 가능
// (4) private : 선언된 클래스 내에서만 접근 가능

// 2) 생성자도 가시성 범위는 동일하다. 단, 생성자에 접근 지시어를 붙이려면, constructor를 써주어야 한다.
// ex) class Bus internal constructor(val price: Int)
// ex) open class Cat protected constructor ( )
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}
// 3) 프로퍼티의 가시성 범위도 동일하다. 단, 프로퍼티의 가시성을 제어하는 방법으로는...
// (1) getter, setter 한번에 접근 지시어를 정하거나
// (2) setter에만 추가로 가시성을 부여할 수 있음.

class Car(
    internal val name: String,
    private val owner: String,
    _price: Int
) {
    var price = _price
        private set
}   // 3개의 getter와 owner, _price 2개의 setter가 있는 코드

// 4. Java와 Kotlin을 함께 사용할 경우 주의할 점
// 1) Internal은 바이트 코드 상 public이 된다.
// - 때문에 Java코드에서는 Kotlin 모듈의 internal 코드를 가져올 수 있다.
// 2) Kotlin의 protected와 Java의 protected는 다르다.
// - Java는 같은 패키지의 Kotlin protected 멤버에 접근할 수 있다.

// Lec 11. 코틀린에서 접근 제어를 다루는 방법
// 1. Kotlin에서 패키지는 namespace 관리용이기 때문에 protected는 의미가 달라졌다.
// 2. Kotlin에서는 default가 사라지고, 모듈간의 접근을 통제하는 internal이 새로 생겼다.
// 3. 생성자에 접근 지시어를 붙일 때는 constructor를 명시적으로 써주어야 한다.
// 4. 유틸성 함수를 만들 때는 파일 최상단을 이용하면 편리하다.
// 5. 프로퍼티의 custom setter에 접근 지시어를 붙일 수 있다.
// 6. Java에서 Kotlin 코드를 사용할 때 internal과 protected는 주의해야 한다.