package lec08;

public class Lec08jMain {

    // Java에서 두 정수를 받아 더 큰 정수를 반환하는 예제
    public int max(int a, int b) {
        if( a > b) {
            return a;
        }
        return b;
    }

    // Java에서 주어진 문자열을 N번 출력하는 예제
    public void repeat(String str, int num, boolean useNewLine) {
        // 주어진 문자열, 몇 번 출력할지, 출력을 할 때에 엔터(개행)를 쳐주냐 쳐주지 않냐
        for (int i = 1; i <= num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.println(str);
            }
        }
    }

    // 자바의 OverLoading
    public void repeat(String str, int num) {
        repeat(str, num, true);
    }

    // 많은 코드에서 출력을 3회씩 사용하고 있다면? -> 다시 한 번 오버로딩. 총 3개의 repeat 함수가 존재하게 됨.
    public void repeat(String str) {
        repeat(str, 3, true);
    }

    // 하지만 위의 Java 코드에는 한 가지 슬픈 사실이 있음. -> 메소드를 3개나 만들어야 하나?
    // 이런 생각에 Kotlin에서는 default parameter라는게 존재.

    // Java에서 문자열을 N개 받아 출력하는 예제(가변인자)
    public static void printAll(String... strings) {
        // String 타입의 N개의 parameter를 받고, 들어온 parameter는 strings라는 이름으로 들어온다는 의미.
        // 타입...을 쓰면 Java에서는 가변인자를 쓰는구나 하고 이해하면 됨.
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        String[] array = new String[]{"A", "B", "C"};
        printAll("A", "B", "C"); // comma를 이용해 여러 파라미터를 넣거나
        printAll(array);    // 배열을 직접 넣거나
    }

}

