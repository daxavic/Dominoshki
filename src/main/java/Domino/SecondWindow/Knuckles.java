package Domino.SecondWindow;

import Domino.Pair;

public class Knuckles {




    static Boolean[][] bool;// = new Boolean[4][7] ;

    public Knuckles(){
        //Boolean[][] data
        bool = new Boolean[4][7];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 7; x++) {
                bool[y][x] = false;
            }
        }

    }

    public final Pair[][] MATRIX = kn();


    private final Pair[][] kn() {
        Pair[][] allCoords = new Pair[4][7];
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
        boolean n = bool[y][x];
        if (!n) bool[y][x] = true;
                else bool[y][x] = false;
    }

    public Boolean getKn (int x, int y) {
        boolean n = bool[y][x];
        return n;
    }

}
