package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class TestServer {

    public static void main(String[] args) {
        Server s1 = new Server();
        Thread Thread_1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Start Thread_1");
                try {
                    s1.go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread Thread_2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Start Thread_2");
            }
        });
        Thread Thread_3 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Start Thread_3");
            }
        });
        Thread Thread_4 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Start Thread_4");
            }
        });
        Thread Thread_5 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Start Thread_5");
            }
        });
        Thread Thread_6 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Start Thread_6");
            }
        });
        Thread_1.start();
        Thread_2.start();
        Thread_3.start();
        Thread_4.start();
        Thread_5.start();
        Thread_6.start();
    }
}

