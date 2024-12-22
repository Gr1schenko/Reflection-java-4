package org.example;

/**
 * Реализация интерфейса SomeInterface, выполняющая метод doSomething, выводя "A" в консоль
 * @author Yuliya Grischenko
 * @version 1.0-SNAPSHOT
 * @see SomeInterface
 */
public class SomeImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.println("A");
    }
}
