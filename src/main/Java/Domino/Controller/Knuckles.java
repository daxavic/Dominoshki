package Domino.Controller;

import Domino.Logic.Chain;
import Domino.Logic.Pair;

import java.util.ArrayList;

public class Knuckles {

    static Boolean[][] bool; //показывает, выбрана ли костяшка

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

    //данный метод меняет флаг: если костяшка не была выбрана, выбиает, и наборот
    public void changeFlag(int x, int y){
        boolean n = bool[y][x];
        if (!n) bool[y][x] = true;
                else bool[y][x] = false;
    }

    public Boolean getKn (int x, int y) {
        boolean n = bool[y][x];
        return n;
    }

    // данный метод делает из выбранных костяшек цепочку
    public Chain toChain(){
        ArrayList<Pair> n = new ArrayList<>();
        for (int y = 0; y < 4; y++){
            for (int x = 0; x < 7; x++){
                if (bool[y][x]) n.add(new Pair(MATRIX[y][x].left,MATRIX[y][x].right));
            }
        }
        Chain ch = new Chain(n);
        return ch;
    }

    // смотрит, есть ли выбранные костяшки
    public boolean color(){
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 7; x++) {
                if (getKn(x,y)) return true;
                }
            }
        return false;
        }
}
