package lec12;

public class Lec12jMain {
// Lec 12. 코틀린에서 object 키워드를 다루는 방법
// Java에서는 object라는 별도의 키워드. 즉, 지시어가 없었음.
    public static void main(String[] args) {
        // companion object 이름이 있다면 이름을 사용하면 됨.
        Person.Factory.newBaby("Pig");
        // 지금의 예시는 Factory 라는 이름이 있는 static field를 사용한 예시
        // 이름이 없는 static field를 사용하고 싶다면
        // ex) Person.Companion.newBaby("이름없는Pig");

        // Java에서 Kotlin companion object를 사용하려면
        // 해당 Kotlin 코드에 @JvmStatic을 붙여줘야 한다.
        // 그러면 companion object의 이름을 통해 부르지 않고
        // Java에서 static 함수를 쓰는 것처럼 사용가능.
        Person.newBaby("babyPig");


        moveSomething(new Movable(){    // Java에서는 new 타입이름()
            @Override
            public void move() {
                System.out.println("움직인다아~");
            }
            @Override
            public void fly() {
                System.out.println("난다요~~");
            }
        });
    }

    private static void moveSomething(Movable movable) {
        movable.move();
        movable.fly();
    }

}
