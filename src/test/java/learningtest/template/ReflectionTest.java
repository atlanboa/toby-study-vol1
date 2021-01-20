package learningtest.template;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class ReflectionTest {
    @Test
    public void invokeMethod() throws Exception {
        String name = "spring";

        assertEquals(6, name.length());

        Method lengthMethod = String.class.getMethod("length");
        assertEquals(6, lengthMethod.invoke(name));

        assertEquals('s', name.charAt(0));

        Method charAtMethod = String.class.getMethod("charAt", int.class);
        assertEquals('s', charAtMethod.invoke(name, 0));
    }
}
