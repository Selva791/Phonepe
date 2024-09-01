package com.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1: Lock acquired");
                Thread.sleep(10000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Thread 1: Lock released");
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 2: Lock acquired");
            } finally {
                lock.unlock();
                System.out.println("Thread 2: Lock released");
            }
        }).start();
    }
}
