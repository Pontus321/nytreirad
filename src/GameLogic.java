import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    // Method to check for a winner or a tie in the game.
    public static String checkWinner(ArrayList<Integer> player1Positions, ArrayList<Integer> player2Positions) {
        List<Integer> topRow = List.of(1, 2, 3);
        List<Integer> midRow = List.of(4, 5, 6);
        List<Integer> botRow = List.of(7, 8, 9);
        List<Integer> leftCol = List.of(1, 4, 7);
        List<Integer> midCol = List.of(2, 5, 8);
        List<Integer> rightCol = List.of(3, 6, 9);
        List<Integer> cross1 = List.of(1, 5, 9);
        List<Integer> cross2 = List.of(7, 5, 3);

        List<List<Integer>> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List<Integer> l : winning) {
            if (player1Positions.containsAll(l)) {
                return "Player 1 wins!";
            } else if (player2Positions.containsAll(l)) {
                return "Player 2 wins!";
            } else if (player1Positions.size() + player2Positions.size() == 9) {
                return "Tie";
            }
        }
        return "";
    }
    // Update the game board with the player's piece (X or O) at the specified position.
    public static void placePiece(char[][] gameBoard, int pos, String user, ArrayList<Integer> player1Positions, ArrayList<Integer> player2Positions) {
        char symbol = ' ';
        if (user.equals("Player 1")) {
            player1Positions.add(pos);
            symbol = 'X';
        } else if (user.equals("Player 2")) {
            player2Positions.add(pos);
            symbol = 'O';
        }

        //row/col index 0 on a 2d array
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }
    }
}



