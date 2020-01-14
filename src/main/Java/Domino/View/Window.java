package Domino.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame
{
    private JPanel panel;
    private JMenu menu;
    JFrame secondWindow = new SecondWindow();

    public static void main(String[] args)
    {
        new Window();
    }

    public Window()
    {
        initPanel();
        initMenu();
        initFrame();


    }

    private void initPanel()
    {
      //  panel = new JPanel();
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) { //функция, что рисовать
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
//                AffineTransform tx = new AffineTransform();
//                tx.rotate(0.5, bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);
//
//                AffineTransformOp op = new AffineTransformOp(tx,
//                        AffineTransformOp.TYPE_BILINEAR);
//                bufferedImage = op.filter(bufferedImage, null);


                //Image icon = getImage("k00kr");


                //g2.rotate(Math.toRadians(90),70,71);


//               Domino.Pair[][] massiv;
//               massiv = knuckles.MATRIX;




            }
        };
        panel.setPreferredSize(new Dimension(1000, 900));
        add(panel);
    }

    private void initMenu()
    {
        JMenuBar menuBar = new JMenuBar();
        menu = new JMenu("Меню");
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 24);
       menu.setFont(BigFontTR);

        JMenuItem choose = new JMenuItem("Выбрать Костяшки");
        choose.setFont(BigFontTR);
    choose.addActionListener(new ActionListener() {



        public void actionPerformed(ActionEvent event) {

            secondWindow.setVisible(true);
        //    System.out.println(secondWindow.r);
            //System.out.println(secondWindow.result);

           // System.out.println(knuckles);
            //setVisible(false);
        }});

        menu.add(choose);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void  initFrame()
    {
        pack();  //размер
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Domino");

        setLocationRelativeTo(null);
        //setResizable(false);// размер окна

        setVisible(true);
       // myWindow.setVisible(false);
        setIconImage(getImage("k66"));


    }

    private Image getImage(String name) {
        String filename = "im/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon("src/main/resources/" + filename);
        return icon.getImage();
    }





}
