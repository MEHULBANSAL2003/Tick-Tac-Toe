import java.util.Scanner;

public class TicTacToe {

  private player player1, player2;
  private Board board;

  public static void main(String[] args) {
    TicTacToe t=new TicTacToe();
    t.startGame();
  }

  public void startGame() {
    Scanner s = new Scanner(System.in);
    // player input
    player1 = takePlayerInput(1);
    player2 = takePlayerInput(2);

    while (player1.getSymbol() == player2.getSymbol()) {
      System.out.println("Symbol already taken !! take another symbol");
      char symbol = s.next().charAt(0);
      player2.setSymbol(symbol);
    }
    // create board
    board = new Board(player1.getSymbol(), player2.getSymbol());

    // conduct the game
    boolean player1turn = true;
    int status = Board.INCOMPLETE;
    while (status == Board.INCOMPLETE || status == Board.INVALID) {
      if (player1turn) {
        System.out.println("Player 1 -" + player1.getName() + "'s turn");
        System.out.println("Enter x: ");
        int x = s.nextInt();
        System.out.println("Enter y: ");
        int y = s.nextInt();
        status = board.move(player1.getSymbol(), x, y);
        if (status != Board.INVALID) {
          player1turn = false;
          board.print();
        }
        else{
          System.out.println("Invalid Move!! Try Again");
        }
      } else {
        System.out.println("Player 2 -" + player2.getName() + "'s turn");
        System.out.println("Enter x: ");
        int x = s.nextInt();
        System.out.println("Enter y: ");
        int y = s.nextInt();
        status = board.move(player2.getSymbol(), x, y);
        if (status != Board.INVALID) {
          player1turn = true;
          board.print();
        }
        else{
          System.out.println("Invalid Move!! Try Again");
        }
      }
    }
    if(status==Board.PLAYER_1_WINS){
       System.out.println("Player 1 - "+player1.getName()+ "wins !!");
    }
    else if(status==Board.PLAYER_2_WINS){
      System.out.println("Player 2 - "+player2.getName()+ "wins !!");
   }
   else{
    System.out.println("Draw !!");
   }
  }

  private player takePlayerInput(int num) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter Player " + num + " name");
    String name = s.nextLine();
    System.out.println("Enter Player " + num + " Symbol");
    char symbol = s.next().charAt(0);

    player p = new player(name, symbol);

    return p;

  }

}