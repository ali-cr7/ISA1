package Structure;
import java.util.Arrays;
import java.util.Scanner;
public class BoardGame {
    private int numberOfSquares=85;
    public  String []aiBoard =new String[numberOfSquares];
    public  String[] aiStones = {"B1", "B2", "B3", "B4"};
    public  String []boardGame =new String[numberOfSquares];
    public  String[] playerStones = {"H1", "H2", "H3", "H4"};
    public  static  boolean isEmpty= false;
    public int killedStonesCount = 0; // Add this line
    public  int stonesNumbers = 0;
    public  static  boolean isEmpty2= false;
    public BoardGame(){

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
            else if (i == 23) {
                aiBoard[i] = "B1";
            }

            else if (i == 28) {
                aiBoard[i] = "P";
            }
            else if (i == 39) {
                aiBoard[i] = "P";
            }
//            else if (i == 42) {
//                aiBoard[i] = "B4";
//            }
//            else if (i == 43) {
//                aiBoard[i] = "B3";
//            }
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

    public BoardGame(int numberOfSquares, String[] aiBoard, String[] boardGame,int stonesNumbers , int killedStonesCount,String[] aiStones,String[] playerStones) {
        this.numberOfSquares = numberOfSquares;
        this.playerStones =playerStones;
        this.aiStones= aiStones;
        this.aiBoard = aiBoard;
        this.boardGame = boardGame;
        this.stonesNumbers= stonesNumbers;
                this.killedStonesCount=killedStonesCount;
    }

    {
        for(int i=0;i<numberOfSquares;i++) {

            if (i == 11) {
                boardGame[i] = "P";
            }
//            if (i == 48) {
//                boardGame[i] = "H1";
//            }
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
                boardGame[i] = "P H1";
            }
            else if (i == 57) {
                boardGame[i] = "H3 H4";
            }

            else if (i == 62) {
                boardGame[i] = "P";
            }
            else if (i == 66) {
                boardGame[i] = "H2";
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
    }

    {
        for(int i=0;i<numberOfSquares;i++) {
            if ( i == 22 || i == 28 || i == 39 || i == 45 || i == 56  || i == 73) {
                aiBoard[i] = "P";
            } else if (i == 11) {
                aiBoard[i] = "P B3";
            }
            else if (i == 62) {
                aiBoard[i] = "P";
            }
//            else if (i == 12) {
//                aiBoard[i] = "B3";
//            }
//            else if (i == 33) {
//                aiBoard[i] = "B2";
//            }
            else if (i == 21) {
                aiBoard[i] = "B4";
            }
           else if (i == 84) {
                aiBoard[i] = "G B2";
            } else {
                aiBoard[i] ="";
            }
        }
    }
    public BoardGame(BoardGame gameModel)
    {
        String[] copiedAiBoard = new String[numberOfSquares];
        System.arraycopy(gameModel.aiBoard, 0, copiedAiBoard, 0, numberOfSquares);
        String[] copiedHumanBoard = new String[numberOfSquares];
        System.arraycopy(gameModel.boardGame, 0, copiedHumanBoard, 0, numberOfSquares);
        String[] copiedPlayerStones = new String[playerStones.length];
        System.arraycopy(gameModel.playerStones, 0, copiedPlayerStones,0,playerStones.length);
        String[] copiedAiStones = new String[aiStones.length];
        System.arraycopy(gameModel.aiStones, 0, copiedAiStones,0,aiStones.length);

        this.killedStonesCount = gameModel.killedStonesCount;
        this.stonesNumbers= gameModel.stonesNumbers;

}
    public void printBoard (BoardGame boardGame){
        System.out.println("AI Board" + "\t" + "Player Board");
        for(int i=1; i<boardGame.numberOfSquares; i++){
            System.out.printf("Square:%d  %s%n", i,boardGame.aiBoard[i]);
            System.out.print("\t\t\t\t");
            System.out.printf("Square:%d  %s%n", i, boardGame.boardGame[i]);
        }
    }

    public  void insertStone(String[] boardGame, int index) {
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
    public  void insertStone2( String [] boardGame, int index) {
        // Check if there are any stones left
        if (boardGame.length == 0) {
//            System.out.println("No more stones left to insert.");
            return;
        }
        if (aiStones.length == 0) {
            // System.out.println("No more aiStones left.");
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
//        System.out.println("Remaining stones:");
//        for (String stone : aiStones) {
//            System.out.println(stone);
//        }
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
                    aiBoard[j] =" ";

                    // Add the killed stone back to the aiStones array
                    aiStones = Arrays.copyOf(aiStones, aiStones.length + 1);
                    aiStones[aiStones.length - 1] = killedStone;
                }
            }
        }
    }


}
