package lec10;

public interface JavaFlyable {
    default void act() {
        System.out.println("파닥 파닥");
    }
    // JavaSwimable과 동일하게 act라는 똑같은 시그니처를 가진 메소드를 가지고 있음
    //    void fly(); // fly라는 추상 메서드
}
