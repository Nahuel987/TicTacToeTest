package com.example.tictactoe.model;

public interface Iboard {

    boolean nextMove(int row,int col);
    boolean hasWinner();
    IPlayer getWinner();
    void switchPlayer();
    boolean isFull();
    //IPlayer getCurrent();
    int getCurrent();













}
