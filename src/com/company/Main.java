package com.company;

import Logic.Movement;
import Structure.BoardGame;
import Throwing.Playing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BoardGame boardGame = new BoardGame();
        Movement movement= new Movement();
        Playing playing = new Playing();
while (Movement.checkWinState(boardGame.boardGame)!=true) {
    playing.playHuman(boardGame);
}


    }
}
