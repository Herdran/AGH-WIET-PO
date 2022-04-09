package agh.ics.oop;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {

    public void optionsParserTest(MoveDirection[] expected, String[] test){
        List<MoveDirection> result = OptionsParser.parse(test);
        assertEquals(expected.length,result.size());

        for(int i = 0; i < expected.length; i++){
            assertEquals(expected[i], result.get(i));
        }
    }
    @Test
    public void optionsParserTest(){
        String[] test1 = {"Dziekan"};
        String[] test2 = {"f"};
        String[] test3 = {"Andrzej", "l","LEEEEEEEEWAA","f", "left", "forward"};
        String[] test4 = {"x","y","z"};
        String[] test5 = {"R","rr","ASD","backward", "reverse", "r"};

        MoveDirection[] expected1 = {};
        MoveDirection[] expected2 = {MoveDirection.FORWARD};
        MoveDirection[] expected3 = {MoveDirection.LEFT,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.FORWARD};
        MoveDirection[] expected4 = {};
        MoveDirection[] expected5 = {MoveDirection.BACKWARD, MoveDirection.RIGHT};

        optionsParserTest(expected1,test1);
        optionsParserTest(expected2,test2);
        optionsParserTest(expected3,test3);
        optionsParserTest(expected4,test4);
        optionsParserTest(expected5,test5);
    }
}