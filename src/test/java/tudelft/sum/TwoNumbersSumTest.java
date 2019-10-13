package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoNumbersSumTest {
    private TwoNumbersSum twoNumbersSum;

    @BeforeEach
    public void initialize() {
        this.twoNumbersSum = new TwoNumbersSum();
    }

    @Test
    public void addTwoNumbersLessThan10Test() {
        // Add nothing
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(0));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(0));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(0));

        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expectedResult, result);

        // Add something to nothing
        first = new ArrayList<>(Arrays.asList(0));
        second = new ArrayList<>(Arrays.asList(1));
        expectedResult = new ArrayList<>(Arrays.asList(1));

        result = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expectedResult, result);

        // Add nothing to something
        first = new ArrayList<>(Arrays.asList(1));
        second = new ArrayList<>(Arrays.asList(0));
        expectedResult = new ArrayList<>(Arrays.asList(1));

        result = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expectedResult, result);

        // Add something to something < 10
        first = new ArrayList<>(Arrays.asList(3));
        second = new ArrayList<>(Arrays.asList(2));
        expectedResult = new ArrayList<>(Arrays.asList(5));

        result = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expectedResult, result);

        // Add something to something >= 10
        first = new ArrayList<>(Arrays.asList(9));
        second = new ArrayList<>(Arrays.asList(9));
        expectedResult = new ArrayList<>(Arrays.asList(1, 8));

        result = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void addTwoNumbersManyMoreThan10Test() {
        // Add something to something vals < 100; resault > 100
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(8, 2));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(8, 5));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 6, 7));

        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expectedResult, result);

        // Add something to something 100 < vals < 1000; resault < 1000
        first = new ArrayList<>(Arrays.asList(4, 8, 2));
        second = new ArrayList<>(Arrays.asList(4, 8, 5));
        expectedResult = new ArrayList<>(Arrays.asList(9, 6, 7));

        result = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void addTwoNumbersArrLengthDifTest() {
        // Add something to something
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(9, 9));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(4, 8, 5));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(5, 8, 4));

        ArrayList<Integer> result = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expectedResult, result);

        // Add first length < second length
        first = new ArrayList<>(Arrays.asList(7));
        second = new ArrayList<>(Arrays.asList(5, 0));
        expectedResult = new ArrayList<>(Arrays.asList(5, 7));

        result = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expectedResult, result);

        // Add second length < first length
        first = new ArrayList<>(Arrays.asList(1, 0, 7));
        second = new ArrayList<>(Arrays.asList(5, 0));
        expectedResult = new ArrayList<>(Arrays.asList(1, 5, 7));

        result = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertEquals(expectedResult, result);
    }
}
