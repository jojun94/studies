package com.example.sectionOne;

@FunctionalInterface
public interface RunSomething {
    //추상 메소드가 딱 하나만 있으면 함수형 인터페이스
    //Single Abstract Method Interface
    abstract void doIt();

    //java 8 에서 인터페이스임에도 static method, default method 를 선언할 수 있다.
    static void printFirstName() {
        System.out.println("Jun Hyeong.");
    }

    default void printLastName() {
        System.out.println("Jo.");
    }

    //다른 형태의 메소드가 있어도 중요하지 않고, 추상 메소드가 하나로 함수형 인터페이스를 판단한다.
    //위 스태틱메소드, 디폴트메소드가 있는 경우에도 FunctionalInterface 이다.

    //인터페이스를 견고하게 관리할 수 있다.
}
