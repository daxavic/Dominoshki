package Domino.Logic;

import Domino.Pair;

import java.util.ArrayList;

public class Chain {
    private final int MAX = 28;                      // массимально возможное количество костяшек
    private boolean[][] matrix = new boolean[7][7]; //  массив, в котором хранятся заданные костяшки
    private int size;                               // максимально возможная длина цепчки
    private ArrayList<Integer> best;                // самая длинная цепочка, найденная на данный момент
    private ArrayList<Integer> ch;                  // цепочка, которая состовляется в данный момент
    boolean flag;                                    // показыват, найдена ли цепочка, равная SIZE

    //создаем конструктор
    public Chain(ArrayList<Pair> data){
        size = data.size();
        if (size > MAX && size < 0) throw new IllegalArgumentException ("Неверное количество элементов");
        for (Pair el: data){
            int left = el.left;
            int right = el.right;
            matrix[left][right] = true;
            matrix[right][left] = true;
        }
        best = new ArrayList<Integer>();
        ch = new ArrayList<Integer>();
        flag =false;
    }

    // метод "проверка на существование подходящей костяшки"
    private boolean found (int k){
        int i = 0;
        while (i < 7 && !matrix[k][i]){
            i++;
        }
        return (i < 7);
    }

    public boolean foundPublic (int k){
        return found(k);
    }


    // метод "сравнение цепочек"
    private ArrayList<Integer> theLongest(){
        if (ch.size() > best.size()) {
            best = new ArrayList<Integer>(ch);
            flag = best.size() / 2 == size;
        }
        return best;
    }


    // метод "Построение цепочки", при определенной начальной цифре
    private void doChain (int kn){
        if (flag) return ; //нужно остановиться)
        if (matrix[kn][kn]){                      //исключение дубля облегчает перебор
            matrix[kn][kn] = false;               //убираем костяшку из массива
            ch.add(kn);                             //добавляем костяшку в цепочку
            ch.add(kn);
            //if (ch.size() > best.size()) best = ch;
            if (found(kn)) doChain(kn);
            else theLongest();
            ch.remove(ch.size() - 1);
            ch.remove(ch.size() - 1);
            this.matrix[kn][kn] = true;               //возвращаем костяшку
            return ;
        }
        for (int i = 0; i <= 6; i++){                 //ищем цепочку, когда нет дубля
            //System.out.println('i');
            //System.out.println(i);
            //  System.out.println(ch);
            //System.out.println(best);
            if (matrix[kn][i]) {
                this.matrix[i][kn] = false;
                this.matrix[kn][i] = false;            //убираем костяшку
                ch.add(kn);
                ch.add(i);
                if (found(i)) doChain(i);
                else
                    theLongest();
                ch.remove(ch.size() - 1);
                ch.remove(ch.size() - 1);
                matrix[kn][i] = true;            //возвращаем костяшку
                matrix[i][kn] = true;
                System.out.println(ch);
            }
        }
        return;
    }

    public ArrayList<Integer> doChainPublic (int kn){
        doChain(kn);
        return best;
    }

    // основной метод
    public ArrayList <Pair> result(){
        //ArrayList<Integer> best = new ArrayList<>();
        for (int k = 0; k <= 6; k++){
            doChain(k);
            System.out.println(best);
        }

        return getPairs();

    }

    //метод записывает костяшки парами
    private ArrayList<Pair> getPairs() {
        ArrayList<Pair> res = new ArrayList<Pair>();

        for (int i = 1; i < best.size(); i = i + 2){
            res.add(new Pair(best.get(i-1),best.get(i)));
            System.out.print (new Pair(best.get(i-1),best.get(i)).toString());
        }
        if (res.size() > size) throw new IllegalArgumentException ("Количество элементов больше возможного");
        System.out.print("res = ");
        System.out.print(res);

        return res;
    }

}
