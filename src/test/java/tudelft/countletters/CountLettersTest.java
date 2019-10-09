package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CountLettersTest {

    @ParameterizedTest(name = "name={0}: ({1}) = result={2}")
    @CsvSource({
            // Provided samples
            "Multiple S,cats|dogs,2", "Multiple R,catr|dogr,2"
    })
    public void multipleMatchingWords(String partition, String testSr, int expectedResult) {
        int words = new CountLetters().count(testSr);
        Assertions.assertEquals(expectedResult, words);
    }

    @ParameterizedTest(name = "name={0}: ({1}) = result={2}")
    @CsvSource({
            // Provided samples
            "Last not S,cats|dog,1", "Last not R,catr|dog,1"
    })
    public void lastWordDoesNotMatch(String partition, String testSr, int expectedResult) {
        int words = new CountLetters().count(testSr);
        Assertions.assertEquals(expectedResult, words);
    }

    @ParameterizedTest(name = "name={0}: ({1}) = result={2}")
    @CsvSource({
            // Provided samples
            "First not S,cat|dogs,1", "First not R,cat|dogr,1"
    })
    public void firstWordDoesNotMatch(String partition, String testSr, int expectedResult) {
        int words = new CountLetters().count(testSr);
        Assertions.assertEquals(expectedResult, words);
    }
}