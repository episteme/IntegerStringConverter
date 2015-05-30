import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {

    private Converter converter;

    @Before
    public void setUp() {
        converter = new Converter();
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("0", converter.intToString(0));
        assertEquals("1", converter.intToString(1));
        assertEquals("-1", converter.intToString(-1));
        assertEquals("1001", converter.intToString(1001));
        assertEquals("987654321", converter.intToString(987654321));
        assertEquals("-123456789", converter.intToString(-123456789));
        assertEquals("1", converter.intToString(001));
        assertEquals("10001", converter.intToString(10001));
    }

    @Test
    public void testToInteger() throws Exception {
        assertEquals(0, (int) converter.stringToInt("0"));
        assertEquals(1, (int) converter.stringToInt("1"));
        assertEquals(-1, (int) converter.stringToInt("-1"));
        assertEquals(1001, (int) converter.stringToInt("1001"));
        assertEquals(987654321, (int) converter.stringToInt("987654321"));
        assertEquals(-123456789, (int) converter.stringToInt("-123456789"));
        assertEquals(001, (int) converter.stringToInt("001"));
        assertEquals(10001, (int) converter.stringToInt("10001"));
        assertEquals(null, converter.stringToInt(null));
    }

}