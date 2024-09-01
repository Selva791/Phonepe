package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class Application {
    public static void main(String[] args) {
        BookingService b=new BookingService();
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        executorService.execute(b);
        executorService.execute(b);
        executorService.shutdown();

      /*
        Thread t1=new Thread(b,"Dhoni");
        Thread t2=new Thread(b,"Kohli");
        t1.start();
        t2.start();*/
    }
}
