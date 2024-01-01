package Logic;

import Structure.BoardGame;
import Throwing.Playing;

import java.util.Scanner;

public class Movement {
    private static Scanner input=new Scanner(System.in);
    private int numberOfStonesRemaining = 4; // Assuming each player starts with 4 stones
    private int Position = -1; // Initialize H position outside the loop



    public static void moveStone(String[] boardGame, String stone, int steps) {
        // Find the current index of the stone
        int currentIndex = -1;
        for (int i = 0; i < boardGame.length; i++) {
            if (boardGame[i] != null && boardGame[i].contains(stone)) {
                currentIndex = i;
                break;
            }
        }
        // Check if the stone was found
        if (currentIndex == -1) {
            System.out.println("Stone " + stone + " not found in the board game.");
            return;
        }
        // Calculate the remaining steps to the end of the array
        int remainingStepsToEnd = boardGame.length - 1 - currentIndex;

        if (steps > remainingStepsToEnd) {
            if(steps==24||steps==10) {
                System.out.println("you Have khal choose 1 for extra step choose 2 for insert new stone ");
                int num = input.nextInt();
                if (num == 1) {
                    Movement.chooseStoneToMove(boardGame, 1);
                } else if (num == 2) {
                    BoardGame.insertStone(boardGame, 1);
                }
            }
            System.out.println("Stone " + stone + " cannot move " + steps + " steps. Only " + remainingStepsToEnd + " steps remaining to reach the last index.");
            System.out.println("press 1 to  choose another stone to move or 2 to throw again");
            int num1 = input.nextInt();
            if (num1 == 1) {
                chooseStoneToMove( boardGame, steps);
            } else if (num1 == 2) {
              return;
            }

//
        }

        // Calculate the new index
        int newIndex = (currentIndex + steps) % boardGame.length;

        // Remove the stone from the old index
        String[] stonesAtCurrentIndex = boardGame[currentIndex].split(" ");
        for (int i = 0; i < stonesAtCurrentIndex.length; i++) {
            if (stonesAtCurrentIndex[i].equals(stone)) {
                stonesAtCurrentIndex[i] = "";
                break;
            }
        }
        boardGame[currentIndex] = String.join(" ", stonesAtCurrentIndex);

        // Add the stone to the new index
        if (boardGame[newIndex] =="") {
            boardGame[newIndex] = stone;
            System.out.println("hellllo");
        } else {
            boardGame[newIndex] += " " + stone;
            System.out.println("heelll333");
        }

        System.out.println("Stone " + stone + " moved to index " + newIndex + ".");
    }

    public static void chooseStoneToMove(String[] boardGame, int steps) {
        Scanner scanner = new Scanner(System.in);

        // Display the "H" stones in the board game
        System.out.println("H stones in the board game:");
        for (int i = 0; i < boardGame.length; i++) {
            if (boardGame[i] != null && boardGame[i].contains("H")) {
                System.out.println("Index: " + i + ", Stone: " + boardGame[i]);
            }
        }

        // Ask the user to choose a stone to move
        System.out.println("Enter the index of the stone you want to move:");
        String index = scanner.next();

        // Move the chosen stone
        moveStone(boardGame, index, steps);

    }




    public static boolean checkWinState(String[] boardGame) {
        // Get the string at the last index of the board game array
        String lastSquare = boardGame[boardGame.length - 1];

        // Check if the last square contains all four stones
        if (lastSquare != null && lastSquare.contains("H1") && lastSquare.contains("H2") && lastSquare.contains("H3") && lastSquare.contains("H4")) {
            return true;
        } else {
            return false;
        }
    }


}
