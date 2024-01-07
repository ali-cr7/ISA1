package com.company;

import Logic.Movement;
import Structure.BoardGame;
import Throwing.Playing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BoardGame boardGame = new BoardGame();
        Playing playing = new Playing();

            playing.playHuman(boardGame);



    }
}
