package ua.com.foxminded.task4.integerdivision;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntegerDivisionTest {
    IntegerDivision division = new IntegerDivision();
    
    @Test
    void makeDivision_ShouldThrowIllegalArgumentException_WhenInputDivisorIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            division.makeDivision(0, 0);
        });
    }
    
    @Test
    void makeDivision_ShouldReturnZero_WhenDivisorGraterThanDividend() {
        String expected = "1/2=0";
        assertEquals(expected, division.makeDivision(1,2));
    }
    
    @Test
    void makeDivision_ShouldReturnDivisionColumnAndAnswerOne_WhenInputTwoUnits() {
        String expected = "_1|1\n" + 
                          " 1|-\n" + 
                          " -|1\n" +
                          " 0";
        assertEquals(expected, division.makeDivision(1,1));
    }
    
    @Test
    void makeDivision_ShouldReturnDivisionColumnAndAnswerIsEleven_WhenInputDividentIsElevenDivisorIsOne() {
        String expected = "_11|1\n" + 
                          " 1 |--\n" + 
                          " - |11\n" +
                          " _1\n" + 
                          "  1\n" + 
                          "  -\n" + 
                          "  0";
        assertEquals(expected, division.makeDivision(11,1));
    }
    
    @Test
    void makeDivision_ShouldReturnDivisionColumnAndAnswerIsTen_WhenInputDividentIsOneHundredElevenDivisorIsEleven() {
        String expected = "_111|11\n" + 
                          " 11 |--\n" + 
                          " -- |10\n" +
                          "  _1\n" + 
                          "   0\n" + 
                          "   -\n" + 
                          "   1";
        assertEquals(expected, division.makeDivision(111,11));
    }
    
    @Test
    void makeDivision_ShouldReturnDivisionColumnAndAnswerIsTwelveNinetyEight_WhenInputDividentIsThirtyEightNinetyFiveDivisorIsThree(){
        String expected = "_3895|3\n" + 
                          " 3   |----\n" + 
                          " -   |1298\n" +
                          " _8\n" + 
                          "  6\n" + 
                          "  -\n" + 
                          " _29\n"+
                          "  27\n" + 
                          "  --\n" + 
                          "  _25\n" + 
                          "   24\n" + 
                          "   --\n" + 
                          "    1";
        assertEquals(expected, division.makeDivision(3895,3));
    }
    
    @Test
    void makeDivision_ShouldReturnDivisionColumnAndAnswerIsNineHundredSixtyFive_WhenInputDividentIsTwentyEightNinetyFiveDivisorIsThree() {
        String expected = "_2895|3\n" + 
                          " 27  |---\n" + 
                          " --  |965\n" +
                          " _19\n" + 
                          "  18\n" + 
                          "  --\n" + 
                          "  _15\n"+
                          "   15\n" + 
                          "   --\n" + 
                          "    0";
        assertEquals(expected, division.makeDivision(2895,3));
    }
    
    @Test
    void makeDivision_ShouldReturnDivisionColumnAndAnswerIsMaxInt_WhenInputDividentIsMaxIntDivisorIsOne() {
        String expected = "_2147483647|1\n" + 
                          " 2         |----------\n" + 
                          " -         |2147483647\n" +
                          " _1\n" + 
                          "  1\n" + 
                          "  -\n" + 
                          "  _4\n" + 
                          "   4\n" + 
                          "   -\n" + 
                          "   _7\n" + 
                          "    7\n" + 
                          "    -\n" + 
                          "    _4\n" + 
                          "     4\n" + 
                          "     -\n" + 
                          "     _8\n" + 
                          "      8\n" + 
                          "      -\n" + 
                          "      _3\n" + 
                          "       3\n" + 
                          "       -\n" + 
                          "       _6\n" + 
                          "        6\n" + 
                          "        -\n" + 
                          "        _4\n" + 
                          "         4\n" + 
                          "         -\n" + 
                          "         _7\n" + 
                          "          7\n" + 
                          "          -\n" + 
                          "          0"; 
        assertEquals(expected, division.makeDivision(Integer.MAX_VALUE,1));
    }
    
    @Test
    void makeDivision_ShouldReturnDivisionColumnAndAnswerIsOne_WhenInputDividentIsMaxIntDivisorIsMaxInt() {
        String expected = "_2147483647|2147483647\n" + 
                          " 2147483647|-\n" + 
                          " ----------|1\n" +
                          "          0";
        assertEquals(expected, division.makeDivision(Integer.MAX_VALUE,Integer.MAX_VALUE));
    }    
}
