import java.util.ArrayList;
import java.util.List;

class GameBoard {
    private char[][] gameBoard;
    private ArrayList<Integer> player1Positions;
    private ArrayList<Integer> player2Positions;

    public GameBoard() {
        // Initialize the game board with an empty state and create player position lists.
        gameBoard = new char[][] {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        player1Positions = new ArrayList<>();
        player2Positions = new ArrayList<>();
    }

    public void placePiece(int pos, String user) {
        // Place the player's symbol (X or O) on the game board based on the position and user.
        char symbol = ' ';
        if (user.equals("Player 1")) {
            symbol = 'X';
            player1Positions.add(pos);
        } else if (user.equals("Player 2")) {
            symbol = 'O';
            player2Positions.add(pos);
        }

        switch (pos) {
            // Update the game board with the player's symbol at the specified position.
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

    public boolean isPositionTaken(int pos) {
        // Check if the specified position is already occupied by a player.
        return player1Positions.contains(pos) || player2Positions.contains(pos);
    }

    public String checkWinner() {
        // Define winning combinations and check if a player has won or if it's a tie.
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
        return "";  // If no winner or tie, return an empty string.
    }

    public void printGameBoard() {
        // Print the current state of the game board to the console.
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void resetBoard() {
        // Reset the game board and player positions for a new game.
        gameBoard = new char[][] {};
        player1Positions.clear();
        player2Positions.clear();
    }
}
