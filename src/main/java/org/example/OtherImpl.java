package org.example;

/**
 * Альтернативная реализация интерфейса SomeInterface, выполняющая метод doSomething, выводя "B" в консоль
 * @author Yuliya Grischenko
 * @version 1.0-SNAPSHOT
 * @see SomeInterface
 */
public class OtherImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.println("B");
    }
}
