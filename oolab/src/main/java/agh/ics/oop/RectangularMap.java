package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    public RectangularMap(int width, int height) {
        this.width = width > 0 ? width : 5;
        this.height = height > 0 ? height : 5;
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(this.width-1, this.height-1);
    }
    public int width;
    public int height;

    @Override
    public int returnWidth(){
        return this.width;
    }
    @Override
    public int returnHeight() {
        return this.height;
    }
}
