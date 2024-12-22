package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс, отвечающий за внедрение зависимостей в объекты
 * Использует файл свойств для определения, какие реализации должны быть
 * внедрены в поля, помеченные аннотацией @AutoInjectable
 * @author Yuliya Grischenko
 * @version 1.0-SNAPSHOT
 */
public class Injector {
    /**
     * Метод, внедряющий зависимости в указанный объект на основе файла свойств
     * @param object объект, в который будут внедрены зависимости
     * @param propertiesFileName имя файла свойств, содержащего реализации
     * @return объект с внедренными зависимостями или RuntimeException, если файл свойств не найден или не удается создать экземпляр реализации
     */
    public Object inject(Object object, String propertiesFileName) {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(propertiesFileName));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("File " + propertiesFileName + " not found", e);
        }
        catch (IOException e) {
            throw new RuntimeException("Error reading " + propertiesFileName, e);
        }

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                Class<?> fieldType = field.getType();
                String implementationClassName = properties.getProperty(fieldType.getName());

                if (implementationClassName != null) {
                    try {
                        Class<?> implementationClass = Class.forName(implementationClassName);
                        Object implementationInstance = implementationClass.getDeclaredConstructor().newInstance();

                        field.setAccessible(true);
                        field.set(object, implementationInstance);
                    }
                    catch (Exception e) {
                        throw new RuntimeException("Error creating instance for " + fieldType, e);
                    }
                }
                else {
                    throw new RuntimeException("Implementation not found for " + fieldType);
                }
            }
        }
        return object;
    }
}
