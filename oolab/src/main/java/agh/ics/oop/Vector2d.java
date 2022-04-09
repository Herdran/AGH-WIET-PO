package agh.ics.oop;

import java.util.Objects;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Vector2d {
    public int x;
    public int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }
    public boolean precedes(Vector2d other){
        return other.x >= this.x && other.y >= this.y;
    }
    public boolean follows(Vector2d other){
        return other.x <= this.x && other.y <= this.y;
    }
    public Vector2d upperRight(Vector2d other){
        return new Vector2d(max(this.x, other.x), max(this.y, other.y));
    }
    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(min(this.x, other.x), min(this.y, other.y));
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(this.x+other.x, this.y+other.y);
    }
    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }
    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        return ((Vector2d) other).x == this.x && ((Vector2d) other).y == this.y;
//        return this == other;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
}
