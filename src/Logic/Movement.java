package Logic;
import Structure.BoardGame;
import Structure.Positions;
import Throwing.ExpectiminimaxPlayer;
import Throwing.Playing;

import java.util.*;

public class Movement {
    private static Scanner input=new Scanner(System.in);
    public  static boolean isKilled =false;
    BoardGame boardGame = new BoardGame();
    ExpectiminimaxPlayer expectiminimaxPlayer = new ExpectiminimaxPlayer();
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
            System.out.println("Stone " + stone + " cannot move " + steps + " steps. Only " + remainingStepsToEnd + " steps remaining to reach the last index.");
            if(steps==24||steps==10) {
                System.out.println("you Have khal choose 1 for extra step choose 2 for insert new stone ");
                int num = input.nextInt();
                if (num == 1) {
                    Movement.chooseStoneToMove(boardGame, 1);
                } else if (num == 2) {
//                    boardGame.insertStone(boardGame, 1);
                }
            }
            System.out.println("press 1 to  choose another stone to move or 2 to throw again");
            int num1 = input.nextInt();
            if (num1 == 1) {
                chooseStoneToMove( boardGame, steps);
            } else if (num1 == 2) {
              return;
            }
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
//            System.out.println("hellllo");
        } else {
            boardGame[newIndex] += " " + stone;
//            System.out.println("heelll333");
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

            public boolean canMoveStone(BoardGame boardGame, String stone, int steps) {
            boolean hasBStone = false;

            for (String square : boardGame.aiBoard) {
                if (square != null && square.contains(stone)) {
                    hasBStone = true;
                    break;
                }
            }
            if (!hasBStone) {

                return false;
            }

            int currentIndex = -1;
            for (int i = 0; i < boardGame.aiBoard.length; i++) {
                if (boardGame.aiBoard[i] != null && boardGame.aiBoard[i].contains(stone)) {
                    currentIndex = i;
                    break;
                }

            }
            if(currentIndex+steps <= 42) {    int correspondingIndex = currentIndex+34;
                if (boardGame.boardGame[correspondingIndex+steps].contains("H")&&boardGame.boardGame[correspondingIndex+steps].contains("P")) {
                    return  false;
                }}

          if(currentIndex+steps > 42){  int correspondingIndex1 = currentIndex-34;
              if (boardGame.boardGame[correspondingIndex1+steps].contains("H")&&boardGame.boardGame[correspondingIndex1+steps].contains("P")) {
                  return  false;
              }}
            if (currentIndex == -1) {
                System.out.println("Stone " + stone + " not found in the board game.");
                return false;
            }

            int remainingStepsToEnd = boardGame.aiBoard.length - 1 - currentIndex;
            if (steps > remainingStepsToEnd) {
                return false;
            }

            // New condition: If the corresponding index in the human array contains "P" and an H stone, return false


            return true;
        }

            public  void moveStone3(BoardGame boardGame,String stone, int steps){
                int currentIndex = -1;
          for (int i = 0; i < boardGame.aiBoard.length; i++) {
        if (boardGame.aiBoard[i] != null && boardGame.aiBoard[i].contains(stone)) {
            currentIndex = i;
            break;
        }
    }
    // Calculate the new index
    int newIndex = (currentIndex + steps) % boardGame.aiBoard.length;
    // Remove the stone from the old index
    String[] stonesAtCurrentIndex = boardGame.aiBoard[currentIndex].split(" ");
    for (int i = 0; i < stonesAtCurrentIndex.length; i++) {
        if (stonesAtCurrentIndex[i].equals(stone)) {
            stonesAtCurrentIndex[i] = "";
            break;
        }
    }
    boardGame.aiBoard[currentIndex] = String.join(" ", stonesAtCurrentIndex);
    // Add the stone to the new index
    if (boardGame.aiBoard[newIndex] =="") {
        boardGame.aiBoard[newIndex] = stone;
    } else {
        boardGame.aiBoard[newIndex] += " " + stone;
    }
    System.out.println("Stone " + stone + " moved to index " + newIndex + ".");
                // Add this line at the beginning
                if(newIndex <= 42) {
                    int correspondingIndex = newIndex +34;
//                    System.out.println(newIndex);
//                    System.out.println(correspondingIndex);
                    if (boardGame.boardGame[correspondingIndex].contains("H")) {

                        isKilled= true;

                        // Save the killed stones
                        String killedStones = boardGame.boardGame[correspondingIndex];
                        String[] stones = killedStones.split(" ");
                        // Increment the counter by the number of killed stones
                       boardGame.killedStonesCount += stones.length; // Add this line
                        // Remove the killed stones from the board
                        boardGame.boardGame[correspondingIndex]=" ";
                        // Add the killed stones back to the playerStones array
                        for(String stone1 : stones){
                            boardGame.playerStones = Arrays.copyOf(boardGame.playerStones, boardGame.playerStones.length + 1);
                            boardGame.playerStones[boardGame.playerStones.length - 1] = stone1;
                        }
                    }
                }
                if(newIndex > 42){
                    int correspondingIndex = newIndex-34;
//                    System.out.println(newIndex);
//                    System.out.println(correspondingIndex);
                    if (boardGame.boardGame[correspondingIndex].contains("H")) {

                        isKilled= true;

                        // Save the killed stones
                        String killedStones = boardGame.boardGame[correspondingIndex];
                        String[] stones = killedStones.split(" ");
                        // Increment the counter by the number of killed stones
                       boardGame.killedStonesCount += stones.length; // Add this line
                        // Remove the killed stones from the board
                        boardGame.boardGame[correspondingIndex]=" ";
                        // Add the killed stones back to the playerStones array
                        for(String stone1 : stones){
                            boardGame.playerStones = Arrays.copyOf(boardGame.playerStones, boardGame.playerStones.length + 1);
                            boardGame.playerStones[boardGame.playerStones.length - 1] = stone1;
                        }
                    }
                }

             //   System.out.println("Number of stones killed: " + boardGame.killedStonesCount); // Print the total number of stones killed



            }
            public HashSet<Positions> checkMove(BoardGame g, int steps ) {
        HashSet<Positions> moves = new HashSet<>();

        // Iterate over all AI stones

        for (String stone : boardGame.aiStones) {
            // Check if the stone can move the given number of steps
            if (canMoveStone(boardGame,stone, steps)) {
                // If the stone can move, calculate the new position
                int currentIndex = -1;
                for (int i = 0; i < g.aiBoard.length; i++) {
                    if (g.aiBoard[i] != null && g.aiBoard[i].contains(stone)) {
                        currentIndex = i;
                        break;
                    }
                }
                int newPosition = (currentIndex + steps) % g.aiBoard.length;

                // Add the move (stone, newPosition) to the set of possible moves
                moves.add(new Positions(newPosition));
            }
        }
        return moves;
    }

            public List<BoardGame> getNextOptions(BoardGame s, int steps) {
        List<BoardGame> next = new LinkedList<>();
        String[] aiStones = {"B4", "B3", "B2", "B1"};

        if (steps == 10 || steps == 25) {
            // For each existing stone, consider the option of taking an extra step without adding a new stone
            for (String currentStone : aiStones) {
                BoardGame copy = new BoardGame(s);
                if (canMoveStone(copy, currentStone, steps + 1)) {
                    moveStone3(copy, currentStone, steps + 1);
                   System.out.println("Heuristic value for stone " + currentStone + " after an extra step: " + expectiminimaxPlayer.heuristicValue(copy)); // Print the heuristic value for the current stone after an extra step
                    boardGame.printBoard(copy);
                    next.add(copy);
                }
            }

            // Create a copy of the board with a new stone added
            BoardGame copyWithNewStone = new BoardGame(s);
            boardGame.insertStone2(copyWithNewStone.aiBoard, 1); // Add a new stone to the board, for example at position 1

//

            for (String currentStone : aiStones) {
                BoardGame copy=  deepCopyBoardGame(copyWithNewStone);
                if (canMoveStone(copy, currentStone, steps)) {
                    moveStone3(copy, currentStone, steps);
                    System.out.println("Heuristic value for stone " + currentStone + " after moving with the new stone added: " + expectiminimaxPlayer.heuristicValue(copy)); // Print the heuristic value for the current stone after moving with the new stone added
                   boardGame.printBoard(copy);
                    next.add(copy);
                }
            }
        } else {
            // For all other steps, handle the normal moves for all existing stones
            for (String currentStone : aiStones) {
                BoardGame copy = new BoardGame(s);
                if (canMoveStone(copy, currentStone, steps)) {
                    moveStone3(copy, currentStone, steps);
                    System.out.println("Heuristic value for stone " + currentStone + ": " + expectiminimaxPlayer.heuristicValue(copy)); // Print the heuristic value for the current stone
                    next.add(copy);
                }
            }
        }
        System.out.println(next.size());
        return next;
    }

             private BoardGame deepCopyBoardGame(BoardGame original) {
        String[] copiedAiBoard = Arrays.copyOf(original.aiBoard, original.aiBoard.length);
        String[] copiedHumanBoard = Arrays.copyOf(original.boardGame, original.boardGame.length);
        String[] copiedPlayerStones = Arrays.copyOf(original.playerStones, original.playerStones.length);
        String[] copiedAiStones = Arrays.copyOf(original.aiStones, original.aiStones.length);


        int killedStonesCount = original.killedStonesCount;
        int stonesNumbers= original.stonesNumbers;
        // Perform deep copy of mutable fields if needed
        // For example, if there are mutable objects within the BoardGame class, you should create copies of them as well

        BoardGame copy = new BoardGame(original.boardGame.length,copiedAiBoard,copiedHumanBoard,stonesNumbers,killedStonesCount,copiedAiStones,copiedPlayerStones);
        return copy;
    }

              public static boolean checkWinState(BoardGame g) {
        // Get the string at the last index of the board game array
        String lastSquare =g.boardGame[g.boardGame.length - 1];

        // Check if the last square contains all four stones
        if (lastSquare != null && lastSquare.contains("H1") && lastSquare.contains("H2") && lastSquare.contains("H3") && lastSquare.contains("H4")) {
            System.out.println("human won");
            return true;
        }
         if (lastSquare != null && lastSquare.contains("B1") && lastSquare.contains("B2") && lastSquare.contains("B3") && lastSquare.contains("B4")) {
            System.out.println("AI won");
            return true;
        }else {
            return false;
        }
    }
}