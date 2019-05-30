package com.aca.threads.maxElementWithPool;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyCallableMaxTest {

    @Test
    void call() {
        ArrayList<Integer> A=new ArrayList<>();
        A.add(1253);
        A.add(1236);
        A.add(1243);
        A.add(22123);
        A.add(1233);
        A.add(1243);
        A.add(123553);


        MyCallableMax a=new MyCallableMax(0,6,A);
        try {
            assertEquals(123553,a.call());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}