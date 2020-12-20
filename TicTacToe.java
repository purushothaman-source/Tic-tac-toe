import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    //main method
    public static void main(String[] args) {
        char[] board=createBoard();
        Scanner userInput=new Scanner(System.in);
        char userLetter =chooseUserLetter(userInput);
        char computeLetter =(userLetter == 'X')?'0':'x';
        System.out.println(computeLetter);
        showBoard(board);
        int userMove=getUserMove(board,userInput);

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
    private static void showBoard(char[] Board)
    {
        System.out.println("");
        for(int i =1 ; i<Board.length ;i++)
        {
            System.out.print("|_"+i+Board[i] + "_|");
            if(i%3==0)
            {
                System.out.print(System.lineSeparator());
                System.out.println("--------------------");
            }
        }
    }
    private  static int getUserMove(char[] board,Scanner userInput){
        Integer [] validCells={1,2,3,4,5,6,7,8,9};
        while (true){
            System.out.println("what is your next move?(1-9): ");
            int index=userInput.nextInt();
            if(Arrays.asList(validCells).contains(index) && isSpaceFree(board,index) );
            return index;
        }
    }
    private  static boolean isSpaceFree(char[] board ,int index){
        return board[index] ==' ';
    }
}




