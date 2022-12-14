package agh.ics.oop;

import java.util.Map;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(){
        return switch(this){
            case NORTH -> "^";
            case SOUTH -> "v";
            case WEST -> "<";
            case EAST -> ">";
        };
    }

    public MapDirection next(){
        return switch(this){
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;

        };
    }
    public MapDirection previous(){
        return this.next().next().next();
        }

    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }

}
