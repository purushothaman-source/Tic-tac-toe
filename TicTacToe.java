import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static final int Head = 0;
    public static final int Tail = 1;

    public static enum Player {USER, COMPUTER}
    static Random random = new Random();

    //main method
    public static void main(String[] args) {
        char[] board = createBoard();
        Scanner userInput = new Scanner(System.in);
        char userLetter = chooseUserLetter(userInput);
        char computerLetter = (userLetter == 'X') ? '0' : 'x';
        showBoard(board);
        Player player = getWhoStartsFirst();
        if (player.equals(Player.USER)) {
            System.out.println("User Move");
            int userMove = getUserMove(board, userInput);
            makeMove(board, userMove, userLetter);
            showBoard(board);
        } else if (player.equals((Player.COMPUTER))) {
            System.out.println("Computer Move");
            int computerMove = getComputerMove(board);
            makeMove(board, computerMove, computerLetter);
            showBoard(board);
        }
    }


    private static char[] createBoard() {   //UC 1
        char[] board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

    private static char chooseUserLetter(Scanner userInput) {  //UC 2
        System.out.println("choose your letter: ");
        return userInput.next().toUpperCase().charAt(0);
    }

    private static void showBoard(char[] Board) {
        System.out.println("");
        for (int i = 1; i < Board.length; i++) {
            System.out.print("|_" + i + Board[i] + "_|");
            if (i % 3 == 0) {
                System.out.print(System.lineSeparator());
                System.out.println("--------------------");
            }
        }
    }

    private static int getUserMove(char[] board, Scanner userInput) {
        Integer[] validCells = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        while (true) {
            System.out.println("what is your next move?(1-9): ");
            int index = userInput.nextInt();
            if (Arrays.asList(validCells).contains(index) && isSpaceFree(board, index)) ;
            return index;
        }
    }

    private static int getComputerMove(char[] board) {
        Integer[] validCells = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        while (true) {
            // System.out.println("what is your next move?(1-9): ");
            int index = random.nextInt(9) + 1;
            System.out.println("computer index : "+index);
            if (Arrays.asList(validCells).contains(index) && isSpaceFree(board, index)) ;
            return index;
        }
    }

    private static boolean isSpaceFree(char[] board, int index) {
        return board[index] == ' ';
    }

    private static void makeMove(char[] board, int index, char letter) {
        boolean spaceFree = isSpaceFree(board, index);
        if (spaceFree)
            board[index] = letter;
    }

    private static Player getWhoStartsFirst() {

        int toss = random.nextInt(2);
        return (toss == Head) ? Player.USER : Player.COMPUTER;
    }
}




