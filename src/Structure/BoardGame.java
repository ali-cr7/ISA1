package Structure;
import java.util.Arrays;
import java.util.Scanner;
public class BoardGame {

    private int numberOfSquares=85;
    public  String []boardGame =new String[numberOfSquares];
    public  String []aiBoard =new String[numberOfSquares];
    public static String[] playerStones = {"H1", "H2", "H3", "H4"};
    public static String[] aiStones = {"B1", "B2", "B3", "B4"};


    public  static  boolean isEmpty= false;
    public  static  boolean isEmpty2= false;
    private String type1="Horse Stones";
    private String type2="Cube Stones";
    public BoardGame(){
        for(int i=0;i<numberOfSquares;i++) {
//            if (i == 1) {
//                boardGame[i] = "s";
//            }

            if (i == 11) {
                boardGame[i] = "P";
            }
            if (i == 8) {
                boardGame[i] = "H1";
            }
            else if (i == 22) {
                boardGame[i] = "P";
            }

            else if (i == 28) {
                boardGame[i] = "P";
            }
            else if (i == 39) {
                boardGame[i] = "P";
            }
            else if (i == 45) {
                boardGame[i] = "P";
            }
            else if (i == 56) {
                boardGame[i] = "P";
            }

            else if (i == 62) {
                boardGame[i] = "P";
            }
            else if (i == 73) {
                boardGame[i] = "P";
            }
            else if (i == 84) {
                boardGame[i] = "G";
            }
            else {
                boardGame[i] ="";
            }
        }
        for(int i=0;i<numberOfSquares;i++) {
//            if (i == 1) {
//                boardGame[i] = "s";
//            }

            if (i == 11) {
                aiBoard[i] = "P";
            }
            else if (i == 22) {
                aiBoard[i] = "P";
            }

            else if (i == 28) {
                aiBoard[i] = "P";
            }
            else if (i == 39) {
                aiBoard[i] = "P";
            }
            else if (i == 42) {
                aiBoard[i] = "B1";
            }
            else if (i == 45) {
                aiBoard[i] = "P";
            }
            else if (i == 56) {
                aiBoard[i] = "P";
            }

            else if (i == 62) {
                aiBoard[i] = "P";
            }
            else if (i == 73) {
                aiBoard[i] = "P";
            }

            else if (i == 84) {
                aiBoard[i] = "G";
            }
            else {
                aiBoard[i] ="";
            }
        }



    }


    



    public void printBoardGame (String[] boardGame){
        System.out.println("Player Board" + "\t\t\t\t" + "AI Board");
        for(int i=1; i<numberOfSquares; i++){
            System.out.printf("Number Of Square:%d  %s", i, boardGame[i]);
            System.out.print(" | ");
            System.out.printf("Number Of Square:%d  %s%n", i, aiBoard[i]);
        }
    }





    public static void insertStone(String[] boardGame, int index) {
        // Check if there are any stones left
        if (playerStones.length == 0) {
            System.out.println("No more stones left to insert.");
            return;
        }

        // Insert the first available stone into the board game
        if (boardGame[index] == "") {
            boardGame[index] = playerStones[0];

        } else {
            boardGame[index] += " "+playerStones[0];
        }

        // Remove the inserted stone from the playerStones array
        playerStones = removeTheElement(playerStones, 0);

        // Print the remaining stones
        System.out.println("Remaining stones:");
        for (String stone : playerStones) {
            System.out.println(stone);
        }
        if (playerStones.length==0)
            isEmpty=true;
    }
    public static void insertStone2(String[] boardGame, int index) {
        // Check if there are any stones left
        if (aiStones.length == 0) {
            System.out.println("No more stones left to insert.");
            return;
        }

        // Insert the first available stone into the board game
        if (boardGame[index] == "") {
            boardGame[index] = aiStones[0];

        } else {
            boardGame[index] += " "+aiStones[0];
        }

        // Remove the inserted stone from the playerStones array
        aiStones = removeTheElement(aiStones, 0);

        // Print the remaining stones
        System.out.println("Remaining stones:");
        for (String stone : aiStones) {
            System.out.println(stone);
        }
        if (aiStones.length==0)
            isEmpty2=true;
    }

    public static String[] removeTheElement(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        String[] anotherArray = new String[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    public void isKillHuman() {
        for(int i = 8 ; i <= 42 ; i++) {
            for(int j = 42 ; j <= 76 ; j++) {
                if(boardGame[i].contains("H") && aiBoard[j].contains("B")&&boardGame[i]!="P"&&aiBoard[j]!="P") {
                    System.out.println(boardGame[i] + aiBoard[j]);

                    // Save the killed stone
                    String killedStone = aiBoard[j];

                    // Remove the killed stone from the board
                    aiBoard = removeTheElement(aiBoard, j);

                    // Add the killed stone back to the aiStones array
                    aiStones = Arrays.copyOf(aiStones, aiStones.length + 1);
                    aiStones[aiStones.length - 1] = killedStone;
                }
            }
        }
    }
    public void isKillAi() {
        for(int i = 8 ; i <= 42 ; i++) {
            for(int j = 42 ; j <= 76 ; j++) {
                if(boardGame[j].contains("H") && aiBoard[i].contains("B")&&boardGame[j]!="P"&&aiBoard[i]!="P") {
                    System.out.println(boardGame[j] + aiBoard[i]);

                    // Save the killed stone
                    String killedStone = boardGame[j];

                    // Remove the killed stone from the board
                    boardGame = removeTheElement(boardGame, j);

                    // Add the killed stone back to the playerStones array
                    playerStones = Arrays.copyOf(playerStones, playerStones.length + 1);
                    playerStones[playerStones.length - 1] = killedStone;
                }
            }
        }
    }



}




