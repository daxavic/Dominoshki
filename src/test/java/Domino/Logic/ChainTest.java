package Domino.Logic;

import Domino.Pair;
import org.junit.Test;
import sun.plugin.javascript.navig.Array;
import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ChainTest {


    static void resultTest(ArrayList<String> expected, ArrayList<Pair> data){
        Chain m = new Chain(data);
        ArrayList<Pair> n = m.result();
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < n.size(); i++){
            res.add(n.get(i).toString());
        }
        assertEquals(expected, res);
    }

    @Test
    public void result(){
        resultTest(new ArrayList<String>(Arrays.asList("11",
                "12")),new ArrayList<Pair>(Arrays.asList(new Pair(1,1),new Pair(1,2))
        ));

        resultTest(new ArrayList<String>(Arrays.asList("56","62","21", "13","36")),
                new ArrayList<Pair>(Arrays.asList(new Pair(1,2), new Pair(1,3),
                        new Pair(2,6), new Pair(3,6),new Pair(5,6))));

        resultTest(new ArrayList<String>(Arrays.asList("00")),
                new ArrayList<Pair>(Arrays.asList(new Pair(0,0), new Pair(1,1),
                        new Pair(2,2), new Pair(3,3),new Pair(4,4),
                        new Pair(5,5), new Pair(6,6))));

        resultTest(new ArrayList<String>(Arrays.asList("00","03", "33", "34", "41", "16", "66")),
                new ArrayList<Pair>(Arrays.asList(new Pair(0,0), new Pair(0,3),
                        new Pair(1,4), new Pair(2,3),new Pair(2,5),
                        new Pair(3,3), new Pair(4,3), new Pair(6,1),
                        new Pair(6,6))));

        resultTest(new ArrayList<String>(Arrays.asList("00","01", "11", "12", "22", "20", "03","33",
                "31", "14", "44", "40","05", "55", "51", "16", "66", "62", "23", "34", "42", "25", "53",
                "36", "64", "45", "56", "60")),
                new ArrayList<Pair>(Arrays.asList(new Pair(0,0), new Pair(0,1),
                        new Pair(0,2), new Pair(0,3), new Pair(0,4),
                        new Pair(0,5), new Pair(0,6), new Pair(1,1),
                        new Pair(1,2), new Pair(1,3), new Pair(1,4),
                        new Pair(1,5), new Pair(1,6), new Pair(2,2),
                        new Pair(2,3), new Pair(2,4), new Pair(2,5),
                        new Pair(2,6), new Pair(3,3), new Pair(3,4),
                        new Pair(3,5), new Pair(3,6), new Pair(4,4),
                        new Pair(4,5),  new Pair(4,6),  new Pair(5,5),
                        new Pair(5,6), new Pair(6,6))));



    }


    static void foundPublicTest(boolean expected, ArrayList<Pair> data, int k){
        Chain m = new Chain(data);
        boolean n = m.foundPublic(k);
        assertEquals(expected,n);
    }

    @Test
    public void found(){
        foundPublicTest(true, new ArrayList<Pair>(Arrays.asList(new Pair(5,6),
                new Pair(6,2), new Pair(2,1),
                new Pair(1,3),new Pair(3,6))), 6);
        foundPublicTest(false, new ArrayList<Pair>(Arrays.asList(new Pair(5,6),
                new Pair(6,2))), 4);
    }



    static void doChainPublicTest (ArrayList<Integer> expected, ArrayList<Pair> data, int kn){
        Chain m = new Chain(data);
        ArrayList<Integer> best = new ArrayList<Integer>(Arrays.asList(5,1));
        ArrayList<Integer> n = m.doChainPublic(kn);
        assertEquals(expected,n);
    }

    @Test
    public void doChain(){
        doChainPublicTest(new ArrayList<Integer>(Arrays.asList(1,1,1,3,3,2)), new ArrayList<Pair>(Arrays.asList(new Pair(3,1),
                new Pair(2,3), new Pair(1,1) )), 1);
        doChainPublicTest(new ArrayList<Integer>(Arrays.asList(5,6,6,2,2,1,1,3,3,6)), new ArrayList<Pair>(Arrays.asList(new Pair(1,2), new Pair(1,3),
                new Pair(2,6), new Pair(3,6),new Pair(5,6))), 5);
    }


}