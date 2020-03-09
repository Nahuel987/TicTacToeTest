package com.example.tictactoe.model;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import timber.log.Timber;

public class Board  implements Iboard {

    private static final int BOARD_SIZE = 3;
    @VisibleForTesting
    public Cell[][] cells;
    @VisibleForTesting
    protected IPlayer currentPlayer;
    private IPlayer player1;
    private IPlayer player2;

    public Board(@NonNull IPlayer player1, @NonNull IPlayer player2) {
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }


       //metodo de la implemenacion
    @Override
    public boolean nextMove(int row, int col) {

        if (!isCellEmpty(this.cells[row][col])) return false;
        Cell cell = new Cell(this.currentPlayer);
        this.cells[row][col] = cell;
        return true;
    }

    @Override
    public boolean hasWinner() {
        return hasThreeHorizontal() || hasThreeVertical() || hasThreeDiagonal();

    }

    @Override
    public IPlayer getWinner() {
        return currentPlayer;
    }

    @Override
    public void switchPlayer() {
        Timber.d("switchPlayer() called");
        this.currentPlayer = this.currentPlayer == player1 ? player2 : player1;

    }

    @Override
    public boolean isFull() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (isCellEmpty(cell)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int getCurrent() {

        return currentPlayer.getPlayerTurn();
    }



    //metodos propios de la clase

    @VisibleForTesting()
    public boolean hasThreeHorizontal() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (areEqual(cells[i][0], cells[i][1], cells[i][2])) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting()
    public boolean hasThreeVertical() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (areEqual(cells[0][i], cells[1][i], cells[2][i])) {
                return true;
            }
        }
        return false;
    }


    @VisibleForTesting()
    public boolean hasThreeDiagonal() {
        return areEqual(cells[0][0], cells[1][1], cells[2][2]) ||
                areEqual(cells[0][2], cells[1][1], cells[2][0]);
    }

    @VisibleForTesting()
    public boolean areEqual(@NonNull Cell... cells){

        for (Cell cell : cells) {
            if (isCellEmpty(cell)) {
                return false;
            }
        }
        Cell comparisonBase = cells[0];
        for (int i = 1; i < BOARD_SIZE; i++) {
            if (!comparisonBase.equals(cells[i])) {
                return false;
            }
        }
        return true;

    }

    @VisibleForTesting()
    public boolean isCellEmpty(Cell cell) {
        return cell == null || cell.isEmpty();
    }



}//class
