package lec14;

public enum JavaCountry {
    KOREA("KO"),        // KOREA라는 Enum 타입
    AMERICA("US");      // AMERICA라는 Enum 타입

    private final String code;

    JavaCountry(String code) { this.code = code; }

    public String getCode() { return code; }
}

// Enum의 특징
// - 추가적인 클래스를 상속받을 수 없다.
// - 인터페이스는 구현할 수 있으며, 각 코드가 싱글톤이다.