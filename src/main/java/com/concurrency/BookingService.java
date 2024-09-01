package com.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookingService implements Runnable{
    Lock lock;
    Semaphore semaphore;
    private int score;
    BookingService(){
        this.score=0;
        lock=new ReentrantLock();
        semaphore=new Semaphore(1);
    }
    @Override
    public void run() {
        try{
            semaphore.acquire();
            for(int i=0;i<5;i++){

                Thread.sleep(1000);
                score++;

                System.out.println("Booked: "+i+" "+ Thread.currentThread()+" "+score);
            }
            semaphore.release();
        }catch (Exception e){
            semaphore.release();
        }


    }
}
