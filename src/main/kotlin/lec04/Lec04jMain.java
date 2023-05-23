package lec04;

public class Lec04jMain {

    public static void main(String[] args) {
        JavaMoney money1 = new JavaMoney(2_000L);
        JavaMoney money2 = new JavaMoney(1_000L);
        JavaMoney money3 = new JavaMoney(1_000L);
        JavaMoney money4 = money2;
        JavaMoney money5 = new JavaMoney(1_000L);
        JavaMoney money6 = new JavaMoney(2_000L);

        if(money1.compareTo(money2) > 0) {
            System.out.println("Money1이 Money2보다 금액이 큽니다.");

        System.out.println(money2 == money4);
        System.out.println(money3 == money4);       // ==(동일성)은 주소를 확인하는 것이기에 false가 나옴
        System.out.println(money3.equals(money4));  // 동등성 확인

        System.out.println(money5.plus(money6));
        }
    }
}
