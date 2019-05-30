package com.aca.threads.maxElementWithPool;


import java.util.Collection;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Collection<Integer>> {
    private Integer end;
    private Integer start;
    private Collection<Integer> col;

    public MyCallable(Integer start, Integer end, Collection<Integer> col) {
        this.end = end;
        this.start = start;
        this.col = col;
    }

    @Override
    public Collection<Integer> call() throws Exception {

        for (int i = start; start <= end; ++i) {
            col.add(i);
        }
        return col;


    }
}
