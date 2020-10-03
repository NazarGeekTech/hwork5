package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        CountDownLatch xdl = new CountDownLatch(1);
        CountDownLatch cdl = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3, true);
        new Uploader(xdl);


        for (int i = 1; i <=10; i++) {
            new Downloaders("Человек "+i, semaphore, xdl, cdl);
        }
        try {
            cdl.await();
            System.out.println("Файл из сервера удаляется через 10 секунд");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
