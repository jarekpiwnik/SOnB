package com.company;
import java.util.Random;

public class Server {
    // Semaphore mutex = new Semaphore(1);
    //  Semaphore full = new Semaphore(0);
    Random random = new Random();

    public Server() {

    }

    public void go() throws InterruptedException {
        int liczba;
        while (true) {
            liczba = random.nextInt(10);
            System.out.print("Liczba = " + liczba);
            Thread.sleep(random.nextInt(2000));
        }
    }
}