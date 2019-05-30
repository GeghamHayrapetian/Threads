package com.aca.threads.count;

public class SharedCounter  implements Runnable {
  private Integer integer;

    public Integer getInteger() {
        return integer;
    }

    @Override
    public void run() {
        synchronized (this)
        {
            integer+=1;

        }
    }
}
