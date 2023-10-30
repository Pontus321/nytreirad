import java.util.*;

public class Main {

    static ArrayList<Integer>  playerPostions = new ArrayList<Integer>();
    static ArrayList<Integer>  CPUPostions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);



        while (true) {
            System.out.println("Välj din plats (1-9):");
            Scanner scan = new Scanner(System.in);
            int playerPos = scan.nextInt();
            while (playerPostions.contains(playerPos) || CPUPostions.contains(playerPostions)) {
                System.out.println("Platsen är tagen välj en annan");
                playerPos = scan.nextInt();
            }



            placePiece(gameBoard, playerPos, "player");


            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPostions.contains(CPUPostions) || CPUPostions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }



            placePiece(gameBoard,cpuPos, "cpu");

            printGameBoard(gameBoard);
            checkWinnner();

            String result =checkWinnner();
            System.out.println(result);

        }



    }

    public static void printGameBoard (char [][] gameBoard){
        for(char[] row : gameBoard){
            for (char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard,int pos, String user){

        char symbol = ' ';

        if(user.equals("player")){
            symbol ='X';
            playerPostions.add(pos);
        } else if (user.equals("cpu")) {
            CPUPostions.add(pos);
            symbol ='0';

        }

        switch (pos){
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

    public static String checkWinnner(){

        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning ) {
            if(playerPostions.containsAll(l)){
                return "Grattis du vann!";
            } else if(CPUPostions.containsAll(l)) {
                return "Datorn vann du förlorade";
            } else if (playerPostions.size() + CPUPostions.size() == 9) {
                return " ";


            }

        }

        return "";

    }

}