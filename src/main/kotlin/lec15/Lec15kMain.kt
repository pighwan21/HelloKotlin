package lec15

// Lec 15. 코틀린에서 배열과 컬렉션을 다루는 방법
// 1. 배열
// 2. 코틀린에서의 Collection - List, Set, Map
// 3. Collection의 null 가능성, Java와 함께 사용하기

// 1. 배열
// - 사실 배열은 잘 사용하지 않음.
// - Effective Java : "배열보다 리스트를 사용하라"
//fun main() {
//    var array = arrayOf(100, 200)
//
//    // 인덱스만 받아 인덱스를 통해서 배열의 값에 접근
//    // array.indices는 0부터 마지막 index까지의 Range이다.
//    for (i in array.indices) {
//        println("${i} ${array[i]}")
//    }
//
//    // 참고. 배열에 plus라는 함수를 통해서 자바에 비해 좀 더 값을 편하게 추가 할 수도 있음.
//    var a = array.plus(300)
//    println(a)
//
//    // 인덱스와 벨류를 받아 접근
//    // withIndex()를 사용하면, 인덱스와 값을 한 번에 가져올 수 있다.
//    for ((idx, value) in array.withIndex()) {
//        println("$idx $value")
//    }
//}

// 2. 코틀린에서의 Collection - List, Set, Map
// [List]
// - 컬렉션을 만들어줄 때 불변인지, 가변인지를 설정해야 한다.
// - List, MutableList, Set, MutableSet, Map, MutableMap
// - 불변 컬렉션 : 컬렉션에 element를 추가, 삭제할 수 없다.
// - 가변(Mutable) 컬렉션 : 컬렉션에 element를 추가, 삭제할 수 있다.
// - 컬렉션을 만들자마자 Collections.unmodifiableList(), Collections.unmodifiableMap() 등을 붙여준 게 불변
// - 불변 컬렉션이라 하더라도 Reference Type인 Element의 필드는 바꿀 수 있다.
//fun main() {
//    val numbers = listOf(100, 200)      // listOf<Int>(100, 200)에서 값들로 인해 타입이 추론되어 <Int> 생략.
//    val emptyList = emptyList<Int>()    // 비어 있는 리스트를 만들 때는 이 리스트에 들어올 타입이 무엇인지 명시적으로 적어주어야 함.
//    printNumbers(emptyList())           // 밑의 printNumbers 함수에서 타입 추론이 되므로 <타입>이 생략 가능.
//}
//// listOf 를 통해 '불변 리스트'를 만든다.
//// emptyList<타입>() 을 통해 비어있는 리스트를 만들 수 있다.
//private fun printNumbers(number: List<Int>) {
//
//}

//fun main() {
//    val numbers = listOf(100, 200)
//    // 가변 리스트를 만들고 싶다면 listOf() 대신 mutableListOf()를 사용하면 됨.
//    // 가변 리스트가 되면 number.add(300)과 같은 코드도 가능해짐.
//    // 기본 구현체는 ArrayList이고 기타 사용법은 Java와 동일하다.
//
//    // 하나를 가져오기
//    println(numbers.get(0))
//    println(numbers[0]) // .get을 해도 되지만, [] 대괄호를 이용해 리펙토링 가능.
//
//    println("For Each로")
//    // For Each
//    for (number in numbers) {
//        println(number)
//    }
//
//    println("전트옹적인 for문")
//    // 전통적인 for문
//    for ((index, number) in numbers.withIndex()) {
//        // withIndex 함수 : key와 value(인덱스와 그 인덱스에 있는 값)을 한 번에 가져올 수 있음.
//        println("$index $number")
//    }
//}
// 간단한 팁! 우선 불변 리스트를 만들고, 꼭 필요한 경우 가변 리스트로 바꾸자.

// [Set]
// 집합은 List와 다르게 순서가 없고, 같은 element는 하나만 존재할 수 있다.
// 자료구조적 의미만 제외하면 모든 기능이 List와 유사함.
//fun main() {
//    val numbers = setOf(100, 200)
//    // 가변 집합을 만들고 싶다면?
//    // val numbers = mutableSetOf(100, 200)
//    // 기본 구현체는 LinkedHashSet이다.
//
//    // For Each
//    for (number in numbers) {
//        println(number)
//    }
//
//    // 전통적인 For문
//    for ((index, number) in numbers.withIndex()) {
//        println("$index $number")
//    }
//}

// [Map]
// put 사용
//fun main() {
//    val oldMap = mutableMapOf<Int, String>()
//    oldMap.put(1, "MONDAY")
//    println(oldMap)
//    oldMap[1] = "SUNDAY"
//    oldMap[2] = "MONDAY"
//    println(oldMap)
//}

// mapOf 사용
//fun main() {
//    val map = mutableMapOf<Int, String>()   // 타입을 추론할 수 없어 <Int, String>으로 타입을 지정해주었다.
//    map[1] = "MONDAY"
//    map[2] = "TUESDAY"
//    mapOf(1 to "MONDAY", 2 to "TUESDAY")
//    println(map)
//    println(mapOf(1 to "MONDAY", 2 to "TUESDAY"))
//}
// Kotlin에서도 동일하게 MutableMap을 만들어 넣을 수도 있고, 정적 팩토리 메소드를 바로 활용할 수도 있다.
// 가변 Map이기 때문에 (key, value)를 넣을 수 있다.
// Java처럼 put을 쓸 수도 있고, map[key] = value를 쓸 수도 있다.
// mapOf(key to value)를 사용해 불변 map을 만들 수도 있다.

fun main() {
    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "Monday"
    oldMap[2] = "Tuesday"

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }
}

// 3. 컬렉션의 null 가능성, Java와 함께 사용하기.
// ?(물음표)의 위치가 어디냐에 따라 조금씩 미묘하게 null 가능성이 바뀜.
// 1) List<Int?>  : 리스트에 null이 들어갈 수 있지만, 리스트는 절대 null이 아님
// 2) List<Int>?  : 리스트에는 null이 들어갈 수 없지만, 리스트는 null일 수 있음
// 3) List<Int?>? : 리스트에 null이 들어갈 수도 있고, 리스트가 null일 수도 있음
// - ?(물음표) 위치에 따라 null 가능성 의미가 달라지므로 차이를 잘 이해해야함~~

// Java와 함께 사용 할 때의 주의점
// - Java는 읽기 전용 컬렉션과 변경 가능 컬렉션을 구분하지 않는다.
// - Java는 nullable 타입과 non-nullable 타입을 구분하지 않는다.




