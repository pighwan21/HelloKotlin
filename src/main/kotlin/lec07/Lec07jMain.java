package lec07;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec07jMain {
    public static void main(String[] args) throws IOException {
        JavaFilePrinter printer = new JavaFilePrinter();
        printer.readFile();
    }

    // Java에서 주어진 문자열을 정수로 변경하는 예제
    private int parseIntOrThrow(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다.", str));
        }
    }

    // Java에서 주어진 문자열을 정수로 변경하는 예제. 실패하면 null을 반환
    private Integer parseIntOrThrow2(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Java에서 프로젝트 내 파일의 내용물을 읽어오는 예제(try with resources 구문)
    public void readFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println(reader.readLine());
        }
    }
}
