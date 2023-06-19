package lec17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lec17jMain {
    List<Fruit> fruits = Arrays.asList(
            new Fruit("사과", 1_000),
            new Fruit("사과", 1_200),
            new Fruit("사과", 1_200),
            new Fruit("사과", 1_500),
            new Fruit("바나나", 3_000),
            new Fruit("바나나", 3_200),
            new Fruit("바나나", 2_500),
            new Fruit("수박", 10_000)
    );

    // 사장님~ 사과만 보여주세용~
    private List<Fruit> findApples(List<Fruit> fruits) {
        List<Fruit> apples = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getName().equals("사과")) {
                apples.add(fruit);
            }
        }
        return apples;
    }

    // 사장님~ 바나나만 보여주세용~~
    private List<Fruit> findBananas(List<Fruit> fruits) {
        List<Fruit> bananas = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getName().equals("바나나")) {
                bananas.add(fruit);
            }
        }
        return  bananas;
    }

    // 중복 제거한 코드
    private List<Fruit> findFruitsWithName(List<Fruit> fruits, String name) {
        List<Fruit> results = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getName().equals(name)){
                results.add(fruit);
            }
        }
        return results;
    }

    // 사장님~~ 사과랑 바나나를 같이 보여주세용~~~
    // 사과인데 가격이 1200원을 넘지 않는 사과만 주세요~~~
    // 10000원 이하의 수박과 1000원 이상의 바나나를 보여주세요~~~
    // -> 파라미터를 단순히 늘리는 것만으로 커버하기는 어려움.
    // -> 메소드를 계속해서 만드는 것 역시 좋지 않음.
    // -> 인터페이스와 익명 클래스를 활용하자!

    // FruitFilter라는 인터페이스
    public interface FruitFilter {
        boolean isSelected(Fruit fruit);
        // isSelect라는 추상 메소드를 만들어 Fruit를 받아 true나 false를 반환할 수 있게끔 함
    }

    // 메소드에서는 이 필터를 받아서 필터를 돌려 결과를 반환하는 식으로 코딩
//    private List<Fruit> filterFruits(List<Fruit> fruits, FruitFilter fruitFilter) {
//        List<Fruit> results = new ArrayList<>();
//        for (Fruit fruit : fruits) {
//            results.add(fruit);
//        }
//        return results;
//    }

    // 실제 filterFruits를 호출해주는 쪽에서는 아래처럼 인터페이스를 구현한 익명 클래스를 만듦으로써 그때 그때 필요한 필터 조건을 걸 수 있다.
    // [함수를 호출하는 쪽]
    // filterFruits(fruits, new FruitFilter() {
    //   @Override
    //   pulbic boolean isSelected(Fruit fruit) {
    //      return Arrays.asList("사과", "바나나").contains(fruit.getName()) && fruit.getPrice() > 5_000;
    //   }
    // });
    // 익명 클래스와 인터페이스를 활용해서 무수한 매소드 생성을 막을 수는 있음.
    // 하지만 '익명 클래스'를 사용하는 것은 복잡하다. 또는 다양한 Filter가 필요할 수도 있다.
    // ex) 과일 간의 무게 비교를 한다거나, N개의 과일을 한 번에 비교한다거나 등등..

    // ---> JDK8부터 람다(이름 없는 함수)가 등장!
    // 또한 FruitFilter와 같은 인터페이스, Predicate, Consumer 등을 많이 만들어 두었다.
    // [함수를 호출하는 쪽]
    // filterFruits(fruits, fruit -> fruit.getName().equals("사과"));
    // 위의 코드를 더욱 리펙토링하면
    // filterFruits(fruits, Fruit::isApple);    // 메소드 레퍼런스를 활용
    // [람다의 문법]
    // 변수 -> 변수를 이용한 함수
    // (변수1, 변수2) -> 변수1과 변수2를 이용한 함수   <- 변수가 여러 개인 경우
    // 함수는 Predicate라고 언급했던 미리 만들어져 있는 함수형 인터페이스를 활용해서 코드를 리펙토링할 수 있게 되었다.
//    private List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
//        List<Fruit> results = new ArrayList<>();
//        for (Fruit fruit : fruits) {
//            if (fruitFilter.test(fruit)) {
//                results.add(fruit);
//            }
//        }
//        return results;
//    }
    // 여기에 더해 간결한 스트림이 등장!(병렬처리에도 강점이 생김)
    private static List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
        return fruits.stream()
                .filter(fruitFilter)
                .collect(Collectors.toList());
    }
    // 코드가 위와 같이 stream과 filter, collect 등을 활용한 함수형 프로그래밍의 형태로 바뀌게 됨.
    // 이렇게 Java에서는 '메소드 자체를 직접 넘겨주는 것처럼' 쓸 수 있었다.
    // 포인트는 메소드 자체를 즉 함수 자체를 직접 넘겨주는 '것처럼' 이다.
    // 실제 함수를 넘기는 것처럼 보이지만, 실제 받는 것은 인터페이스(미리 만들어뒀던 Predicate 인터페이스)이기 때문이다.
    // 바꿔 말하면, Java에서 함수는 변수에 할당되거나 파라미터로 전달할 수 없다.
    // 즉, 함수를 Java에서는 2급 시민으로 간주하고 변수에 직접 할당하거나 파라미터로 함수 자체를 바로 넘길 수 없다.

    // 3. Closure
//    public static void main(String[] args) {
//        String targetFruitName = "바나나";
//        targetFruitName = "수박";
//        filterFruits(fruits, (fruit) -> targetFruitName.equals(fruit.getName()));
//    }
    // Variable used in lambda expression should be final or effectively final
    // Java에서는 람다를 쓸 때 람다 밖에 있는 변수를 사용하는 경우 제약이 있다.

}


