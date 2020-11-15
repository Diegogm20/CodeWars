package code;

public class SnakesLadders {
    public static void main(String[] args){
        Board board = new Board();
        GameLogic game = new GameLogic(board);
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        int playerTurn = 1;

        while(!game.isGameOver()){
            if (playerTurn == 1){
                game.turno(p1);
                playerTurn++;
            }
            else {
                game.turno(p2);
                playerTurn--;
            }
    }

    }
}
