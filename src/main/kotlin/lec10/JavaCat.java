package lec10;

public class JavaCat extends JavaAnimal { // extends를 사용해 JavaAnimal을 상속
    public JavaCat(String species) {
        super(species, 4);  // super : 상위 클래스에 접근하는 키워드.
    }

    @Override
    public void move() {
        System.out.println("고양이가 사뿐 사뿐 걸어가~");
    }
}
