package org.example;

/**
 * Класс, представляющий некоторый объект, который содержит зависимости,
 * помеченные аннотацией @AutoInjectable
 * @author Yuliya Grischenko
 * @version 1.0-SNAPSHOT
 */
public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;

    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Метод, который вызывает методы doSomething у внедренных зависимостей
     */
    public void foo() {
        field1.doSomething();
        field2.doSomething();
    }
}
