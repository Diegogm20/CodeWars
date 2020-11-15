package code;

import java.util.Random;

public class GameLogic {
    boolean gameOver;
    Board board;
    public GameLogic(Board board) {
        this.board = board;
        gameOver = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int[] throwDices(){
        Random r = new Random();
        int die1 = r.nextInt(6)+1;
        int die2 = r.nextInt(6)+1;
        int[] dices = {die1,die2};
        return dices;
    };
    public void turno(Player player){
        System.out.println("Player " + player.getId() + " turn. Square "+player.getSquare());
        if (!gameOver) {
            int[] dices = throwDices();
            System.out.println("Player " + player.getId() + " rolls " + dices[0] + " and "+dices[1]+
                    " -> "+player.getSquare()+" + "+(dices[0]+dices[1])+" -> "+(player.getSquare()+dices[0]+dices[1]));
            int newSquare = dices[0] + dices[1] + player.getSquare();
            //player reaches final square(100)
            if (newSquare == 100) {
                gameOver = true;
                System.out.println("Player " + player.getId() + " wins!");
            }
            else {
                //if a player goes over 100, it bounces back
                if (newSquare > 100) {
                    int bounceBack = newSquare - 100;
                    newSquare = 100 - bounceBack;
                    System.out.println("Player bounces back to square " + newSquare);
                }
                //check ladders/snakes
                if (board.getLadders().contains(newSquare)) {
                    newSquare = board.climbLadder(newSquare);
                    System.out.println("Player " + player.getId() + " climbs ladder to " + newSquare);
                } else if (board.getSnakes().contains(newSquare)) {
                    newSquare = board.slideDownSnake(newSquare);
                    System.out.println("Player " + player.getId() + " slides down snake to " + newSquare);
                }
                //update player's square
                player.setSquare(newSquare);
                System.out.println("Player " + player.getId() + " square: " + player.getSquare());
                //check both dices in case player has to throw dices again.
                if (dices[0] == dices[1]) {
                    System.out.println("Player " + player.getId() + " rolled doubles. He will go again.");
                    this.turno(player);
                } else {
                    System.out.println("Turn is over\n\n");
                }
            }
        }
        else {
            System.out.println("Game is over!");
        }
    }
}
