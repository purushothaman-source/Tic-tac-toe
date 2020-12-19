import java.util.Scanner;

public class TicTacToe {
    //main method
    public static void main(String[] args) {
        char[] board=createBoard();
        Scanner userInput=new Scanner(System.in);
        char userLetter =chooseUserLetter(userInput);
        char computeLetter =(userLetter == 'X')?'0':'x';
    }
    private static char[] createBoard(){   //UC 1
        char[] board=new char[10];
        for (int i=1;i< board.length;i++){
            board[i]=' ';
        }
        return board;
    }
    private static char chooseUserLetter(Scanner userInput){  //UC 2
        System.out.println("choose your letter: ");
        return userInput.next().toUpperCase().charAt(0);
    }
}




