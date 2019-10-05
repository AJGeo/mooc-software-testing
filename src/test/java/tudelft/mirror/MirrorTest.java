package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class MirrorTest {
    @ParameterizedTest(name = "name={0}: ({1}) = result={2}")
    @CsvSource({
            // Provided samples
            "Samples,abXYZba,ab", "Samples,abca,a", "Samples,aba,aba",
            // No mirrors
            "No Mirror,abdefg,''","One char,a,a","2 Char,aa,aa",
            // Funnies
            "Space, asdfa , a ","Empty,'',''","Null,,''",""
    })
    public void testMirror(String partition, String testSr, String expectedResult) {
        String result = new Mirror().mirrorEnds(testSr);
        Assertions.assertEquals(expectedResult, result);
    }
}
