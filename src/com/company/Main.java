package com.company;

import Logic.Movement;
import Structure.BoardGame;
import Throwing.ExpectiminimaxPlayer;
import Throwing.Playing;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BoardGame boardGame = new BoardGame();
        Movement movement = new Movement();
        ExpectiminimaxPlayer expectiminimaxPlayer = new ExpectiminimaxPlayer();
        Playing playing = new Playing();

            playing.playHuman(boardGame);

//                while (!Movement.checkWinState(boardGame)) {
////                    boardGame.printBoard(boardGame);
//          //  Human player 's turn
//           playing.playHuman(boardGame);
//            if (Movement.checkWinState(boardGame)) {
//                 System.out.println("Human won");
////                break;
//            }
//        // AI player's turn
//        BoardGame bestMove = null;
//        float bestValue = Float.NEGATIVE_INFINITY;
//        for (BoardGame child : movement.getNextOptions(boardGame, playing.numberOfMoves(playing.throwStones()))) {
//            float value = expectiminimaxPlayer.expectiminimax(child, 2, "Max");
//            if (value > bestValue) {
//                bestValue = value;
//                bestMove = child;
//            }
//            System.out.println("hi");
//
////            }
//            boardGame = bestMove;
//            boardGame.printBoard(bestMove);
//            System.out.println(expectiminimaxPlayer.heuristicValue(bestMove));
//            if (Movement.checkWinState(boardGame)) {
//                System.out.println("AI won");
//
//            }
//        }
//                }
//        movement.getNextOptions(boardGame, 25);

    }}
