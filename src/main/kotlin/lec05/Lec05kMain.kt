package lec05

// Lec 05. 코틀린에서 조건문을 다루는 방법
// 1. if문
// 2. Expression과 Statement
// 3. switch와 when

// 1. if문
// if (조건) { }          // java와 동일

// if문
fun validateScoreIsNotNegative(score: Int) {
    // 함수에서 Unit(void)이 생략됨, 함수 만들 때 fun을 사용
    if(score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    // Exception을 던질 때 new를 사용하지 않고 예외를 던짐. 위의 두 문장을 제외하고 java와 차이가 없음
    }
}

// else가 있는 if문
fun getPassOrFail(score: Int): String {
    if (score >= 50) {  // if에 마우스를 갖다대면 "Lift return out of 'if'"라는 문장이 뜨고 클릭하면 아래와 같이 코드가 리펙토링됨.
                        // return을 앞에 붙여서 중복된 return을 제거할 수 있다는 뜻.
        return "P"
    } else {
        return "F"
    }
}
// but, Java에서 if-else는 Statement이지만, Kotlin에서는 Expression이다.
// Statement : 프로그램의 문장 전체를 의미. 하나의 값으로 도출되지 않는다.
// Expression : 반드시 하나의 값으로 결과가 도출되는 문장.

// 따라서 코틀린에서는 위의 else가 있는 if문을 아래와 같이 리펙토링 할 수 있음
fun getPassOrFail2(score: Int): String {
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}
// Kotlin에서 if-else는 Expression이기 때문에 가능. 마치 Java에서 3항 연산자를 통해 바로 값을 계산해서 return 하는 것처럼.
// Kotlin에서는 if-else를 expression으로 사용할 수 있기 때문에 3항 연산자가 없다.(불필요하기에 삭제됨)

// if - else if - else 문도 문법이 동일
fun getGrade(score: Int): String {
    if ( score >= 90) {
        return "A";
    } else if (score >= 80) {
        return "B";
    } else if (score >= 70) {
        return "C";
    } else {
        return "D";
    }
}
// 마찬 가지로 리펙토링하면 아래와 같이 return의 중복을 줄일 수 있음
fun getGrade2(score: Int): String {
    return if ( score >= 90) {
        "A";
    } else if (score >= 80) {
        "B";
    } else if (score >= 70) {
        "C";
    } else {
        "D";
    }
}

// 간단한 Tip. 어떠한 값이 특정 범위에 포함되어 있는지, 포함되어 있지 않은지
// java의 겨우 : if (0 <= score && score <= 100) {
// kotlin의 경우 : if (score in 0..100) {

fun validateScoreIsNotNegative2(score: Int) {
    // 함수에서 Unit(void)이 생략됨, 함수 만들 때 fun을 사용
    if(score !in 0..100) {  // score라는  값이 0부터 100 사이에 있지 않으면
        throw IllegalArgumentException("score의 범위는 0부터 100입니다.")
        // Exception을 던질 때 new를 사용하지 않고 예외를 던짐. 위의 두 문장을 제외하고 java와 차이가 없음
    }
}

// score가 0부터 100 사이에 있는 것을 확인 하고 싶을 때
fun validateScore(score: Int) {
    // 함수에서 Unit(void)이 생략됨, 함수 만들 때 fun을 사용
    if(score in 0..100) {  // score라는  값이 0부터 100 사이에 있으면
        val score2 = 70
     }
}

// 3. switch와 when
// Kotlin에서는 switch~case문이 사라졌음. 대신 이를 대체할 when이 생김
// - switch가 들어갈 자리에 when을 써줌. 그 다음 똑같이 괄호, 중괄호.
// when (값) {            // 값 : 값이 없을 수도 있다. - early return처럼 동작.
//   조건부 -> 어떠한 구문  // 조건부 : 어떠한 expression이라도 들어갈 수 있다.(ex: is Type)
//   조건부 -> 어떠한 구문  //         여러개의 조건을 동시에 검사할 수도 있다.(,로 구분)
//   else -> 어떠한 구문
// }
fun getGradeWithSwitch(score: Int): String {
    return when(score / 10) {   // when 역시 하나의 Expression이기 때문에 when을 통해서 나온 결과를 바로 return할 수 있음.
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}
// 다른 점: 1) swith 대신에 when이 들어감.
//         2) case 대신에 case를 쓰지 않고 바로 그 경우를 작성해준 다음, 화살표로 분기를 침.
//         3) default 대신에 else를 사용함.

// 코틀린의 when은 좀더 다양한 사용을 할 수 있음
fun getGradeWithSwitch2(score: Int): String {
    return when (score) {   // when 역시 하나의 Expression이기 때문에 when을 통해서 나온 결과를 바로 return할 수 있음.
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}
// 코틀린의 when에서는 다양한 조건(범위나 기타 조건)을 가지고 분기를 칠 수 있다!

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int) {
    return when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("1, 0, -1이 아닙니다.")
    }
}

// when에 값이 없을 때
fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")

    }
}

// Tip. when은 Enum Class 혹은 Sealed Class와 함께 사용할 경우, 더욱더 진가를 발휘한다.(나중에 배울 것)

// Lec 05. 코틀린에서 조건문을 다루는 방법
// 1. if / if - else / if - else if - else 모두 Java와 문법이 동일하다.
// 2. 단 Kotlin에서는 Expression으로 취급된다.
// - 때문에 Kotlin에서는 삼항 연산자가 없다.
// 3. Java의 switch는 Kotlin에서 when으로 대체되었고, when은 더 강력한 기능을 갖는다.