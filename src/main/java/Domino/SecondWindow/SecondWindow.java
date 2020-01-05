package Domino.SecondWindow;

import Domino.Box;
import Domino.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class SecondWindow extends JFrame {

    private JPanel panel;

    private JPanel pan;//!!!!!!!!!!!!!!!!


    private final int COLS = 7;
    private final int ROWS = 7;
    private final int IMAGE_WIDTH = 71;
    private final int IMAGE_HEIGHT = 142;
    private final int INDENT = 30;

    //
    Knuckles knuckles = new Knuckles();
    final Pair[][] MATRIX = knuckles.MATRIX;

    private Knuckle fl = new Knuckle();
    private ArrayList<Pair> res = new ArrayList<Pair>();
    //private final int INDENT_Y = 30;
    public static void main(String[] args){
        new SecondWindow();
    }

    public SecondWindow(){
        setImage();
        initPanel();
        initFrame();
    }

    private void initFrame(){
        pack();
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOMINO");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        //setIconImage(getImage("k66"));
    }

    private void initPanel(){

       DrawImages();





        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 20);
        JButton myButton = new JButton();
        myButton.setText("Закончить");
        myButton.setBackground(Color.WHITE);
        myButton.setFont(BigFontTR);
        myButton.setBounds(370, 618, 150, 50);

        myButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                setVisible(false);
               //JFrame myWindow = new Window();
               // myWindow.setVisible(true);

            }});

//        pan.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                double now_x = e.getX();
                double now_y = e.getY();

                int y = (e.getY() - INDENT )/ IMAGE_HEIGHT ;
                int x = (e.getX() - INDENT )/ IMAGE_WIDTH;

                Pair coord = new Pair(x , y);
                if ( e.getButton() == MouseEvent.BUTTON1 && (now_x - INDENT) >= 0
                && (now_x - INDENT) <= (7 * IMAGE_WIDTH) && (now_y - INDENT) >= 0
                && (now_y - INDENT) <= (4 * IMAGE_HEIGHT)) {
                    knuckles.changeFlag(x,y);
                    System.out.println((knuckles.getKn(x, y)));

                }
                DrawImages();
                repaint();
            }
        });
        panel.setPreferredSize(new Dimension(557, 710));
        add(myButton);

        //add(pan);
        add(panel);



    }


    private void setImage(){
        for (Domino.Box box: Box.values())
            box.image = getImage(box.name().toLowerCase());
    }


//  данный метод находит путь к картинке
    private Image getImage(String name){
        String filename = "im/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon("src/main/resources/" + filename);
        return icon.getImage();
    }

   private void DrawImages(){
       panel = new JPanel(){
           @Override
           protected void paintComponent(Graphics g) { //функция, что рисовать
               super.paintComponent(g);
//               Pair[][] massiv;
//               massiv = knuckles.MATRIX;
               for (int y = 0; y < 4; y++) {
//                   System.out.println("");
//                   knuckles.changeFlag(0,y);
                   for (int x = 0; x < 7; x++){
//                       System.out.print(knuckles.getKn(x, y));

                       if (knuckles.getKn(x, y) == true)
                           g.drawImage((getImage("k" + MATRIX[y][x].left + MATRIX[y][x].right + "kr")),
                                   x * IMAGE_WIDTH + INDENT,
                                   y * IMAGE_HEIGHT + INDENT, this);
                       else
                           g.drawImage((getImage("k" + MATRIX[y][x].left + MATRIX[y][x].right)),
                                   x * IMAGE_WIDTH + INDENT,
                                   y * IMAGE_HEIGHT + INDENT, this);
                   }
               }
           }
       };
    }




    }
