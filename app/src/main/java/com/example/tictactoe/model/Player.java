package com.example.tictactoe.model;

public class Player implements IPlayer {


    private String nombre;
    private int getPlayer;

    public boolean equals(){

        return false;

    }

    public Player(String nombre, int getPlayer) {
        this.nombre = nombre;
        this.getPlayer = getPlayer;
    }

    @Override
    public String getPlayerName() {
        return null;
    }

    @Override
    public int getPlayerTurn() {
        return 0;
    }
}
