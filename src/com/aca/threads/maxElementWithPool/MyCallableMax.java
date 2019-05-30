package com.aca.threads.maxElementWithPool;

import java.util.Collection;
import java.util.concurrent.Callable;

public class MyCallableMax implements Callable<Integer> {

    private Integer end;
    private Integer start;
    private Collection<Integer> col;

    public MyCallableMax(Integer start, Integer end, Collection<Integer> col) {
        this.end = end;
        this.start = start;
        this.col = col;
    }

    @Override
    public Integer call() throws Exception {
        Integer max = (Integer) col.toArray()[0];
        for (int i = start; i <= end; ++i) {
            if ((Integer) col.toArray()[i] > max) {
                max = (Integer) col.toArray()[i];
            }
        }
        return max;


    }
}
