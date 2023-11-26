package com.example.sectionOne;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.example.sectionOne.innerJavaFunctionalInterfaces.Plus10;

public class Run {
    public static void main(String[] args) {
        //java 8 이전
        //익명 내부 클래스 anonymous inner class
        // RunSomething runSomething = new RunSomething() {
        //     @Override
        //     public void doIt() {

        //     }
        // };
        
        //위 코드와 동일, lambda 형태로 간단히 표현 가능 (코드양을 줄여 쓸 수 있는 장점)
        //특수한 형태의 오브젝트라고 볼 수 있다. 자바는 객체지향언어이기 때문에 변수에 할당하고, 메소드 파라미터로 전달하거나 리턴타입으로 정의할 수 있다.
        //함수형 오브젝트를 인라인으로 표현한 오브젝트
        // RunSomething runSomething = () -> {
        //     System.out.println("hello");
        //     System.out.println("lambda");
        // };

        // runSomething.doIt();
        //함수를 First class object로 사용할 수 있다.
        //고차함수로 사용 가능 (함수를 파라미터로 전달하거나, 함수를 리턴할 수 있다.)

        //같은 input에 대해서 같은 return이 나와야 함수형 프로그래밍이라고 할 수 있다.
        //함수 안에서 함수 바깥의 값을 참조해서 로직을 실행한는 경우, 어떤 상태값에 의존한다라고 말 할 수 있기 떄문에, 순수 함수라고 말할 수 없다.
    
        //무조건 함수형 프로그래밍을 해야하는 건 아니다. 목적에 따라 사용

        // ---

        //Plus10 plus10 = new Plus10();
        //System.out.println(plus10.apply(1));

        //클래스를 만들지 않고 바로 사용 가능
        //함수를 조합할 수 있는 메소드를 디폴트로 제공 andThen, compose
        // Function<Integer, Integer> plusTen = (i) -> {
        //     return i + 10;
        // };
        // // System.out.println(plusTen.apply(1));
        // Function<Integer, Integer> multiplyTwo = (i) -> {
        //     return i * 2;
        // };

        //compose: 입력 값을 가지고 뒤에오는 함수에 먼저 처리 하고, 결과값을 함수의 입력값으로 사용
        //+10.compose(x2)
        // Function<Integer, Integer> multiplyTwoAndPlusTen = plusTen.compose(multiplyTwo);
        // System.out.println(multiplyTwoAndPlusTen.apply(2));        
        
        
        //andThen: 입력 값을 처리하고 결과값을 다음 함수의 입력값으로 사용하게 됨
        // Function<Integer, Integer> plusTenAndThenMultiplyTwo = plusTen.andThen(multiplyTwo);
        // System.out.println(plusTenAndThenMultiplyTwo.apply(2));

        //인터페이스 BiFunction: 입력값을 두개 받아서 하나를 리턴 함
        
        //인터페이스 Consumer: 입력값 하나에 리턴 값이 없음
        // Consumer<Integer> printT = (i) -> System.out.println(i);
        // printT.accept(10);

        //인터페이스 Supplier: 입력값을 받지 않고 값을 리턴 함
        // Supplier<Integer> getTen = () -> 10;

        //인터페이스 Predicate: 어떠한 인자를 받아서 True/False를 리턴 함
        //boolean으로 결과값이 리턴되기 때문에, not, and, or 조합 가능
        // Predicate<String> startWithJo = (s) -> s.startsWith("jo");
        // Predicate<Integer> isEven = (i) -> i % 2 == 0;

        //인터페이스 UnaryOperator: Function 인터페이스의 특수한 형태
        //입력하는 타입과 리턴하는 타입이 같을 때 사용 가능 (타입이 하나일 경우) 
        // UnaryOperator<Integer> 
        
        //인터페이스 BinaryOperator:BiFunction의 특수한 형태
        //입력값 두개 리턴값 하나의 타입이 모두 같을 때 사용 가능

        //그 외에도 기본적으로 제공하는 함수형 인터페이스가 많기 때문에 관심을 가지고 살펴보자
        //java.lang.function 패키지

        // --- 

        //람다에 대해서
        //(인자) -> { 바디 }
        //인자가 없을 때는 () 로 정의 가능
        //바디가 한줄이면 생략 가능
        // Supplier<Integer> getOne = () -> 10;

        //인자가 여러개 일 때
        //타입의 경우 제네릭으로 컴파일러가 추론할 수 있기 때문에 생략 가능
        // BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        
        //변수 캡처 (Variable Capture)
        //람다를 감싸고 있는 영역에서의 로컬 변수가 캡처가 된다. (같은 스코프이다.)
        //로컬 클래스, 익명 내부 클래스에도 쓰이던 기능이지만 쉐도잉을 방지할 수 있다. (항상 final이여야 사용 가능 했음)

        // Run run = new Run();
        // run.doSomething();

        // ---
        //메소드 레퍼런스에 대해서
        //람다표현식으로 구현할 때 쓸수 있는 방식
        //기존에 있던 메소드나, 직접 구현하지 않고 
        // Function<Integer, String> intToString = (i) -> "number";
        
        // UnaryOperator<String> hi = (s) -> "hi " + s; 는 아래와 같다
        //콜론 두개로 메소드 레퍼런스를 나타낼 수 있다.

        //스태틱 메소드 참조 (타입::스태틱메소드)
        // UnaryOperator<String> hi = Greeting::hi;

        //인스턴스 메소드 참조 (객체레퍼런스::인스턴스 메소드)
        // Greeting greeting = new Greeting();
        // UnaryOperator<String> hello = greeting::hello; // 메소드를 호출한게 아님. 참조하겠다고 선언

        //생성자 참조
        //입력값은 있는데 리턴값이 없는 함수형 인터페이스
        // Supplier<Greeting> newGreeting = Greeting::new; // 인스턴스를 만든건 아님. 참조하겠다고 선언
        // newGreeting.get(); // get을 해줘야 생성자가 호출되고 인스턴스가 생성됨.

        //입력값을 받는 생성자
        // Function<String, Greeting> newGreeting = Greeting::new;
        // newGreeting.apply("jo"); // 위 Supplier와 다른 생성자를 호출하게 됨
        
        //임의의 객체의 인스턴스 메소드 참조
        //특정 타입의 불특정 다수의 인스턴스 메소드 참조
        // String[] names = {"jo", "whiteship", "hyeong"};
        // Arrays.sort(names, String::compareToIgnoreCase);
        // System.out.println(Arrays.toString(names));
    }   

    private void doSomething(){
        final int baseNumber = 10;

        //로컬 클래스
        // class LocalClass {
        //     void printBaseNumber() {
        //         //밖의 baseNumber를 가림. 쉐도잉
        //         //다른 스코프이기 때문에 가능
        //         int baseNumber = 11;
        //         System.out.println(baseNumber); //11
        //     }
        // }

        //익명 내부 클래스
        // Consumer<Integer> integerConsumer = new Consumer<Integer>() {
        //     @Override
        //     public void accept(Integer baseNumber) {
        //         //밖의 baseNumber를 가림. 쉐도잉
        //         //다른 스코프이기 때문에 가능
        //         System.out.println(baseNumber);
        //     }
        // };


        //람다
        IntConsumer print = (i) -> {
            // int baseNumber = 11; (컴파일 에러)
            //람다는 감싸고 있는 메소드와 같은 스코프이기 때문에 같은 이름의 변수를 정의할 수 없음.
            System.out.println(baseNumber); 
        };


        //셋 공통적인건 모두 밖 베이스 넘버에 참조 가능
        //java8 부터는 baseNumber의 final을 생략 할 수 있다.
        //해당 변수가 사실상 final일 경우 (final이라는 키워드는 없지만 해당 변수를 변경하는 코드가 없는 경우, effective final이라고도 함) 

        //로컬클래스, 익명클래스와 람다의 다른점: 쉐도잉
        //로컬클래스, 익명클래스는 쉐도잉이 된다. 선언한 변수들 중 이름이 같은 변수가 있으면 가려진다. (쉐도잉) 감싸고 있는 메소드와 별도의 스코프이기 떄문에 가능하다.
        //람다는 쉐도잉이 안 된다. 람다는 람다를 감싸고 있는 메소드랑 스코프가 같다. 쉐도잉이 일어나지 않는다.
        print.accept(10);
    }
}
