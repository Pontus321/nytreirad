import java.util.ArrayList;
import java.util.List;

class GameBoard {
    private char[][] gameBoard;
    private ArrayList<Integer> player1Positions;
    private ArrayList<Integer> player2Positions;

    public GameBoard() {
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

    public boolean isPositionTaken(int pos) {
        return player1Positions.contains(pos) || player2Positions.contains(pos);
    }

    public String checkWinner() {
        List<Integer> topRow = List.of(1, 2, 3);
        List<Integer> midRow = List.of(4, 5, 6);
        List<Integer> botRow = List.of(7, 8, 9);
        List<Integer> leftCol = List.of(1, 4, 7);
        List<Integer> midCol = List.of(2, 5, 8);
        List<Integer> rightCol = List.of(3, 6, 9);
        List<Integer> cross1 = List.of(1, 5, 9);
        List<Integer> cross2 = List.of(7, 5, 3);

        List<List<Integer> > winning = new ArrayList<>();
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

    public void printGameBoard() {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void resetBoard() {
        gameBoard = new char[][] {
        };

        player1Positions.clear();
        player2Positions.clear();
    }
}