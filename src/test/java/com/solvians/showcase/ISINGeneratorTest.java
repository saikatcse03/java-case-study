package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ISINGeneratorTest {

    private final ISINGenerator isinGenerator = new ISINGenerator();

    @Test
    void givenValidateISINGenerated_whenISINGeneratorIsCalled_ReturnRandomGeneratedISIN() {
        String randomISIN = isinGenerator.generateISIN();

        assertNotEquals(0, randomISIN);
        assertNotEquals(0, randomISIN.length());
        assertEquals(12, randomISIN.length());
        //exact value check logic can be done with additional technique in testing
    }

    @Test
    void givenValidateISINGenerated_whenISINGeneratorIsCalledTwice_ReturnRandomGeneratedISIN() {
        String randomISIN1 = isinGenerator.generateISIN();
        String randomISIN2 = isinGenerator.generateISIN();

        assertNotEquals(0, randomISIN1);
        assertNotEquals(0, randomISIN1.length());
        assertEquals(12, randomISIN1.length());

        assertNotEquals(0, randomISIN2);
        assertNotEquals(0, randomISIN2.length());
        assertEquals(12, randomISIN2.length());
        //exact value check logic can be done with additional technique in testing
    }
}
