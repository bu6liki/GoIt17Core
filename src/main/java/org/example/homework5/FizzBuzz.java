package org.example.homework5;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class FizzBuzz {
    private int n;
    private BlockingQueue<String> queueA;
    private BlockingQueue<String> queueB;
    private BlockingQueue<String> queueC;
    private BlockingQueue<String> queueD;

    public FizzBuzz(int n) {
        this.n = n;
        this.queueA = new LinkedBlockingQueue<>();
        this.queueB = new LinkedBlockingQueue<>();
        this.queueC = new LinkedBlockingQueue<>();
        this.queueD = new LinkedBlockingQueue<>();
    }

    public void fizz() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                queueA.add("fizz");
            }
        }
    }

    public void buzz() {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                queueB.add("buzz");
            }
        }
    }

    public void fizzbuzz() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                queueC.add("fizzbuzz");
            }
        }
    }

    public void number() {
        for (int i = 1; i <= n; i++) {
            try {
                if (!queueA.isEmpty()) {
                    System.out.println(queueA.take());
                } else if (!queueB.isEmpty()) {
                    System.out.println(queueB.take());
                } else if (!queueC.isEmpty()) {
                    System.out.println(queueC.take());
                } else {
                    System.out.println(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



