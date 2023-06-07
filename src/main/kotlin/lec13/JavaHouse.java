package lec13;

public class JavaHouse {
    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }
//    public static class LivingRoom {   // 여기에 static을 붙이면
//        private double area;
//        public LivingRoom(double area) {
//            this.area = area;
//        }
//
//        public String getAddress() {
//            return JavaHouse.this.address;  // static 때문에 바깥 클래스를 바로 불러올 수 없음.
//        }
//    }
//    }
//    public class LivingRoom {   // JavaHouse 안에 LivingRoom이라는 중첩 클래스가 있음. - 내부 클래스
//        private double area;
//
//        public LivingRoom(double area) {
//            this.area = area;
//        }
//
//        public String getAddress() {
//            return JavaHouse.this.address;  // 바깥 클래스와 연결되어 있다.
//        }
//    }
    // 1. 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어, 참조를 해지하지 못하는 경우 메모리 누수가
    //    생길 수 있고, 이를 디버깅 하기 어렵다.
    // 2. 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있다.
    // -> 클래스 안에 클래스를 만들 때는 static 클래스를 사용하라.
    // (코틀린은 이러한 가이드를 충실히 따르고 있음)

    public static class LivingRoom {   // JavaHouse 안에 LivingRoom이라는 중첩 클래스가 있음. - 내부 클래스
        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }
    }

}


