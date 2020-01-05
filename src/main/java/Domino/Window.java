package Domino;

import Domino.SecondWindow.SecondWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame
{
    private JPanel panel;
    private JMenu menu;
    JFrame myWindow = new SecondWindow();

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
        panel = new JPanel();
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

            myWindow.setVisible(true);
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
        myWindow.setVisible(false);
        setVisible(true);
        setIconImage(getImage("k66"));


    }

    private Image getImage(String name) {
        String filename = "im/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon("src/main/resources/" + filename);
        return icon.getImage();
    }



}
