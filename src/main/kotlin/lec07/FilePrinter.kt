package lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

//class FilePrinter {
//    fun readFile() {    // Java와 달리 throws IOException을 명시하지 않아도 빨간 줄이 뜨지않음.
//        val currentFile = File(".")
//        val file = File(currentFile.absolutePath + "/a.txt")
//        val reader = BufferedReader(FileReader(file))
//        println(reader.readLine())
//        reader.close()
//    }
//}
//
//// Kotlin에서는 Checked Exception과 UnChecked Exception을 구분하지 않는다.
//// -> 모두 UnChecked Exception이다.

// Kotlin에서는 try with resources 구문이 없다..!
class FilePrinter {
    fun readFile(path: String) {    // .use : BufferdReader에 대한 inline 확장함수. 섹션4에서 배울 것.
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}
// 지금은 코틀린에서는 try with resources가 사라지고 .use가 사용되는구나~ 정도로만 알아도 됨.