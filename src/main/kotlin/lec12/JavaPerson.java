package lec12;

public class JavaPerson {                           // Person이라는 Java Class.
    private static final int MIN_AGE = 1;           // static 변수 하나

    public static JavaPerson newBaby(String name) { // 정적 팩토리 메소드라 불리는 static 함수 하나
        return new JavaPerson(name, MIN_AGE);
    }

    private String name;
    private int age;
    private JavaPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
