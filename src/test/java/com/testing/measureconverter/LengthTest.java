package com.testing.measureconverter;

import com.testing.measureconverter.Measures.Length;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    public void testConvert(){
        Length length = new Length(10, "metric");

        assertEquals(25.4, length.convert());
    }

}