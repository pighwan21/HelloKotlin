package lec16;

public class Person {
    private final String firstName;

    private final String lastName;

    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int nextYearAge() {
        System.out.println("멤버 함수");
        return this.age + 1;
    }

    public int getAge() {
        return age;
    }

// Q) Java에서 Kotlin 확장함수를 가져다 사용할 수 있나?
// -> 가능.
    public static void main(String[] args) {
        Lec16kMainKt.lastChar("ABC");   // Lec16kMain.kt에 있는 lastChar 확장함수를 갖고옴
                                                    // 마치 정적 메소드를 부르는 것처럼 사용 가능.
        System.out.println(Lec16kMainKt.lastChar("ABC"));
    }

}

