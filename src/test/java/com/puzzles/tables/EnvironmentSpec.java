package com.puzzles.tables;

import com.puzzles.agent.Direction;
import com.puzzles.commands.CommandDispatcher;
import com.puzzles.commands.CommandMove;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("<= Environment Test Specification =>")
public class EnvironmentSpec {
    private EnvironmentSpec(TestInfo testInfo) {
        System.out.println("Working on test " + testInfo.getDisplayName());
    }

    private GridShape env;

    @Test
    public void agentGetsInvalidPositionsTest() {
        int[] values_moves = new int[]{1, 4, 1, 3, 2, 3, 2, 4, 1, 0};

        Table2D table = new Table2D(2, 2);
        GridState gridState = new GridState(new Location(1, 1), table);
        assertTrue(gridState.getDirection() == Direction.NORTH);

        int i, x;
        CommandMove commandMove;
        CommandDispatcher commandDispatcher = new CommandDispatcher();

        for (i = 0; i < values_moves.length; i++) {
            commandMove = CommandMove.getFromIndexNumber(values_moves[i]);
            commandDispatcher.registerHandler(commandMove);
            System.out.print(commandMove + " ");
        }

        Assertions.assertThrows(Location.LocationAccessException.class, () -> {
            commandDispatcher.invokeCommands(gridState);
        });
    }

    @Test
    public void agentCommands() {
        int[] values_moves = new int[]{1, 4, 1, 3, 2, 3, 2, 4, 1, 0};

        Table2D table = new Table2D(4, 4);
        GridState gridState = new GridState(new Location(2, 2), table);
        assertTrue(gridState.getDirection() == Direction.NORTH);

        int i, x;
        CommandMove commandMove;
        CommandDispatcher commandDispatcher = new CommandDispatcher();

        for (i = 0; i < values_moves.length; i++) {
            commandMove = CommandMove.getFromIndexNumber(values_moves[i]);
            commandDispatcher.registerHandler(commandMove);
            //System.out.print(commandMove + " ");
        }
        GridState gridStateLast = commandDispatcher.invokeCommands(gridState);

        assertTrue(gridStateLast.getLocation().getPointX() == 0);
        assertTrue(gridStateLast.getLocation().getPointY() == 1);

    }
}