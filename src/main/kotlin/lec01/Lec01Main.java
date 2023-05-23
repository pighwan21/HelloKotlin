package lec01;

public class Lec01Main {
    public static void main(String[] args) {
        long number1 = 10L; // (1) long type 변수를 만드는 코드
        final long number2 = 10L; // (2) 동일하지만 앞에 final이 붙어 있는 코드
        // Java에서 long과 final long의 차이 -> 이 변수는 가변인가, 불변인가(read-only)

        Long number3 = 1_000L; // (3) Long type. 객체의 타입이 변수
        Person person = new Person("박꿀꿀"); // (4) Person 이라는 직접 만든 클래스의 변수
    }
}