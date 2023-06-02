package lec09

// Lec 09. 코틀린에서 클래스를 다루는 방법
// 1. 클래스와 프로퍼티
// 2. 생성자와 init
// 3. 커스텀 getter, setter
// 4. backing field

// 1. 클래스와 프로퍼티
//class Person constructor(name: String, age: Int){
//    val name = name // val name: String = name에서 생략 가능(위에 name: String이 있기에)
//    var age = age   // var age: Int = age에서 생략 가능(위에 age: Int가 있기에)
//}

// 프로퍼티 = 필드 + getter + setter
// 코틀린에서는 Java와 다르게 필드만 만들면 getter, setter를 자동으로 만들어준다.
// 따라서 Java 코드에 있는 getter와 setter를 직접적으로 쓰지 않아도 JavaPerson 클래스의 코드와 동일한 코드이다.
// 위의 코드에서 constructor는 생략 가능하므로 더 리펙토링 한다면 아래와 같다.
//class Person(name: String, age: Int){
//    val name = name // val name: String = name에서 생략 가능(위에 name: String이 있기에)
//    var age = age   // var age: Int = age에서 생략 가능(위에 age: Int가 있기에)
//}

// 또한 코틀린에서는 생성자를 만들어줄 때 동시에 프로퍼티를 선언할 수 있다. 따라서 위의 코드를 리펙토링하면 아래와 같다.
//class Person(
//    val name: String,
//    var age: Int
//) {
//}

// 여기서 바디 { } 에 아무것도 없기 때문에 또한번 생략하여 리펙토링이 가능.
//class Person(
//    val name: String,
//    var age: Int
//)

// .필드 를 통해 getter와 setter를 바로 호출할 수 있다.
//fun main() {
//    val person = Person("타이가", 21)
//    println(person.name)    // Java였다면 System.out.println(person.getName);
//    person.age = 10         // Java였다면 person.setAge(10);
//    println(person.age)
//}

// Java 클래스에 대해서도 .필드로 getter, setter를 사용한다.
//fun main() {
//    val person = JavaPerson("크리스", 18)
//    println(person.name)
//    person.age = 17
//    println(person.age)
//}

// 2. 생성자와 init
// Java 코드는 생성자에서 검증을 할 수 있었음
// 코틀린의 경우 바디 {}를 만들어주고, init이라는 특별한 블록 {}을 이용.
// init : 클래스가 초기화되는 시점에 한 번 호출되는 블록.
//class Person(
//    val name: String,
//    var age: Int
//) {
//    init {
//        if (age <= 0) {
//            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
//        }
//        println("초기화 블록")
//    }
//    constructor(name: String): this(name, 1) {// : this(name, 1)로 위에 있는 생성자를 호출.
//        println("첫 번째 부생성자")
//    }
//    constructor(): this("마키세 크리스") {  // 이 친구는 위의 constructor를 호출하고 위의 친구는 주생성자를 호출함.
//        println("두 번째 부생성자")
//        println("두 번째 부생성자의 이름은 "+this.name +"입니다.")
//    }
//}
// init(초기화) 블록은 생성자가 호출되는 시점에 호출된다.
// 값을 적절히 만들어주거나 validation 로직을 넣거나 하는 용도로 사용
//fun main() {
//    val person = Person("크리스") // Person을 클릭해보면 위에 있는 생성자로 커서가 옮겨감.
//}
// 위처럼 constructor를 만들어주면 이제 Person클래스를 이름만 놓고도 인스턴스화 할 수 있음.
// 생성자를 추가하고 싶은 경우에는 위에 있는 생성자는 그대로 두고, 아래에 constructor라는 키워드를 써서 새로운 생성자를 추가하면 됨.
// 위에 있는 생성자(primary constructor, 주생성자)는 반드시 존재해야한다.
// 단, 주생성자에 파라미터가 하나도 없다면 생략 가능.  ex) class Student
// 아래에 있는 생성자(secondary constructor, 부생성자)는 있을 수도 있고~ 없을 수도 있다.
// 주생성자가 있는 상태에서 추가적으로 생성자를 만들고 싶을 때 부생성자를 쓰기 때문.
// 부생성자 : 최종적으로 주생성자를 this로 호출해야 한다. body를 가질 수 있다.
//fun main() {
//    Person()
//}

// 사실, 코틀린에서는 기본적으로 부생성자보다는 default parameter를 권장함.
// Converting과 같은 경우 부생성자를 사용할 수 있지만, 그보다는 정적 팩토리 메소드를 추천함.
// 사실상 부생성자는 쓸 일이 거의 없음.

// 3. 커스텀 getter, setter
//class Person(
//    val name: String,
//    var age: Int
//) {
//    init {
//        if (age <= 0) {
//            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
//        }
//        println("초기화 블록")
//    }
//    constructor(name: String): this(name, 1) {// : this(name, 1)로 위에 있는 생성자를 호출.
//        println("첫 번째 부생성자")
//    }
//    constructor(): this("마키세 크리스") {  // 이 친구는 위의 constructor를 호출하고 위의 친구는 주생성자를 호출함.
//        println("두 번째 부생성자")
//        println("두 번째 부생성자의 이름은 "+this.name +"입니다.")
//    }
//
////    // 성인인지 확인하는 기능 추가(함수처럼 만드는 방법)
////    fun isAdult(): Boolean {
////        return this.age >= 20
////    }
//
//    // 다른 방법. custom getter : 마치 이 Person 클래스에 프로퍼티가 있는 것처럼 보여줌.
////    val isAdult: Boolean
////        get() {
////            return this.age >= 20
////        }
//    // 위의 코드를 리펙토링 하면 아래
//    val isAdult: Boolean
//        get() = this.age >= 20
//}
// 객체의 속성이라면 custom getter, 그렇지 않다면 함수 방법을 쓰는 것을 권장함.
// 예를 들어 isAdult는 마치 이 사람이 성인인가 라는 속성을 확인하는 것처럼 보임
// 따라서 custom getter를 쓰는 것을 권장.
// custom getter를 사용하면 자기 자신을 변형해줄 수도 있다.
// ex) name을 get할 때 무조건 대문자로 바꾸어 보자.
//class Person(
//    name: String = "왕돼지",
//    var age: Int = 1
//) {
//    val name = name
//        get() = field.uppercase()   // uppercase : 대문자로 변경
//    // name.uppercase()를 쓰면 무한루프가 발생
//    // field : 무한루프를 막기위한 예약어. 자기 자신을 가리킨다. backing field라고도 한다.
//    init {
//        if (age <= 0) {
//            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
//        }
//        println("초기화 블록")
//    }
//    val isAdult: Boolean
//        get() = this.age >= 20
//}
// 하지만 custom getter에서 backing field를 쓰는 경우는 드물다.
//class Person(
//    val name: String = "왕돼지",
//    var age: Int = 1
//) {
//    // 함수처럼 쓸 수도 있고
////    fun getUppercaseName(): String {   -> fun getUppercaseName(): String = this.name.uppercase()
////        return this.name.uppercase()
////    }
//
//    // 아까 설명했듯이 이건 프로퍼티같은 느낌이니까
//    val upperCaseName: String
//        get() = this.name.uppercase()
//    //
//    init {
//        if (age <= 0) {
//            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
//        }
//        println("초기화 블록")
//    }
//    val isAdult: Boolean
//        get() = this.age >= 20
//}

// name을 set할 때 무조건 대문자로 바꿔보기
class Person(
    name: String = "왕돼지",
    var age: Int = 1
) {
    var name = name
        set(value) {
            field = value.uppercase()
        }
    // name.uppercase()를 쓰면 무한루프가 발생
    // field : 무한루프를 막기위한 예약어. 자기 자신을 가리킨다. backing field라고도 한다.
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("초기화 블록")
    }
    val isAdult: Boolean
        get() = this.age >= 20
}
// 사실은 Setter 자체를 지양하기 때문에 custom setter도 잘 안쓴다.
// 코틀린에서는 무분별하게 setter를 사용하는 것보다 update같은 함수를 만들어서 그 안에서 값을 업데이트 시켜주는걸 좋아라함.

// Lec 09. 코틀린에서 클래스를 다루는 방법
// 1. 코틀린에서는 필드를 만들면 getter와 (필요에 따라) setter가 자동으로 생긴다.
// - 때문에 이를 프로퍼티라고 부른다.
// - 예시
// class Person(
//   val name: String = "마키세"
//   var age: Int = 1
// )
// - Person 클래스에는 name 프로퍼티와 age 프로퍼티가 있다. 라고 말할 수 있음.
// 2. 코틀린에서는 주생성자가 필수이다.
// 3. 코틀린에서는 constructor 키워드를 사용해 부생성자를 추가로 만들 수 있다.
// - 단 default parameter나 정적 팩토리 메소드를 권장한다.
// 4. 실제 메모리에 존재하는 것과 무관하게 custom getter와 custom setter를 만들 수 있다.
// 5. custom getter와 custom setter에서 무한루프를 막기위해 field라는 키워드를 사용한다.
// - 이를 backing field라고 부른다.