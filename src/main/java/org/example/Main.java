package org.example;

/**
 * Класс, реализующий работу программы
 * Он создает экземпляр SomeBean и внедряет зависимости с помощью Injector
 */
public class Main {
    /**
     * Метод, который запускает приложение
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SomeBean sb = (SomeBean) new Injector().inject(new SomeBean(), "1.properties");
        sb.foo();
    }
}
