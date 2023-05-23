package lec02;

public class Lec02jMain {
    public static void main(String[] args) {

    }

    public boolean startsWithA0(String str) {

        return str.startsWith("A");
    } // 이 코드가 안전한 코드인가? -> No.

    // str이 null일 경우 Exception을 낸다.
    public boolean startsWithA1(String str) { // boolean : null이 들어갈 수 없는 boolean type
        if(str == null) {
            throw new IllegalArgumentException("null이 들어왔습니다");
        }
        return str.startsWith("A");
    }

    // str이 null일 경우 null을 반환한다.
    public Boolean startsWithA2(String str) { // Boolean : null이 들어갈 수 있는 Boolean type
        if(str == null) {
            return null;
        }
        return str.startsWith("A");
    }

    // str이 null일 경우 false를 반환한다.
    public boolean startsWithA3(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("A");
    }

}

// Tip
// startsWith() : 특정 문자 또는 문자열로 시작하는지 체크하는 함수
//                위의 경우 str의 시작이 A인지 체크
// endsWith() : 특정 문자 또는 문자열로 끝나는지 체크하는 함수