package com.example.sectionOne.innerJavaFunctionalInterfaces;

import java.util.function.Function;

public class Plus10 implements Function<Integer, Integer>{
    //function 이라는 class 인터페이implements Function<>스
    //Function<T,R>
    //T라는 타입을 받아서 R이라는 타입을 리턴.
    //값을 하나 받아서 하나를 리턴
    //apply라는 메소드를 구현하면 된다.
    
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
    
}
