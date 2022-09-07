
/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 7, 2022
 * Windows 10
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.*;

public class AppTest {
    @Test
    public void testApp() {
        App app = new App();
        assertEquals(17721.96, app.computeBalance(10000, 4.5, 13, false), 0.1);
        assertEquals(17930.28, app.computeBalance(10000, 4.5, 13, true), 0.1);
        assertEquals(15674.32, app.computeBalance(10000, 3.0, 15, true), 0.1);
        // assertEquals(31159.35, app.computeBalance(10000, 3.0, 15, true), 0.1);
    }
}
