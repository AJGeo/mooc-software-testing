package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralTestWithBeforeEach {

    private RomanNumeral roman;

    @BeforeEach
    public void initialize() {
        this.roman = new RomanNumeral();
    }

    @Test
    public void singleNumber() {
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);

        result = roman.convert("V");
        Assertions.assertEquals(5, result);

        result = roman.convert("X");
        Assertions.assertEquals(10, result);

        result = roman.convert("L");
        Assertions.assertEquals(50, result);

        result = roman.convert("C");
        Assertions.assertEquals(100, result);

        result = roman.convert("D");
        Assertions.assertEquals(500, result);

        result = roman.convert("M");
        Assertions.assertEquals(1000, result);
    }

    @Test
    public void numberWithManyDigits() {
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);

        result = roman.convert("XI");
        Assertions.assertEquals(11, result);

        result = roman.convert("XVI");
        Assertions.assertEquals(16, result);

        result = roman.convert("MDCL");
        Assertions.assertEquals(1650, result);

        result = roman.convert("II");
        Assertions.assertEquals(2, result);

        result = roman.convert("III");
        Assertions.assertEquals(3, result);

        result = roman.convert("VV");
        Assertions.assertEquals(10, result);

        result = roman.convert("VVV");
        Assertions.assertEquals(15, result);

        result = roman.convert("XX");
        Assertions.assertEquals(20, result);

        result = roman.convert("XXX");
        Assertions.assertEquals(30, result);

        result = roman.convert("LL");
        Assertions.assertEquals(100, result);

        result = roman.convert("LLL");
        Assertions.assertEquals(150, result);

        result = roman.convert("CC");
        Assertions.assertEquals(200, result);

        result = roman.convert("CCC");
        Assertions.assertEquals(300, result);

        result = roman.convert("DD");
        Assertions.assertEquals(1000, result);

        result = roman.convert("DDD");
        Assertions.assertEquals(1500, result);

        result = roman.convert("MM");
        Assertions.assertEquals(2000, result);

        result = roman.convert("MMM");
        Assertions.assertEquals(3000, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);

        result = roman.convert("IX");
        Assertions.assertEquals(9, result);

        result = roman.convert("XL");
        Assertions.assertEquals(40, result);

        result = roman.convert("LC");
        Assertions.assertEquals(50, result);

        result = roman.convert("CD");
        Assertions.assertEquals(400, result);

        result = roman.convert("DM");
        Assertions.assertEquals(500, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }

    @Test
    public void invalidString() {
        int result = roman.convert("QWERTYUOPASFGHJKZBN");
        Assertions.assertEquals(0, result);

        result = roman.convert("VX");
        Assertions.assertEquals(0, result);

        result = roman.convert("  ");
        Assertions.assertEquals(0, result);

        result = roman.convert(null);
        Assertions.assertEquals(0, result);
    }

}
