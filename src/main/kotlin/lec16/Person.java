package lec16;

public class Person {
    private final String firstName;

    private int age;

    public Person(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public int nextYearAge() {
        System.out.println("멤버 함수");
        return this.age + 1;
    }

    public int getAge() {
        return age;
    }
}
