package Domino.SecondWindow;

import Domino.Pair;

import java.awt.*;

public class Knuckle {
    private static Pair size;
    private static Pair[][] allCoords;
    private static Boolean[][] flag ;

    public Knuckle (){  //Boolean[][] data
        flag = new Boolean[4][7];

    }



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

    public static Boolean changeFlag(int x, int y){
        boolean n = flag[y][x];
        if (!n) flag[y][x] = true;
        return flag[y][x];
    }

    public static String changeName(int x, int y){
        if(flag[y][x]) return "kr";
        else  return "";
    }


//  public Image getBox (Pair coord){
//
//  }
}




