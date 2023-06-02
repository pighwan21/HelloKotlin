package lec10;

public interface JavaSwimable {

    default void act() {    // JDK8부터 default메소드를 인터페이스에 넣을 수 있게 됐음!
        System.out.println("어푸 어푸");
    }
    // JavaFlyable과 동일하게 act라는 똑같은 시그니처를 가진 메소드를 가지고 있음
}
