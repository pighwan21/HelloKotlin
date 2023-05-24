package lec06;

import java.util.Arrays;
import java.util.List;

public class Lec06jMain {
    public static void main(String[] args) {
        // Java에서 숫자가 들어 있는 리스트를 하나씩 출력하는 예제
        List<Long> numbers = Arrays.asList(1L, 2L, 3L);
        for (long number : numbers) {
            System.out.println(number);
        }

        // Java에서 1부터 3까지 출력하는 예제(올라가는)
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
        }

        // Java에서 3부터 1까지 출력하는 예제(내려가는)
        for (int i = 3; i >= 1; i--) {
            System.out.println(i);
        }

        // Java에서 2칸씩 올라가는 경우 출력
        for (int i = 1; i <= 5; i+=2) {
            System.out.println(i);
        }

        // Java에서 1부터 3을 출력하는 while문
        int i = 1;
        while (i <= 3) {
            System.out.println(i);
            i++;
        }
    }
}


