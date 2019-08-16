package com.puzzles.tables;

public interface GridShape {

    public Location at(int row, int col);
    public boolean isLocationValid(Location location);

}
