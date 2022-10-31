package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class RectangularMap  implements IWorldMap{

    IWorldMap map = this;
    private final Vector2d upperRight;
    private final Vector2d lowerLeft = new Vector2d(0,0);
    private final List<Animal> animals = new LinkedList<>();

    public RectangularMap(int width, int height){

        this.upperRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRight) && position.follows(lowerLeft) && !this.isOccupied(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : this.animals){
            if(animal.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        for(Animal livingAnimal : this.animals){
            if (livingAnimal==animal){
                return false;
            }
        }
        this.animals.add(animal);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : this.animals){
            if(animal.isAt(position))
                return animal;
        }
        return null;
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this.map);
        return visualizer.draw(this.lowerLeft,this.upperRight);
    }
}