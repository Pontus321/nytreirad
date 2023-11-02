import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            GameBoard gameBoard = new GameBoard();

            while (true) {
                gameBoard.printGameBoard();
                playerTurn(gameBoard, "Player 1");

                String result = gameBoard.checkWinner();
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

                gameBoard.printGameBoard();
                playerTurn(gameBoard, "Player 2");
                result = gameBoard.checkWinner();
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
            gameBoard.printGameBoard();
            System.out.println("Do you want to play again? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (!response.equalsIgnoreCase("Y")) {
                break;
            }
            gameBoard.resetBoard();
        }
    }

    public static void playerTurn(GameBoard gameBoard, String playerName) {
        System.out.println(playerName + ", choose your position (1-9):");
        Scanner scan = new Scanner(System.in);
        int playerPos = scan.nextInt();
        while (gameBoard.isPositionTaken(playerPos)) {
            System.out.println("Position is taken, choose another one.");
            playerPos = scan.nextInt();
        }
        gameBoard.placePiece(playerPos, playerName);
    }
}