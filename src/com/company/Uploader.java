package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {

    private CountDownLatch cdl;
    private int file = 500;
    private int speed = 20;


    public Uploader(CountDownLatch countDownLatch){
        this.cdl = countDownLatch;
        start();
    }

    @Override
    public void run() {
        System.out.println("_______________________");
        System.out.println("Началась загрузка файла на сервер");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("**************");
                sleep(file/speed*100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("загрузка завершена ");
        cdl.countDown();

    }
}




/*

#ДЗ
Вариант А (Дэдлайн 28.09.2020 18:59)
a)  Написать многопоточное приложение, которое бы симулировало загрузку файлов на сервер.
 И их скачивание. Используя классы Semaphore и CountDownLatch.
  Либо можно использовать методы wait(), notify(), notifyAll().
b)  Uploader загружает 1 файл 500 мб на сервер. Скорость загрузки 20 мб в секунду.
Нужно в консоли отобразить процесс загрузки симулируя через sleep().
c)  После того как весь файл загружен на сервер Downloaders
 начинают его скачивать со скоростью 100 мб в секунду.
  Должны скачать файл 10 человек, одновременно могут скачивать не более 3х человек.
d)  После того как файл был скачан 10 раз, он удаляется с сервера
Вариант Б (Дэдлайн 30.07.2020 23:59)
e)  Написать синхронизированное многопоточное приложение,
которое бы симулировало автовокзал.
f)  Всего 100 пассажиров (PassengerThread -
пассажиры должны быть отдельными потоками) отправляются в город Ош.
g)  Перед тем как отправится им необходимо приобрести билеты
на кассе но всего на автовокзале 4 рабочих кассы,
 и одновременно может обслуживаться только 1 пассажир.
h)  Также автобус имеет 100 пассажирских мест
 и отправляется только тогда, когда все они заполнятся.
i)  При выполнении задания можно использовать либо
 Semaphore и CountDownLatch, либо методы wait(), notify(), notifyAll()*/