package lec14;

import java.util.Objects;

public class JavaPersonDto {
    // 계층간의 데이터를 전달하기 위한 DTO(Data Transfer Object)
    // 데이터를 전달하기 위한 목적의 Object
    // DTO에는 보통 데이터(필드), 생성자와 getter, equals와 hashCode, toString이 들어감.

    private final String name;
    private final int age;

    public JavaPersonDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaPersonDto that = (JavaPersonDto) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "JavaPersonDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// IDE를 활용할 수도 있고, lombok을 활용할 수도 있지만
// 클래스가 장황해지거나, 클래스 생성 이후 추가적인 처리를 해줘야 하는 단점이 있다.
