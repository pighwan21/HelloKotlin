package lec07

// Lec 07. 코틀린에서 예외를 다루는 방법
// 1. try catch finally 구문
// 2. Checked Exception과 Unchecked Exception
// 3. try with resources

// 1. try catch finally 구문
// - 문법 자체는 자바와 동일
// Kotlin에서 주어진 문자열을 정수로 변경하는 예제
//fun parseIntOrThrow(str: String): Int {
//    try {
//        return str.toInt()  // 기본타입간의 형변환은 toType()을 사용
//    } catch (e: NumberFormatException) {        // 타입이 뒤에 위치하고
//        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.") // new를 사용하지 않음. 포맷팅이 간결함.
//    }
//}

// Kotlin에서 주어진 문자열을 정수로 변경하는 예제. 실패하면 null을 반환
//fun parseIntOrThrow2(str: String): Int? {
//    try {
//        return str.toInt()
//    } catch (e: NumberFormatException) {
//        return null
//    }
//}
// 위의 코드를 리펙토링 하면 아래와 같다
//fun parseIntOrThrow2(str: String): Int? {
//    return try {    // try~catch도 코틀린의 if-else처럼 하나의 Expression으로 간주하기 때문에
//        str.toInt()
//    } catch (e: NumberFormatException) {
//        null
//    }
//}
// try~catch finally 역시 동일

// 2. Checked Exception과 Unchecked Exception
// - FilePrinter 참조

// 3. try with resources
// - Kotlin에는 try with resources 구문이 없다! 대신 .use를 사용하는데 이는 나중에 배울 것~

// Lec 07. 코틀린에서 예외를 다루는 방법
// 1. try catch finally 구문은 문법적으로 완전히 동일하다.
// - Kotlin에서는 try catch가 expression이다.
// 2. Kotlin에서 모든 예외는 Unchecked Exception이다.
// 3. Kotlin에서는 try with resources 구문이 없다. 대신 코틀린의 언어적 특징을 활용해 close를 호출해준다.