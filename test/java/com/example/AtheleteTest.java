// Path: /src/test/java/com/example/AthleteTest.java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AthleteTest {

    @Test
    public void testCalculateTotalTime() {
        SkiTime skiTime = new SkiTime(30, 27);
        Athlete athlete = new Athlete(11, "Umar Jorgson", "SK", skiTime, "xxxox", "xxxxx", "xxoxo");
        assertEquals(1857, athlete.calculateTotalTime());
    }
}
