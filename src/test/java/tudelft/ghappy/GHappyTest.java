package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
    @ParameterizedTest(name = "name={0}: ({1}) = result={2}")
    @CsvSource({
            // Provided samples
            "Samples,xxggxx,true", "Samples,xxgxx,false", "Samples,xxggyygxx,false",
            // No g variants
            "No g,abdef,false", "One g,g,false", "2 g,gg,true",
            // Funnies
            "Empty,'',false", "Null,,false"
    })
    public void testGHappy(String partition, String testSr, boolean expectedResult) {
        boolean result = new GHappy().gHappy(testSr);
        Assertions.assertTrue(expectedResult == result);
    }
}
