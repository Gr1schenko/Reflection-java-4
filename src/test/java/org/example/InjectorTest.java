package org.example;

import static org.junit.jupiter.api.Assertions.*;

class InjectorTest {

    @org.junit.jupiter.api.Test
    void testInjectValidProperties() {
        Injector injector = new Injector();
        SomeBean someBean = new SomeBean();
        injector.inject(someBean, "2.properties");

        assertNotNull(someBean);
        someBean.foo();
    }

    @org.junit.jupiter.api.Test
    void testInjectInvalidProperties() {
        Injector injector = new Injector();
        SomeBean someBean = new SomeBean();

        Exception exception = assertThrows(RuntimeException.class, () ->
                injector.inject(someBean, "invalid.properties"));

        String expectedMessage = "File invalid.properties not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @org.junit.jupiter.api.Test
    void testInjectNoImplementation() {
        Injector injector = new Injector();
        SomeBean someBean = new SomeBean();

        Exception exception = assertThrows(RuntimeException.class, () ->
                injector.inject(someBean, "empty.properties"));

        String expectedMessage = "Implementation not found for interface org.example.SomeInterface";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
