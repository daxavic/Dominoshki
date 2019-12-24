package Domino;

public class Pair {
    public int left;
    public int right;

    public Pair(int left, int right) {
       // if (left < 0 || left > 6 || right < 0 || right > 6) throw new IllegalArgumentException
           //     ("Число не может существовать");
        this.left = left;
        this.right = right;
    }

    public String toString() {
        String m = Integer.toString(left)+Integer.toString(right);
        return m;
    }
}
