package com.aca.threads.revercetext;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyRunnableTest {

    @Test
    void run() {
        MyRunnable runnable=new MyRunnable(new StringBuffer("qwertyuiop"));
        runnable.run();
        assertEquals("poiuytrewq",runnable.getString());
    }
}