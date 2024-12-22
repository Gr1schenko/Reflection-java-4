package org.example;

/**
 * Реализация интерфейса SomeOtherInterface, выполняющая метод doSomething, выводя "C" в консоль
 * @author Yuliya Grischenko
 * @version 1.0-SNAPSHOT
 * @see SomeOtherInterface
 */
public class SODoer implements SomeOtherInterface {
    @Override
    public void doSomething() {
        System.out.println("C");
    }
}
