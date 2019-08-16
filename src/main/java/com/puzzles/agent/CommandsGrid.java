package com.puzzles.agent;

import com.puzzles.tables.GridState;

public interface CommandsGrid {
    public void setGridState(GridState gridState);
    public GridState getGridState();
    public void execute();
}
