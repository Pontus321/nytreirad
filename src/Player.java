import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    // Method to allow a player to make their move.

    public static void playerTurn(char[][] gameBoard, String playerName, ArrayList<Integer> player1Positions, ArrayList<Integer> player2Positions) {
        System.out.println(playerName + ", choose your position (1-9):");
        Scanner scan = new Scanner(System.in);
        int playerPos = scan.nextInt();
        while (player1Positions.contains(playerPos) || player2Positions.contains(playerPos)) {
            System.out.println("Position is taken, choose another one.");
            playerPos = scan.nextInt();
        }
        GameLogic.placePiece(gameBoard, playerPos, playerName, player1Positions, player2Positions);
    }
}