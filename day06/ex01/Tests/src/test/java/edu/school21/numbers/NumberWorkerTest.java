package edu.school21.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

public class NumberWorkerTest {
    NumberWorker nw = new NumberWorker();

    @ParameterizedTest
    @ValueSource(ints = {11, 3, 5, 17, 359})
    public void isPrimeForPrimes (int number) {
        Assertions.assertTrue(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {111, 22222, 6, 15, 35})
    public void isPrimeForNotPrimes (int number) {
        Assertions.assertFalse(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -2, 1, -15, -1})
    public void isPrimeForIncorrectNumbers (int number) {
        Assertions.assertThrows(IllegalNumberException.class, () -> {
            nw.isPrime(number);
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void digitsSumCheckValid(int input, int result) {
        Assertions.assertEquals(result, nw.digitsSum(input));
    }
}
