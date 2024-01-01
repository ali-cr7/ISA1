package Throwing;
import Logic.Movement;
import Structure.BoardGame;

import java.util.Random;
import java.util.Scanner;

public class Playing {
    private Random random = new Random();
    private int score = 0; // Add a score field
    private Scanner input=new Scanner(System.in);

    private int flip() {
        return random.nextInt(2);
    }

    public  int throwStones() { // Remove the unnecessary parameter
        //score return for zero again.
        score=0;
        for (int i = 0; i < 6; i++) {
            int result = flip();
            addScore(result);
        }
        return score;// Return the final score
    }


    public static boolean checkIsEmpty(BoardGame boardGame) {
        for (int i = 0; i < boardGame.boardGame.length; i++) {
            if  (boardGame.boardGame[i].contains("H")) {
                System.out.println("The board is not empty.");
                return false;
            }
        }
        System.out.println("The board is empty.");
        return true;
    }

    private void addScore(int number){// Change the return type to void
        score += number; // Update the score field
    }
    public int numberOfMoves(int score){
        if(score==0){
            System.out.println("Shaka");
            return 6;
        }
        if(score==1){
            System.out.println("Dust");
            return 10;
        }
        if(score==2){
            System.out.println("Two");
            return 2;
        }
        if(score==3){
            System.out.println("Three");
            return 3;
        }
        if(score==4){
            System.out.println("Four");
            return 4;
        }
        if(score==5){
            System.out.println("Bing");
            return 24;
        }
        if(score==6){
            System.out.println("Barra");
            return 12;
        }
     else{
         System.out.println("Nothing");
         return 0;
        }
    }

//    public  void playHuman(BoardGame boardGame){
//        while (Movement.checkWinState(boardGame.boardGame)==false) {
//            System.out.println("//////////////");
//            boardGame.printBoardGame(boardGame.boardGame);
//            System.out.println("//////////////");
//            int sum = 0;
//            int numberOfSteps = 0;
//            score =5;
//            System.out.println(score);
//            if (checkIsEmpty(boardGame) == true) {
//                System.out.println("is empty");
//                if (score == 2 || score == 3 || score == 4) {
//                    System.out.println("is empty1");
//                    System.out.println("Computer turn");
//
//                    return;
//                }
//                if (score == 5 || score == 1) {
//                    System.out.println("is empty2");
//                    BoardGame.insertStone(boardGame.boardGame, 1);
//                    playHuman(boardGame);
//                }
//                if (score == 6 || score == 0) {
//                    System.out.println("is empty3");
//                    playHuman(boardGame);
//                }
//            }
//            else if(checkIsEmpty(boardGame) == false) {
//                System.out.println("isn't empty");
//                numberOfSteps = numberOfMoves(score);
//                sum+= numberOfSteps;
//                if (score == 2 || score == 3 || score == 4) {
//                    System.out.println("isn't empty1");
//                    Movement.chooseStoneToMove(boardGame.boardGame, numberOfMoves(score));
//                    System.out.println("computer turn");
//
////                    return;
//                }
//                if (score == 5 || score == 1) {
//                    System.out.println("isn't empty2");
//                    System.out.println("you Have khal choose 1 for extra step choose 2 for insert new stone ");
//                    int num = input.nextInt();
//                    if (num == 1) {
//                        Movement.chooseStoneToMove(boardGame.boardGame, 1);
//                    } else if (num == 2) {
//                        BoardGame.insertStone(boardGame.boardGame, 1);
//                    }
//                    Movement.chooseStoneToMove(boardGame.boardGame, numberOfMoves(score));
//
//                    playHuman(boardGame);
//                }
//                if (score == 6 || score == 0) {
//                    System.out.println("isn't empty3");
//                    Movement.chooseStoneToMove(boardGame.boardGame, score);
//                    playHuman(boardGame);
//                }
//            }
//        }
//        System.out.println("you are the winner");
//
//    }

   public void playHuman(BoardGame boardGame){
        while (Movement.checkWinState(boardGame.boardGame) == false) {
            do {
                System.out.println("//////////////");
                boardGame.printBoardGame(boardGame.boardGame);
                System.out.println("//////////////");

                int sum = 0;
                int numberOfSteps = 0;
                score = throwStones();
                System.out.println(score);
                if (checkIsEmpty(boardGame) == true) {
                    System.out.println("is empty");
                    if (score == 2 || score == 3 || score == 4) {
                        System.out.println("is empty1");
                        System.out.println("Computer turn");
                        break;
                    }
                 else  if (score == 5 || score == 1) {
                        System.out.println("is empty2");
                        BoardGame.insertStone(boardGame.boardGame, 1);
                        break;
                    }
                    else if (score == 6 || score == 0) {
                        System.out.println("is empty3");
                        break;
                    }

                } else if(checkIsEmpty(boardGame) == false) {
                    System.out.println("isn't empty");
                    numberOfSteps = numberOfMoves(score);
                    sum += numberOfSteps;
                    if (score == 2 || score == 3 || score == 4) {
                        System.out.println("isn't empty1");
                        Movement.chooseStoneToMove(boardGame.boardGame, numberOfMoves(score));
                        System.out.println("computer turn");
                        break;
                    }
                   else if (score == 5 || score == 1) {
                        System.out.println("isn't empty2");
                        Movement.chooseStoneToMove(boardGame.boardGame, numberOfMoves(score));
                        System.out.println("you Have khal choose 1 for extra step choose 2 for insert new stone ");
                        int num = input.nextInt();
                        if (num == 1) {
                            Movement.chooseStoneToMove(boardGame.boardGame, 1);
                        } else if (num == 2) {
                            BoardGame.insertStone(boardGame.boardGame, 1);
                        }
                        Movement.chooseStoneToMove(boardGame.boardGame, numberOfMoves(score));
                    }
                   else if (score == 6 || score == 0) {
                        System.out.println("isn't empty3");
                        Movement.chooseStoneToMove(boardGame.boardGame, numberOfMoves(score));
                    }
                }
            } while (Movement.checkWinState(boardGame.boardGame) == false);
        }
        System.out.println("you are the winner");
    }



}






