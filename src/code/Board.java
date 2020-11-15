package code;

import java.util.ArrayList;

public class Board {
    private ArrayList<Integer> snakes;
    private ArrayList<Integer> ladders;

    public Board() {
        ladders = new ArrayList<Integer>();
        snakes = new ArrayList<Integer>();
        initializeBoard();
    }

    public ArrayList<Integer> getSnakes() {
        return snakes;
    }

    public ArrayList<Integer> getLadders() {
        return ladders;
    }

    public void initializeBoard(){
        //Ladders
        ladders.add(2);ladders.add(7);
        ladders.add(8);ladders.add(15);
        ladders.add(21);ladders.add(28);
        ladders.add(36);ladders.add(51);
        ladders.add(71);ladders.add(78);
        ladders.add(87);
        //Snakes
        snakes.add(16);snakes.add(46);
        snakes.add(49);snakes.add(62);
        snakes.add(64);snakes.add(74);
        snakes.add(89);snakes.add(92);
        snakes.add(95);snakes.add(99);
    }
    public int slideDownSnake(int square) {
        return switch (square) {
            case 16 -> 6;
            case 46 -> 25;
            case 49 -> 11;
            case 62 -> 19;
            case 64 -> 60;
            case 74 -> 53;
            case 89 -> 68;
            case 92 -> 88;
            case 95 -> 75;
            case 99 -> 80;
            default -> 0;
        };
    }
    public int climbLadder(int square) {
        return switch (square) {
            case 2 -> 38;
            case 7 -> 14;
            case 8 -> 31;
            case 15 -> 26;
            case 21 -> 42;
            case 28 -> 84;
            case 36 -> 44;
            case 51 -> 67;
            case 71 -> 91;
            case 78 -> 98;
            case 87 -> 94;
            default -> 0;
        };
    }
}
