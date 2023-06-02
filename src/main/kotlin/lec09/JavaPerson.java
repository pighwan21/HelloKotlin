package lec09;

//public class JavaPerson {
//    // 개명이 불가능한 나라에 사는 Person 클래스
//    private final String name;  // final, 즉 한번 정해진 후 다시 바꿀 수 없는 불변 field의 값을 설정해 줄 수 없기 때문
//                                // 현재로선 name을 초기화할 수 없기 때문에 에러가 남.
//                                // 따라서 이 Java클래스에 생성자와 getter, setter를 만들어 주어야 함.
//    private int age;
//}

// 아래와 같이.
public class JavaPerson {
    // 개명이 불가능한 나라에 사는 Person 클래스
    private final String name;
    private int age;

    public JavaPerson(String name, int age) {   // 생성자를 만들어주면 private final String name; 의 빨간줄이 사라짐.
        // 일반적으로 검증은 클래스 생성 시점에 해주니까 생성자에 검증 로직을 짬.(나이 검증하는 코드)
        if (age <= 0) {
            throw new IllegalArgumentException(String.format("나이는 %일 수 없습니다."));
        }
        this.name = name;
        this.age = age;
    }

    // 로직2. 최초로 태어나는 아기는 무조건 1살이니, 생성자를 하나 더 만들자!
    public JavaPerson(String name) {
        this(name, 1);
    }
    // 이 생성자는 기존에 있던 생성자를 호출해주는 걸 볼 수 있음.

    // getter는 둘다 가능
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // setter는 name이 불변이기 때문에 age만 가능
    public void setAge(int age) {
        this.age = age;
    }

    // 성인인지 확인하는 기능 추가
    public boolean isAdult() {
        return this.age >= 20;
    }

}

