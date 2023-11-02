import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            GameBoard gameBoard = new GameBoard();  // Create a new game board

            while (true) {
                gameBoard.printGameBoard();  // Print the current state of the game board.
                playerTurn(gameBoard, "Player 1");  // It's Player 1's turn.

                String result = gameBoard.checkWinner();  // Check if there is a winner or a tie.
                if (result.equals("Player 1 wins!")) {
                    System.out.println("Player 1 wins!");
                    break;  // Exit the inner loop if Player 1 wins.
                } else if (result.equals("Player 2 wins!")) {
                    System.out.println("Player 2 wins!");
                    break;  // Exit the inner loop if Player 2 wins.
                } else if (result.equals("Tie")) {
                    System.out.println("It's a tie!");
                    break;  // Exit the inner loop if it's a tie.
                }

                gameBoard.printGameBoard();  // Print the updated game board.
                playerTurn(gameBoard, "Player 2");  // It's Player 2's turn.
                result = gameBoard.checkWinner();  // Check for a winner or a tie again.
                if (result.equals("Player 1 wins!")) {
                    System.out.println("Player 1 wins!");
                    break;  // Exit the inner loop if Player 1 wins.
                } else if (result.equals("Player 2 wins!")) {
                    System.out.println("Player 2 wins!");
                    break;  // Exit the inner loop if Player 2 wins.
                } else if (result.equals("Tie")) {
                    System.out.println("It's a tie!");
                    break;  // Exit the inner loop if it's a tie.
                }
            }

            gameBoard.printGameBoard();  // Print the final state of the game board.
            System.out.println("Do you want to play again? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (!response.equalsIgnoreCase("Y")) {
                break;  // Exit the outer loop if the player doesn't want to play again.
            }
            gameBoard.resetBoard();  // Reset the game board for a new game.
        }
    }

    public static void playerTurn(GameBoard gameBoard, String playerName) {
        System.out.println(playerName + ", choose your position (1-9):");  // Prompt the player to choose a position.
        Scanner scan = new Scanner(System.in);
        int playerPos = scan.nextInt();
        while (gameBoard.isPositionTaken(playerPos)) {
            System.out.println("Position is taken, choose another one.");  // Inform the player that the chosen position is already taken.
            playerPos = scan.nextInt();
        }
        gameBoard.placePiece(playerPos, playerName);  // Place the player's piece on the selected position.
    }
}
