package com.aca.threads.revercetext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reversing {

    private final static int THREAD_COUNT = 10;


    public static void main(String[] args) {
        List<MyRunnable> run = new ArrayList<>(THREAD_COUNT);
        List<Thread> threads = new ArrayList<>(THREAD_COUNT);
        Scanner sc=new Scanner(System.in);
        StringBuffer string=new StringBuffer(sc.nextLine());
        int COUNT = string.length();
        int BUTCH_COUNT = COUNT / THREAD_COUNT;

        for (int i = 0; i < THREAD_COUNT; ++i) {
            run.add(new MyRunnable(new StringBuffer(string.substring(i * BUTCH_COUNT, (i + 1) * BUTCH_COUNT))));
            threads.add(new Thread(run.get(i)));
        }

        for (Thread th : threads
        ) {
            th.start();

        }
        for (Thread th : threads
        ) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        string.delete(0,COUNT);
        for(int i=THREAD_COUNT-1;i>=0;--i)
        {
            string.append(run.get(i).getString());
        }
        System.out.println(string);





    }
}
