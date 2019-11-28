package ir.ahuratus.Task10;

public interface Bot {

    public abstract Direction chooseDirection(final Snake mySnake, final Snake otherSnake, final int[][] maze);

}
