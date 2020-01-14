package Domino.View;

import Domino.Logic.Chain;
import Domino.Pair;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class SecondWindow  extends JFrame {



    private JPanel panel;
    private final int IMAGE_WIDTH = 71;    //ширина одной картинки
    private final int IMAGE_HEIGHT = 142; //высота одной картинки
    private final int INDENT = 30;        //отступ от краев


    //
    Knuckles knuckles = new Knuckles();
    final Pair[][] MATRIX = knuckles.MATRIX;

    //JFrame window = new JFrame(){};

    public static void main(String[] args){
        new SecondWindow();
    }

    public SecondWindow(){
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
       JButton close = close(new JButton());
       JButton clear = clear(new JButton());

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
        add(close);
        add(clear);
        add(panel);



    }


//    private void setImage(){
//        for (Domino.View.Box box: Box.values())
//            box.image = getImage(box.name().toLowerCase());
//    }

    //  данный метод находит путь к картинке
    private BufferedImage getImage(String name) throws IOException {
        String filename = "im/" + name.toLowerCase() + ".png";
        BufferedImage icon = ImageIO.read(new File("src/main/resources/" + filename));
       // ImageIcon icon = new ImageIcon("src/main/resources/" + filename);
        return icon;
    }

    private JButton close(JButton close){
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 18);
        close.setText("ЗАКОНЧИТЬ");
        close.setBackground(Color.WHITE);
        close.setFont(BigFontTR);
        close.setBounds(370, 618, 150, 50);

        close.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                //JFrame myWindow = Window;
                // myWindow.setVisible(true);

            }});
        return close;
    }

    private JButton clear (JButton clear){
        clear.setText("ОЧИСТИТЬ");
        clear.setBackground(Color.WHITE);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 18);
        clear.setFont(BigFontTR);
        clear.setBounds(50, 618, 150, 50);
        clear.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                knuckles = new Knuckles();
                repaint();

            }});
        return clear;
    }





   private void DrawImages(){
       panel = new JPanel(){
           @Override
           protected void paintComponent(Graphics g) { //функция, что рисовать
               super.paintComponent(g);
               for (int y = 0; y < 4; y++) {
                   for (int x = 0; x < 7; x++){
                       if (knuckles.getKn(x, y) == true) {
                           try {
                               g.drawImage((getImage("k" + MATRIX[y][x].left + MATRIX[y][x].right + "kr")),
                                       x * IMAGE_WIDTH + INDENT,
                                       y * IMAGE_HEIGHT + INDENT, this);
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }
                       else {
                           try {
                               g.drawImage((getImage("k" + MATRIX[y][x].left + MATRIX[y][x].right)),
                                       x * IMAGE_WIDTH + INDENT,
                                       y * IMAGE_HEIGHT + INDENT, this);
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }
                   }
               }
           }
       };
    }

    public Chain result(){
        return knuckles.toChain();
    }




    }
