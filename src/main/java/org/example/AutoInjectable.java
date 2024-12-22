package org.example;

import java.lang.annotation.*;

/**
 * Аннотация, указывающая, что поле должно быть автоматически внедрено с помощью класса Injector
 * @author Yuliya Grischenko
 * @version 1.0-SNAPSHOT
 * @see Injector
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInjectable {
}
