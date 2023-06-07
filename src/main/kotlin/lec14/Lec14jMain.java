package lec14;

public class Lec14jMain {

    private static void handleCountry(JavaCountry country) {
        if (country == JavaCountry.KOREA) {
            // 로직 처리
        }

        if (country == JavaCountry.AMERICA) {
            // 로직 처리
        }
        // 이 코드의 단점. 1) 코드가 많아지게 되면 상대적으로 가독성이 떨어질 수 있음.
        //               2) else 로직 처리에 대한 애매함.
    }

}
