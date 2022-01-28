package com.example.projekt_sonb.other_classes;

import java.util.Random;

public class InputGenerator {

    public InputGenerator(){
        generator();
    }

    private static Random random=new Random();
    public static int gen = 4;

    public static  void generator() {
        Thread thread = new Thread(() -> {

            while (true) {
                gen = random.nextInt( 3,7);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}