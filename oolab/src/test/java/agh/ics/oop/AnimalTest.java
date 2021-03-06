package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    void moveTest() {
        OptionsParser optionsParser = new OptionsParser();

        assertEquals(new Vector2d(2, 2), new Animal().getPosition());
        assertEquals(new Vector2d(2, 3), new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"f"})).getPosition());
        assertEquals(new Vector2d(2, 1), new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"b"})).getPosition());

        assertEquals(MapDirection.NORTH, new Animal().getDirection());
        assertEquals(MapDirection.EAST, new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"r"})).getDirection());
        assertEquals(MapDirection.SOUTH, new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"r", "r"})).getDirection());
        assertEquals(MapDirection.WEST, new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"l"})).getDirection());
        assertEquals(MapDirection.SOUTH, new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"l", "l"})).getDirection());

        assertEquals(new Vector2d(2, 0), new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"f", "f", "f"})).getPosition());
        assertEquals(new Vector2d(1, 2), new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"r", "f", "f", "f", "f"})).getPosition());
        assertEquals(new Vector2d(2, 4), new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"b", "b", "b"})).getPosition());
        assertEquals(new Vector2d(4, 2), new Animal().move((ArrayList<MoveDirection>) optionsParser.parse(new String[]{"r", "b", "b", "b"})).getPosition());
    }
}