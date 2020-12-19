//main class
public class TicTacToe {
    //main method
    public static void main(String[] args) {
        char[] board=createBoard();//calling createBoard method

    }
    private static char[] createBoard(){   //UC 1
        char[] board=new char[10];  //initialize board to null
        for (int i=1;i< board.length;i++){
            board[i]=' ';
        }
        return board;  //return board
    }
}