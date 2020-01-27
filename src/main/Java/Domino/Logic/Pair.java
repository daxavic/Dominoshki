package Domino.Logic;

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

    // сравнивает элементы пары
    public Boolean compare() {
        if (left > right) return true;
        return false;
    }

    // записывает элементы пары в порядке возрастания
    public String compareWrite(){
        String res;
        if (compare()) res = String.valueOf(right) + String.valueOf(left);
        else res = String.valueOf(left) + String.valueOf(right);
        return res;
    }

}
