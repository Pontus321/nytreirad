import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // These two ArrayLists will keep track of the positions of Player 1 and Player 2 on the game board.
    //player class gamelogic
    static ArrayList<Integer> player1Positions = new ArrayList<>();
    static ArrayList<Integer> player2Positions = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            // Create a 3x3 game board using a 2D character array.
            char[][] gameBoard = {
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};

            while (true) {
                // Print the game board to the console.
                GameBoard.printGameBoard(gameBoard);

                // Allow Player 1 to make their move.
                Player.playerTurn(gameBoard, "Player 1", player1Positions, player2Positions);


                // Check if anyone wins or if it's a tie.
                String result = GameLogic.checkWinner(player1Positions, player2Positions);
                if (result.equals("Player 1 wins!")) {
                    System.out.println("Player 1 wins!");
                    break;
                } else if (result.equals("Player 2 wins!")) {
                    System.out.println("Player 2 wins!");
                    break;
                } else if (result.equals("Tie")) {
                    System.out.println("It's a tie!");
                    break;
                }

                // Print the final state of the game board.
                GameBoard.printGameBoard(gameBoard);

                // Allow Player 2 to make their move.
                Player.playerTurn(gameBoard, "Player 2", player1Positions, player2Positions);
                result = GameLogic.checkWinner(player1Positions, player2Positions);
                if (result.equals("Player 1 wins!")) {
                    System.out.println("Player 1 wins!");
                    break;
                } else if (result.equals("Player 2 wins!")) {
                    System.out.println("Player 2 wins!");
                    break;
                } else if (result.equals("Tie")) {
                    System.out.println("It's a tie!");
                    break;
                }
            }

            // Print the final state of the game board.
            GameBoard.printGameBoard(gameBoard);

            // Ask the players if they want to play another round.
            System.out.println("Do you want to play again? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (!response.equalsIgnoreCase("Y")) {
                break;
            }

            // Reset the player positions when the game is played again.
            player1Positions.clear();
            player2Positions.clear();
        }
    }

}