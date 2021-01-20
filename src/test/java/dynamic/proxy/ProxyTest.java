package dynamic.proxy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProxyTest {
    @Test
    public void simpleProxy() {
        Hello hello = new HelloTarget();
        assertEquals("Hello Toby", hello.sayHello("Toby"));
        assertEquals("Hi Toby", hello.sayHi("Toby"));
        assertEquals("Thank you Toby", hello.sayThankYou("Toby"));

    }
    
    @Test
    public void helloUppercase() {
        Hello proxyHello = new HelloUppercase(new HelloTarget());
        assertEquals("Hello Toby".toUpperCase(), proxyHello.sayHello("Toby"));
        assertEquals("Hi Toby".toUpperCase(), proxyHello.sayHi("Toby"));
        assertEquals("Thank you Toby".toUpperCase(), proxyHello.sayThankYou("Toby"));
    }


}
