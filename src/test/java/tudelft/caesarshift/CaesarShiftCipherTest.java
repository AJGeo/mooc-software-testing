package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {
    @ParameterizedTest(name = "name={0}: ({1},{2}) = result={3}")
    @CsvSource({
            // Boundary
            "Across boundary positive,xyz,3,abc", "Across boundary negative,abc,-3,xyz",
            "Across boundary positive single,z,1,a", "Across boundary negative single,a,-1,z",
            "Over boundary positive,xyz,1,yza", "Over boundary negative,abc,-1,zab",
            // Boundary with Space(s)
            "Across boundary positive space, x y z ,3, a b c ", "Across boundary negative space, a b c ,-3, x y z ",
            "Across boundary positive single space, z ,1, a ", "Across boundary negative single space, a ,-1, z ",
            "Over boundary positive space, x y z ,1, y z a ", "Over boundary negative space, a b c ,-1, z a b ",
            // Invalids
            "Invalid num,1258,1,invalid", "Invalid,%$#,1,invalid", "Invalid Empty,'',1,invalid",
            "Invalid null,,1,invalid"
    })
    public void testGHappy(String partition, String testSr, int shift, String expectedResult) {
        String result = new CaesarShiftCipher().CaesarShiftCipher(testSr, shift);
        Assertions.assertEquals(expectedResult, result);
    }
}
