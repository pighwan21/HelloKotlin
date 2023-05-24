package lec07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JavaFilePrinter {
    // Java에서 프로젝트 내 파일의 내용물을 읽어오는 예제
    public void readFile() throws IOException {
        File currentFile = new File(".");   // "." <- 현재 위치를 의미
        File file = new File(currentFile.getAbsolutePath() + "/a.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println(reader.readLine());
        reader.close();
        // close 구문이나 read line구문, FileReader를 만드는 구문은 IOException을 내뱉음.
        // IOException : 체크 예외.
        // 반드시 위의 메소드를 사용할 경우에는 체크 예외가 날 수 있다는 표시를 해줘야 함.
    }
}
