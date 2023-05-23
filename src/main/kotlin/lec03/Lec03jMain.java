package lec03;

public class Lec03jMain {

    public static void main(String[] args) {
        Person person = new Person("박꿀꿀", 34);
        String log = String.format("사람의 이름은 %s이고 나이는 %s세 입니다.", person.getName(), person.getAge());
        System.out.println(log);

        StringBuilder builder = new StringBuilder();
        builder.append("사람의 이름은 ");
        builder.append(person.getName());
        builder.append("이고 나이는 ");
        builder.append(person.getAge());
        builder.append("세 입니다.");
        System.out.println(builder);

        String str = "ABCDE";
        char ch = str.charAt(1);
        System.out.println(ch);
    }

    public static void printAgeIfPerson(Object obj) {
        if(obj instanceof Person) {         // instanceof : 변수가 주어진 타입이면 true, 아니면 false
            Person person = (Person) obj;   // (타입) : 주어진 변수를 해당 타입으로 변경한다.
            System.out.println(person.getAge());
        }
    }




}
