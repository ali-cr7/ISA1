package Structure;
import java.util.Scanner;
public class BoardGame {

    private int numberOfSquares=85;
    public  String []boardGame =new String[numberOfSquares];
    public static String[] playerStones = {"H1", "H2", "H3", "H4"};
    public  static  boolean isEmpty= false;
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



    }


    public void printBoardGame (String[] boardGame){
        for(int i=1;i<numberOfSquares;i++){
            System.out.println("Number Of Square:"+i+"  "+boardGame[i]);
        }
    }



    public String typeOfStones(int number){
        if(number==1){
            return type1;
        }
        else if (number==2){
            return type2;
        }
        else {
            return null;
        }
    }
    public void insertStone(String stoneType,BoardGame boardGame){
        for(int i = 1; i < numberOfSquares; i++){
            if(boardGame.boardGame[1].equals("S")){
                boardGame.boardGame[1] = stoneType;
                break;
            }
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
}




