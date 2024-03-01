package rocks.zipcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayDayTest {

    @Test
    public void pay() {
        PayDay payDay1 = new PayDay();
        java.lang.String string1 = payDay1.pay("Kris", 21.5, 10.0, 0.05);
        assertEquals("Kris 215.00 10.75 204.25", string1);
        PayDay payDay2 = new PayDay();
        java.lang.String string2 = payDay2.pay("Dolio", 19.5, 8.0, 0.03);
        assertEquals("Dolio 156.00 4.68 151.32", string2);
        PayDay payDay3 = new PayDay();
        java.lang.String string3 = payDay2.pay("Karen", 30.5, 12.0, 0.07);
        assertEquals("Karen 366.00 25.62 340.38", string3);
    }
}