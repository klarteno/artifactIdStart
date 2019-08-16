package com.puzzles.commands;

import com.puzzles.agent.FactoryCommands;
import com.puzzles.tables.GridState;

import java.util.*;
import java.util.function.Function;

public class CommandDispatcher {
    private FactoryCommands factoryCommands;

    /**
     * Contains destinations for commands.
     */
    private Deque<Function<GridState, GridState>> dispatch = new ArrayDeque<Function<GridState, GridState>>();

    public CommandDispatcher() {
        factoryCommands = new FactoryCommands();
    }

    public GridState invokeCommands(GridState startGridState){
        GridState gridState = startGridState;
        while(dispatch.size()!=0)
        {
            Function<GridState, GridState> entry = dispatch.removeFirst();
            gridState = entry.apply(gridState);
        }

        return  gridState;
    }

    public void registerHandler(CommandMove commandMove){
        Function<GridState, GridState> command;

        switch (commandMove){
            case FORWARD:
                command =  factoryCommands.moveForwards();
                break;

            case BACKWARD:
                command =  factoryCommands.moveBackwards();
                break;

            case ROTATE_CLOCKWISE:
                command =  factoryCommands.rotateClockwise();
                break;

            case ROTATE_COUNTER_CLOCKWISE:
                command =  factoryCommands.rotateCounterClockwise();
                break;

            case QUIT:
                command =  factoryCommands.quit();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unknown command " );
        }
        dispatch.addFirst(command);
}

    public void removeHandler(CommandMove commandMove){
        dispatch.removeFirstOccurrence(commandMove);
    }

}
