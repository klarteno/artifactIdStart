package com.puzzles.agent;

import com.puzzles.tables.GridState;
import com.puzzles.tables.Location;

public class MoveBackwards implements CommandsGrid {
    private GridState gridState;

    public  MoveBackwards(GridState gridState){
        this.setGridState(gridState);
    }

    @Override
    public void setGridState(GridState gridState) {
        this.gridState = gridState;
    }

    @Override
    public GridState getGridState() {
        return this.gridState;
    }

    @Override
    public void execute(){
        Location location = this.gridState.getLocation();

        switch ( this.gridState.getDirection() ){
            case NORTH:
                //location.setPointX(location.getPointX());
                location.setPointY(location.getPointY() + 1);
                break;

            case EAST:
                location.setPointX(location.getPointX()-1);
                //location.setPointY(location.getPointY());
                break;

            case WEST:
                location.setPointX(location.getPointX()+1);
                //location.setPointY(location.getPointY());
                break;

            case SOUTH:
                //location.setPointX(location.getPointX());
                location.setPointY(location.getPointY()-1);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unknown direction " );
        }

        this.gridState.setLocation(location);
    }
}
