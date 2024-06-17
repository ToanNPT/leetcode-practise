package com.javacore.practise;

public class JavaMemoryModel {

    public static void main(String[] args) throws InterruptedException {
        MyObject obj = new MyObject();

        MyRunnable runnable = new MyRunnable(obj);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }


    public static class MyRunnable implements Runnable {
        private int count = 0;
        private MyObject obj = null;

        public MyRunnable(MyObject obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (this) {
                System.out.println(obj);
                System.out.println("The value of count is " + count);
                for (int i = 0; i < 1000000; i++) {
                    count++;
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " count = " + count);
            }
        }
    }

    public static class MyObject {
        private String name;

        public MyObject() {
        }

        public MyObject(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
