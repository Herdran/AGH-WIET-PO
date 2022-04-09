package agh.ics.oop;

public class GrassField extends AbstractWorldMap {
    private final int maxCoord;

    public GrassField(int grassFieldsCount) {
        this.maxCoord = (int) Math.ceil(Math.sqrt(grassFieldsCount*10));
        for (int i = 0; i < grassFieldsCount; i++)
            spawnGrass();
    }

    @Override
    public int returnWidth() {
        return 0;
    }

    @Override
    public int returnHeight() {
        return 0;
    }

    public void spawnGrass() {
        Vector2d position = this.lowerLeft;
        do {
            int x = (int) (Math.random() * this.maxCoord);
            int y = (int) (Math.random() * this.maxCoord);
            position = new Vector2d(x, y);
        } while(objectAt(position) != null);

        this.mapElements.put(position, new Grass(position));
    }

    @Override
    public String toString() {
        for (AbstractWorldMapElement mapElement : this.mapElements.values()) {
            this.upperRight = this.upperRight.upperRight(mapElement.getPosition());
            this.lowerLeft = this.lowerLeft.lowerLeft(mapElement.getPosition());
        }

        return super.toString();
    }


}
