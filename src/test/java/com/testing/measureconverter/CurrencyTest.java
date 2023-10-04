package com.testing.measureconverter;
import com.testing.measureconverter.Measures.Currency;
import org.junit.jupiter.api.BeforeEach;


class CurrencyTest {
    private Currency currency;

    @BeforeEach
    void setUp() {
        currency = new Currency("DKK");
    }

}
