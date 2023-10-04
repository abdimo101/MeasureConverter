package com.testing.measureconverter.Measures;
import org.junit.jupiter.api.BeforeEach;


class CurrencyTest {
    private Currency currency;

    @BeforeEach
    void setUp() {
        currency = new Currency("DKK");
    }

}
