package lec10;

public final class JavaPenguin extends JavaAnimal implements JavaFlyable, JavaSwimable {   // extends를 사용해 JavaAnimal을 상속
    private final int wingCount;            // wingCount라는 값이 존재해서

    public JavaPenguin(String species) {    // 생성자에서는 species만 받고
        super(species, 2);
        this.wingCount = 2;                 // 존재하는 field의 wingCount의 값을 바로 2라고 넣어줌.
    }

    @Override
    public void move() {                    // move라는 추상 메서드를 구현
        System.out.println("펭귄이 움직입니다~ 뿌우");
    }

    @Override
    public int getLegCount() {              // getter를 Override 상위 클래스가 가지고 있는 legCount와
        return super.legCount + this.wingCount; // 내가 가지고 있는 wingCount를 더해서 반환.
    }

    @Override
    public void act() {
        JavaSwimable.super.act();
        JavaFlyable.super.act();
    }
    // Java에서 상위 인터페이스의 함수를 Override 할 때 : 인터페이스타입.super.메소드
}
