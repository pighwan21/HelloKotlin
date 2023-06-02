package lec10;

public abstract class JavaAnimal {

    // Animal 클래스에 대한 Java 코드
    protected final String species; // 어떤 종인지를 의미하는 필드
    protected final int legCount; // 다리가 몇 개인지를 의미하는 필드

    public JavaAnimal(String species, int legCount) {
        this.species = species;
        this.legCount = legCount;
    }

    abstract public void move(); // 추상 메서드. 동물이 움직이는 move라는 메소드

    public String getSpecies() {
        return species;
    }

    public int getLegCount() {
        return legCount;
    }
}
