package com.company;

import Logic.Movement;
import Structure.BoardGame;
import Throwing.Playing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BoardGame boardGame = new BoardGame();
        String typeOfPlayer1;

//        int answer=0;
//        System.out.println("Enter The Type of Your Stones 1-Horse Stones 2-Cube Stones");
//        answer=input.nextInt();
//
//        typeOfPlayer1=boardGame.typeOfStones(answer);
//        System.out.println("Type Of Player1 :"+typeOfPlayer1);

        String stoneName;
        Playing playing = new Playing();
        Movement movement = new Movement();

        //int hPosition = -1; // Initialize H position outside the loop
        int score = 0;
        int number = 0;
        int sum = 0;
//        int sum1;


//        while (Movement.checkWinState(boardGame.boardGame) ==false) {
//           boardGame.printBoardGame(boardGame.boardGame);
            playing.playHuman(boardGame);
//            score= playing.throwStones();
//        System.out.println(score);
// boolean win = Movement.checkWinState(boardGame.boardGame);
//        if (win) {
//            System.out.println("Congratulations, you won!");
//        } else {
//            System.out.println("Sorry, you didn't win this time.");
//        }
//
//            while (BoardGame.isEmpty==false){
//                   System.out.println("Enter The index");
//
////        System.out.println("Enter The Type of Your Stones 1-Horse Stones 2-Cube Stones");
////            score = playing.throwStones();
//        int sum1=input.nextInt();
//            BoardGame.insertStone(boardGame.boardGame, sum1);
//            boardGame.printBoardGame(boardGame.boardGame);}
//
//           movement.chooseStoneToMove(boardGame.boardGame,5);
//            boardGame.printBoardGame(boardGame.boardGame);
//    }
//        System.out.println("you win");


    }
}
