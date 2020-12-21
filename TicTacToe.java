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
        boolean won = false;
        boolean draw = false;
        if (player.equals(Player.USER)) {
            do {
                System.out.println("User Move");
                int userMove = getUserMove(board, userInput);
                makeMove(board, userMove, userLetter);
                showBoard(board);
                won = hasWon(userLetter, board, userMove);
                if (won){
                    System.out.println("you won");
                    break;}
                draw = isDraw(board);
                if (draw)
                    break;
                System.out.println("Computer Move");
                int computerMove = getComputerMove(board);
                makeMove(board, computerMove, computerLetter);
                showBoard(board);
                draw = isDraw(board);
                if (draw)
                    break;
                won = hasWon(computerLetter, board, computerMove);
                if(won){
                    System.out.println("Computer won");
                }
            } while (won == false);

        } else if (player.equals((Player.COMPUTER))) {
            do {
                System.out.println("Computer Move");
                int computerMove = getComputerMove(board);
                makeMove(board, computerMove, computerLetter);
                showBoard(board);
                won = hasWon(computerLetter, board, computerMove);
                if (won){
                    System.out.println("computer won");
                    break;}
                draw = isDraw(board);
                if (draw)
                    break;
                System.out.println("User Move");
                int userMove = getUserMove(board, userInput);
                makeMove(board, userMove, userLetter);
                showBoard(board);
                won = hasWon(userLetter, board, userMove);
                if(won)
                    System.out.println("you won");
                draw = isDraw(board);
                if (draw)
                    break;
            } while (won == false);
            if(draw)
                System.out.println("Match draw");

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
            if (Arrays.asList(validCells).contains(index) && isSpaceFree(board, index))
                return index;
            else
                System.out.println("already occupied, try again");
        }
    }

    private static int getComputerMove(char[] board) {
        Integer[] validCells = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index;
        while (true) {
            if(board[2]=='0'&& board[3]=='0' || board[4]=='0'&& board[7]=='0'|| board[5]=='0'&& board[9]=='0')
                index=1;
             else if(board[1]=='0'&& board[3]=='0' || board[5]=='0'&& board[8]=='0')
                 index=2;
             else if(board[1]=='0'&& board[2]=='0' || board[6]=='0'&& board[9]=='0'|| board[5]=='0'&& board[7]=='0')
                 index=3;
             else if(board[5]=='0'&& board[6]=='0' || board[1]=='0'&& board[7]=='0')
                 index=4;
             else if(board[4]=='0'&& board[6]=='0' || board[2]=='0'&& board[8]=='0'|| board[1]=='0'&& board[9]=='0' ||board[3]=='0' && board[7]=='0')
                 index=5;
             else if(board[4]=='0'&& board[5]=='0' || board[3]=='0'&& board[9]=='0')
                 index=6;
             else if(board[8]=='0'&& board[9]=='0' || board[1]=='0'&& board[4]=='0'|| board[3]=='0'&& board[5]=='0')
                 index=7;
             else if(board[7]=='0'&& board[9]=='0' || board[2]=='0'&& board[5]=='0')
                 index=8;
             else if(board[7]=='0'&& board[8]=='0' || board[3]=='0'&& board[6]=='0'|| board[1]=='0'&& board[5]=='0')
                 index=9;
             else{
             index = random.nextInt(9) + 1;}

            if (Arrays.asList(validCells).contains(index) && isSpaceFree(board, index)) {
                System.out.println("computer index : " + index);
                return index;
            }

        }
    }

    private static boolean isSpaceFree(char[] board, int index) {
        if (board[index] == ' ')
            return true;
        else
            return false;

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

    private static void gameStatus(char[] board) {
        while (true) {
            if (board[1] == board[2] && board[1] == board[3] || board[4] == board[5] && board[4] == board[6] || board[7] == board[8] && board[7] == board[9])
                break;
            else if (board[1] == board[4] && board[1] == board[7] || board[2] == board[5] && board[2] == board[8] || board[3] == board[6] && board[3] == board[9])
                break;
            else if (board[1] == board[5] && board[1] == board[9] || board[3] == board[5] && board[3] == board[7])
                break;
        }
    }

    public static boolean hasWon(int letter, char[] board, int index) {

        return (board[1] == letter && board[2] == letter && board[3] == letter
                || board[4] == letter && board[5] == letter && board[6] == letter
                || board[7] == letter && board[8] == letter && board[9] == letter
                || board[1] == letter && board[4] == letter && board[7] == letter
                || board[2] == letter && board[5] == letter && board[8] == letter
                || board[3] == letter && board[6] == letter && board[9] == letter
                || board[1] == letter && board[5] == letter && board[9] == letter
                || board[3] == letter && board[5] == letter && board[7] == letter);

    }

    private static boolean isDraw(char[] board) {
        return ((board[1] == 'X' || board[1] == '0') && (board[2] == 'X' || board[2] == '0') && (board[3] == 'X' || board[3] == '0') && (board[4] == 'X' || board[4] == '0') &&
                (board[5] == 'X' || board[5] == '0') && (board[6] == 'X' || board[6] == '0') && (board[7] == 'X' || board[7] == '0') && (board[8] == 'X' || board[8] == '0')
                && (board[9] == 'X' || board[9] == '0'));

    }
}




