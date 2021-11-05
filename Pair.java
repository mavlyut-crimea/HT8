package HT8;

public class Pair {
    private final int x;
    private final int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int first() {
        return x;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
