package com.example.tictactoe;

import com.example.tictactoe.model.Board;
import com.example.tictactoe.model.Cell;
import com.example.tictactoe.model.IPlayer;
import com.example.tictactoe.model.Player;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BoardTest {
    public Board board;
    public Cell cell_1;
    public Cell cell_2;
    @Before
    public void setUp() {
        IPlayer player1 = new Player("May", IPlayer.TURN_PLAYER_1);
        IPlayer player2 = new Player("Aron", Player.TURN_PLAYER_2);
        cell_1 = new Cell(player1);
        cell_2 = new Cell(player2);
        board = new Board(player1, player2);
    }

    @Test
    public void nextMove_ok() {
        assertTrue(board.nextMove(0, 0));
    }
    @Test
    public void nextMove_nok() {
        int row = 0;
        int col = 0;
        board.nextMove(row, col);
        // cell cannot be assigned
        assertFalse(board.nextMove(row, col));
    }

    @Test
    public void hasThreeHorizontal_match() {
        board.cells[0][0] = cell_1;
        board.cells[0][1] = cell_1;
        board.cells[0][2] = cell_1;
        assertTrue(board.hasThreeHorizontal());
    }
    @Test
    public void hasThreeHorizontal_different_player() {
        board.cells[0][0] = cell_1;
        board.cells[0][1] = cell_1;
        board.cells[0][2] = cell_2;
        assertFalse(board.hasThreeHorizontal());
    }

    @Test
    public void hasThreeHorizontal_not_match() {
        board.cells[0][0] = cell_1;
        board.cells[0][1] = cell_1;
        assertFalse(board.hasThreeHorizontal());
    }

    @Test
    public void areEqual_ok() {
        assertTrue(board.areEqual(cell_1, cell_1, cell_1));
    }

    @Test
    public void areEqual_not_equal() {
        assertFalse(board.areEqual(cell_1, cell_2));
    }

}//class

