package com.puzzles.commands;

import com.puzzles.agent.Direction;

public enum CommandMove {
    /*
        0 = quit simulation and print results to stout
        1 = move forward one step
        2 = move backwards one step
        3 = rotate clockwise 90 degrees (eg north to east)
        4 = rotate counterclockwise 90 degrees (eg west to south)
    */
    QUIT(0, 'Q'),
    FORWARD(1, 'F'),
    BACKWARD(2, 'B'),
    ROTATE_CLOCKWISE(3, 'R'),
    ROTATE_COUNTER_CLOCKWISE(4, 'L'),
    NONE(5, 'X');

    private final int value;
    private final char shortName;

    private CommandMove(final int newValue, final char shortNameValue) {
        value = newValue;
        shortName = shortNameValue;
    }

    public static CommandMove getFromShortName(final char shortName) {
        for (CommandMove command : CommandMove.values()) {
            if (command.shortName == shortName) {
                return command;
            }
        }
        return CommandMove.NONE;
    }

    public static CommandMove getFromIndexNumber(final int number) {
        for (CommandMove command : CommandMove.values()) {
            if (command.value == number) {
                return command;
            }
        }
        return CommandMove.NONE;
    }
}
