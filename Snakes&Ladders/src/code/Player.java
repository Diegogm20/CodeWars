package code;

public class Player {
    private int Id;
    private int square;

    public Player(int id) {
        Id = id;
        square = 1;
    }

    public int getId() {
        return Id;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }
}
