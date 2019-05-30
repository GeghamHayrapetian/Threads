package com.aca.threads.revercetext;

import java.util.Collection;
import java.util.concurrent.Callable;

public class MyRunnable implements Runnable {
    private StringBuffer string;

    public MyRunnable(StringBuffer string) {
        this.string = string;
    }

    public StringBuffer getString() {
        return string;
    }

    @Override
    public void run() {
        string.reverse();
    }
}
