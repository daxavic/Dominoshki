package Domino.SecondWindow;

import Domino.Box;
import Domino.Pair;

import javax.swing.*;
import java.awt.*;

public class SecondWindow extends JFrame {

    private JPanel panel;
    private final int COLS = 7;
    private final int ROWS = 7;
    private final int IMAGE_WIDTH = 71;
    private final int IMAGE_HEIGHT = 142;
    private final int INDENT = 30;
    //private final int INDENT_Y = 30;
    public static void main(String[] args){
        new SecondWindow();
    }

    SecondWindow(){
        setImage();
        initPanel();
        initFrame();
    }

    private void initFrame(){
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOMINO");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void initPanel(){
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) { //функция, что рисовать
                super.paintComponent(g);
                Pair[][] massiv = new Pair[4][7];
                massiv = Knuckle.kn();
                for (int y = 0; y < 4; y++) {
                        for (int x = 0; x < 7; x++){
                            System.out.print(massiv[y][x].toString());
                            System.out.print(" ");
                            g.drawImage(getImage("k" + massiv[y][x].left + massiv[y][x].right),
                                    x * IMAGE_WIDTH + INDENT,
                                    y * IMAGE_HEIGHT + INDENT, this);
//                        }
                        }
                    System.out.println();
                }

//                    for (int y = 0; y < 4; y++) {
//                        for (int x = 0; x < 7; x++) {
//                            g.drawImage((Image) box.image,
//                                    x * IMAGE_WIDTH + INDENT,
//                                    y * IMAGE_HEIGHT + INDENT, this);
//                        }
                    }

//                for (Pair[] coord: Ranges.getAllCoords()){
//                    g.drawImage((Image)Box.k01.image,
//                            coord.left + INDENT,
//                            coord.right + INDENT , this);
//                }

           // }
        };
        panel.setPreferredSize(new Dimension(557, 628));
        add(panel);
    }

    private void setImage(){
        for (Domino.Box box: Box.values())
            box.image = getImage(box.name().toLowerCase());
    }

    private Image getImage(String name){
        String filename = "im/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon("C:/Users/davik/IdeaProjects/Dominoshki/src/main/resources/" + filename);
        return icon.getImage();
    }
}

//    private final int COLS = 7;
//    private final int ROWS = 7;
//    private final int IMAGE_WIDTH = 71;
//    private final int IMAGE_HEIGHT = 142;
//    private JPanel panel;
//
//    public static void main(String[] args)
//    {
//        new SecondWindow();
//    }
//
//    public SecondWindow()
//    {
//        //setImage();
//        initPanel();
//        initFrame();
//
//    }
//
//    private void initPanel()
//    {
//        panel = new JPanel(){
//
//            //метод для рисования
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g.drawImage(getImage("k00"),0,0,this);
////                for (Box box: Box.values()){
////                    Pair coord = new Pair(box.ordinal()* IMAGE_WIDTH, 0);
////                    g.drawImage((Image) box.image,
////                           coord.left ,coord.right,this);
////
////                }
//
//
//            }
//        };
//        panel.setPreferredSize(new Dimension(1000, 1000));
//        add(panel);
//    }
//
//    private void  initFrame()
//    {
//        pack();  //размер
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setTitle("Domino");
//        setLocationRelativeTo(null);
//        setResizable(false);// размер окна
//        setVisible(true);
//    }
//
//    private void setImage(){
//        for (Box box: Box.values())
//            box.image = getImage(box.name());
//    }
//
//
//    //возвращает картинку
//    private Image getImage(String name){
//        String filename = name.toLowerCase() + ".png";
//        ImageIcon icon = new ImageIcon (getClass().getResource(filename));
//        return icon.getImage();
//
//    }
//
//
//
//}
