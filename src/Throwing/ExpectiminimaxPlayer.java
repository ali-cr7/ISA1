package Throwing;

import Logic.Movement;
import Structure.BoardGame;
import Structure.State;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class ExpectiminimaxPlayer {
    Movement movement = new Movement() ;
Playing playing = new Playing();
BoardGame boardGame = new BoardGame();

    // Expectiminimax function
    public float expectiminimax(BoardGame node, int depth, String player) {
        if (depth <= 0) {
            return heuristicValue(node);
        }

        if (Movement.checkWinState(node) || depth == 0) {
            System.out.println("sssaa");
            boardGame.printBoard(node);
            System.out.println(heuristicValue(node));
            return heuristicValue(node);
        }
        if (player.equals("Max")) {
            float value = Float.NEGATIVE_INFINITY;
            for (BoardGame child :movement.getNextOptions(node, playing.numberOfMoves(playing.throwStones()))) {
                value = Math.max(value, expectiminimax(child, depth - 1, "Min"));
            }
            return value;
        } else if (player.equals("Min")) {
            float value = Float.POSITIVE_INFINITY;
            for (BoardGame child : movement.getNextOptions(node,playing.numberOfMoves(playing.throwStones()))) {
                value = Math.min(value, expectiminimax(child, depth - 1, "Chance"));
            }
            return value;
        } else { // Chance node
            float value = 0;
            for (BoardGame child : movement.getNextOptions(node, playing.numberOfMoves(playing.throwStones()))) {
                value += (1.0 / 6) * expectiminimax(child, depth - 1, "Max"); // Assume equal probability for each outcome of throwStones
            }
            return value;
        }
    }





    //
//
    private float probability(BoardGame child) {
        return 0.5F;
    }
//

    public float heuristicValue(BoardGame node) {


        int B1place = -1;
        int B2place = -1;
        int B3place = -1;
        int B4place = -1;
        int manhattanDistance1=0;
        int manhattanDistance2=0;
        int manhattanDistance3=0;
        int manhattanDistance4=0;
        float finalManhattan= 0;

        int value1=0;
        int value2=0;
        int value3=0;
        int value4=0;

        for(int j=0;j<node.aiBoard.length;j++){
            if(node.aiBoard[j].contains("B1")){
                B1place=j;
                //System.out.println(B1place);
            }
            if(node.aiBoard[j].contains("B2")){
                B2place=j;
                //System.out.println(B2place);
            }
            if(node.aiBoard[j].contains("B3")){
                B3place=j;
                //System.out.println(B3place);
            }
            if(node.aiBoard[j].contains("B4")){
                B4place=j;
                //System.out.println(B4place);
            }
        }

        if (B1place != -1) {
            manhattanDistance1 = calculateManhattanDistance(B1place,84);

        }
        if (B2place != -1) {
            manhattanDistance2 = calculateManhattanDistance(B2place,84);

        }
        if (B3place != -1) {
            manhattanDistance3 = calculateManhattanDistance(B3place,84);

        }
        if (B4place != -1) {
            manhattanDistance4 = calculateManhattanDistance(B4place,84);
        }
        if (B1place == -1) {
            value1=84;
        }
        if (B2place == -1) {
            value2=84;
        }
        if (B3place == -1) {
            value3=84;
        }
        if (B4place == -1) {
            value4=84;
        }
        finalManhattan= manhattanDistance1+manhattanDistance2+manhattanDistance3+manhattanDistance4+value1+value2+value3+value4;
        int bStoneCount = 0;
        for (String stone : node.aiBoard) {
            for (int i = 0; i < stone.length(); i++) {
                if (stone.charAt(i) == 'B') {
                    bStoneCount++;
                }
            }
        }
        int protectedStones =0;
        for (String stone : node.aiBoard) {
            if (stone.contains("P")) {
                for (int i = 0; i < stone.length(); i++) {
                    if (stone.charAt(i) == 'B') {
                        protectedStones++;
                    }
                }
            }
        }
        int GoalStones =0;
        for (String stone : node.aiBoard) {
            if (stone.contains("G")) {
                for (int i = 0; i < stone.length(); i++) {
                    if (stone.charAt(i) == 'B') {
                        GoalStones++;
                    }
                }
            }
        }
        float  bestFinalManhattan = 336 / finalManhattan;
//        System.out.println("the protection");
//        System.out.println(protectedStones);
//        System.out.println("the number of stones");
//        System.out.println(bStoneCount);
//        System.out.println("the number of stones in Goal index");
//        System.out.println(GoalStones);
//        System.out.println("the number of  Killed stones");
//        System.out.println(node.killedStonesCount);
//        System.out.println("the final manhattan");
//        System.out.println(finalManhattan);


        int heuristic = 10 * node.killedStonesCount + 20 * GoalStones + 15 * protectedStones + 30 * bStoneCount;
        if (heuristic!=0){
            return heuristic;
        }


       else
           return  bestFinalManhattan;

    }
    private int calculateManhattanDistance(int x1,int x2) {

        return Math.abs(x1 - x2);
    }



//
//
}