package Domino;

public class Pair {
    public int left;
    public int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public String toString() {
        String m = Integer.toString(left)+Integer.toString(right);
        return m;
    }

}
