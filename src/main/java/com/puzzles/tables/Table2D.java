package com.puzzles.tables;

public class Table2D implements GridShape {
    private int ROWS = 0;
    private int COLS = 0;
    private Location[] board;

    public Table2D(int X , int Y) {
        this.ROWS = Y;
        this.COLS = X;

        board = new Location[this.ROWS*this.COLS];
    }

    @Override
    public Location at(int row, int col) {
        return board[row * COLS + col];
    }

    @Override
    public boolean isLocationValid(Location location) {
        return  location.getPointX() >= 0 &&
                location.getPointX() < COLS &&
                location.getPointY() >= 0 &&
                location.getPointY() < ROWS;
    }

}
