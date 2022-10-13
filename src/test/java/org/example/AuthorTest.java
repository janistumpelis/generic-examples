package org.example;

import org.junit.jupiter.api.*;

public class AuthorTest {


    @Test
    @DisplayName("Testing toString method")
    void testToString() {
        //Given
        Author author = new Author("Peter", "Smith");
        //When
        String result = author.toString();
        //Then
        Assertions.assertEquals("Author - Peter, Smith", result);
    }

    @Test
    void testToStringWithNullValues() {
        //Given
        Author author = new Author(null, null);
        //When
        String result = author.toString();
        //Then
        Assertions.assertEquals("Author - Unknown, Unknown", result);
    }

    @Test
    void testNullValuesAreSet() {
        //Given
        Author author = new Author(null, null);
        //Then
        Assertions.assertEquals("Unknown", author.getName());
        Assertions.assertEquals("Unknown", author.getLastName());

    }

}
