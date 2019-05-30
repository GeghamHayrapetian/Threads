package com.aca.threads;

import com.aca.threads.maxElementWithPool.MyCallable;
import com.aca.threads.maxElementWithPool.MyCallableMax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private final static int COUNT = 1000000;
    private final static int THREAD_COUNT = 10;
    private final static int BUTCH_COUNT = COUNT / THREAD_COUNT;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<MyCallableMax> maxList = new ArrayList<>(THREAD_COUNT);
        List<MyCallable> calllList = new ArrayList<>(THREAD_COUNT);
        List<ArrayList<Integer>> ints = new ArrayList<>(THREAD_COUNT + 1);
        for (int i = 0; i < THREAD_COUNT; ++i) {
            calllList.add(new MyCallable(i * BUTCH_COUNT, (i + 1) * BUTCH_COUNT, new ArrayList<>()));
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            Future result = executorService.submit(calllList.get(i));
            try {
                ints.add((ArrayList<Integer>) result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        for (int i = 0; i < THREAD_COUNT; ++i) {
            maxList.add(new MyCallableMax(i * BUTCH_COUNT, (i + 1) * BUTCH_COUNT, ints.get(i)));
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            Future result = executorService.submit(maxList.get(i));
            if (i == THREAD_COUNT) {
                try {
                    System.out.println(result.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

        }
        executorService.shutdown();


    }
}
