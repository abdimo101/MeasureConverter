package com.testing.measureconverter.Measures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GradesTest {



    @ParameterizedTest
    @MethodSource("gradeData")
    void convertToAmerican(String danishGrade, String americanGrade) {
        Grades grades = new Grades(danishGrade);

        assertEquals(americanGrade, grades.convertToAmerican());
    }

    private static Stream<Arguments> gradeData() {
        return Stream.of(
                Arguments.of("12", "A+"),
                Arguments.of("10", "A"),
                Arguments.of("7", "B"),
                Arguments.of("4", "C"),
                Arguments.of("02", "D"),
                Arguments.of("00", "F"),
                Arguments.of("-3", "F")

        );
    }
}