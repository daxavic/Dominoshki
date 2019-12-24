package Domino.SecondWindow;

import Domino.Pair;

public class Knuckle {
    private static Pair size;
    private static Pair[][] allCoords;
    private static Boolean[][] flag = new Boolean[4][7];


    public static Pair[][] kn() {
        allCoords = new Pair[4][7];
        int l = 0;
        int h = 0;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 7; x++) {
                allCoords[y][x] = new Pair(h, l);
                l++;
                if (l == 7) {
                    h++;
                    l = h;
                }
            }
        }
        return allCoords;
    }

    public void changeFlag(int x, int y){
        boolean n = flag[y][x];
        if (n) flag[y][x] = false;
        else flag[y][x] = true;
    }


    public void pressRightButton(Pair coord) {
        changeFlag(coord.left, coord.right);
    }
}




