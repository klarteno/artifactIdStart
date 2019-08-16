package com.puzzles.tables;

import com.puzzles.agent.Direction;

public class GridState {
    private Location location;
    private Direction direction = Direction.NORTH;
    private  GridShape gridShape;

    public  GridState(Location location, GridShape gridShape) {
        this.gridShape = gridShape;
        this.setLocation(location);
    }

    public void setLocation(Location location) {
        boolean isValid = this.gridShape.isLocationValid(location);
        if (!isValid){
            location.setPointX(-1);
            location.setPointY(-1);
            throw new Location.LocationAccessException("invalid location position");
        }

        this.location = location;
    }
    public Location getLocation() {
        return this.location;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }
}




