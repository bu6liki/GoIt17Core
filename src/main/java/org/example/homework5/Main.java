package org.example.homework5;
public class Main {
    public static void main(String[] args) {
        int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        Thread threadA = new Thread(() -> fizzBuzz.fizz());
        Thread threadB = new Thread(() -> fizzBuzz.buzz());
        Thread threadC = new Thread(() -> fizzBuzz.fizzbuzz());
        Thread threadD = new Thread(() -> fizzBuzz.number());

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
