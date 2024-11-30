package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void testEncryption() {
        App cipher = new App(3);
        assertEquals("Khoor", cipher.encrypt("Hello"));
        assertEquals("", cipher.encrypt(""));
        assertEquals(null, cipher.encrypt(null)); //Проверка на null
        assertEquals("123", cipher.encrypt("123")); // Проверка не буквенных символов

    }

    public void testDecryption() {
        App cipher = new App(3);
        assertEquals("Hello", cipher.decrypt("Khoor"));
        assertEquals("", cipher.decrypt(""));
        assertEquals(null, cipher.decrypt(null)); //Проверка на null
        assertEquals("123", cipher.decrypt("123")); // Проверка не буквенных символов

    }

    public void testNegativeShift() {
        App cipher = new App(-3);
        assertEquals("Ebiil", cipher.encrypt("Hello"));

        App cipher2 = new App(3);
        assertEquals("Hello", cipher.decrypt("Ebiil"));

    }


    public void testLargeShift(){
        App cipher = new App(29); // 29 == 3 mod 26
        assertEquals("Khoor", cipher.encrypt("Hello"));
        App cipher2 = new App(-29); // -29 == -3 mod 26
        assertEquals("Khoor", cipher2.decrypt("Hello"));
    }

}
