package com.puzzles.agent;

import com.puzzles.tables.GridState;

import java.util.function.Function;

public class FactoryCommands {

    public Function<GridState, GridState> moveBackwards() {
        return GridState -> {
            CommandsGrid move = new MoveBackwards(GridState);
            move.execute();

            return move.getGridState();
        };
    }

    public Function<GridState, GridState> moveForwards() {
        return GridState -> {
            CommandsGrid move = new MoveForward(GridState);
            move.execute();

            return move.getGridState();
        };
    }

    public Function<GridState, GridState> rotateClockwise() {
        return gridState -> {
            Direction newDirection = gridState.getDirection().turnLeft();
            gridState.setDirection(newDirection);

            return gridState;
        };
    }

    public Function<GridState, GridState> rotateCounterClockwise() {
        return gridState -> {
            Direction newDirection = gridState.getDirection().turnRight();
            gridState.setDirection(newDirection);

            return gridState;
        };
    }
/*
    public Function<GridState, String> quit() {
        return gridState -> {
            return Integer.toString(gridState.getLocation().getPointX())
                    .concat(Integer.toString(gridState.getLocation().getPointY())) ;
        };
    }
*/
    public Function<GridState, GridState> quit() {
        return gridState -> gridState;
    }
}

