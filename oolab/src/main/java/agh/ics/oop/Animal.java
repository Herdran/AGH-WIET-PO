package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement{
    private MapDirection direction = MapDirection.NORTH;
    private final AbstractWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    // Na potrzeby testów
    public Animal() {
        this.position = new Vector2d(2, 2);
        this.map = new RectangularMap(5, 5);
        this.addObserver(this.map);
    }

    public Animal(AbstractWorldMap map) {
        this.map = map;
        this.addObserver(this.map);
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.addObserver(this.map);
    }

    public String toString() {
        return switch (this.direction) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public MapDirection getDirection() {
        return direction;
    }

    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD, BACKWARD -> {
                Vector2d unitVector = this.direction.toUnitVector();
                if (direction == MoveDirection.BACKWARD)
                    unitVector = unitVector.opposite();
                Vector2d newPosition = this.position.add(unitVector);

                if (newPosition.x < 0 ) {
                    newPosition.x += this.map.returnWidth();
                }
                if (newPosition.x >= this.map.returnWidth() ) {
                    newPosition.x -= this.map.returnWidth();
                }
                if (newPosition.y < 0 ) {
                    newPosition.y += this.map.returnHeight();
                }
                if (newPosition.y >= this.map.returnHeight() ) {
                    newPosition.y -= this.map.returnHeight();
                }
                if (!this.map.isOccupied(newPosition)){
                    positionChanged(this.position, newPosition);
                    this.position = newPosition;
                }
            }
        }
    }


    public Animal move(ArrayList<MoveDirection> directions) {
        for (MoveDirection direction : directions)
            this.move(direction);

        return this;
    }

    private void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    private void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observers)
            observer.positionChanged(oldPosition, newPosition);
    }
}
