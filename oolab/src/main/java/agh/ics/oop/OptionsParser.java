package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] input){
        List<MoveDirection> directionsList = new ArrayList<>();
        for (String arg : input){
            switch(arg){
                case "f", "forward" -> directionsList.add(MoveDirection.FORWARD);
                case "b", "backward" -> directionsList.add(MoveDirection.BACKWARD);
                case "r", "right" -> directionsList.add(MoveDirection.RIGHT);
                case "l", "left" -> directionsList.add(MoveDirection.LEFT);
                default -> {}
            };
        }
        return directionsList;
    }
}