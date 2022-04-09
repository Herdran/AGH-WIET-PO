package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    @Test
    void equalsTest(){
        assertTrue(new Vector2d(1, 2).equals(new Vector2d(1, 2)));
        assertFalse(new Vector2d(1, 2).equals(new Vector2d(1, 0)));
        assertFalse(new Vector2d(0, 0).equals("None"));
    }

    @Test
    void toStringTest(){
        assertEquals("(1,2)", new Vector2d(1, 2).toString());
        assertNotEquals("(1,2)", new Vector2d(2, 1).toString());
    }
    @Test
    void precedesTest(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);

        assertTrue(v1.precedes(v1));
        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
    }
    @Test
    void followsTest(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);

        assertTrue(v1.follows(v1));
        assertFalse(v1.follows(v2));
        assertTrue(v2.follows(v1));
    }
    @Test
    void upperRightTest(){
        assertEquals(new Vector2d(3,4), new Vector2d(1, 4).upperRight(new Vector2d(3, 2)));
    }
    @Test
    void lowerLeftTest(){
        assertEquals(new Vector2d(1,2), new Vector2d(1, 4).lowerLeft(new Vector2d(3, 2)));
    }
    @Test
    void addTest(){
        assertEquals(new Vector2d(4,6), new Vector2d(1, 4).add(new Vector2d(3, 2)));
    }
    @Test
    void substractTest(){
        assertEquals(new Vector2d(-2,2), new Vector2d(1, 4).subtract(new Vector2d(3, 2)));
    }
    @Test
    void oppositeTest(){
        assertEquals(new Vector2d(-2,2), new Vector2d(2, -2).opposite());
    }
}
