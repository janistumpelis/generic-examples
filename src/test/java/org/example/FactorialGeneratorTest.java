package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialGeneratorTest {

    @Test
    void testFactorialOfFive() {
        //Given
        FactorialGenerator generator = new FactorialGenerator();
        //When
        int result = generator.generate(5);
        //Then
        Assertions.assertEquals(120, result);
    }

    @Test
    void testFactorialOfZero() {
        //Given
        FactorialGenerator generator = new FactorialGenerator();
        //When
        int result = generator.generate(0);
        //Then
        Assertions.assertEquals(1, result);
    }

    @Test
    void testFactorialOfMinusFive() {
        //Given
        FactorialGenerator generator = new FactorialGenerator();
        //When
        FactorialException error = Assertions.assertThrows(FactorialException.class, () -> {
            generator.generate(-5);
        });
        //Then
        Assertions.assertEquals("Cannot pass in values below zero!", error.getMessage());
    }

}
