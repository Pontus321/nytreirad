import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> player1Positions = new ArrayList<>();
    static ArrayList<Integer> player2Positions = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            char[][] gameBoard = {
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}
            };

            while (true) {
                printGameBoard(gameBoard);
                playerTurn(gameBoard, "Player 1");

                String result = checkWinner();
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

                printGameBoard(gameBoard);
                playerTurn(gameBoard, "Player 2");
                result = checkWinner();
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
            printGameBoard(gameBoard);
            System.out.println("Do you want to play again? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (!response.equalsIgnoreCase("Y")) {
                break;
            }
            player1Positions.clear();
            player2Positions.clear();
        }
    }

    public static void playerTurn(char[][] gameBoard, String playerName) {
        System.out.println(playerName + ", choose your position (1-9):");
        Scanner scan = new Scanner(System.in);
        int playerPos = scan.nextInt();
        while (player1Positions.contains(playerPos) || player2Positions.contains(playerPos)) {
            System.out.println("Position is taken, choose another one.");
            playerPos = scan.nextInt();
        }
        placePiece(gameBoard, playerPos, playerName);
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if (user.equals("Player 1")) {
            symbol = 'X';
            player1Positions.add(pos);
        } else if (user.equals("Player 2")) {
            symbol = 'O';
            player2Positions.add(pos);
        }

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

    public static String checkWinner() {
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

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}