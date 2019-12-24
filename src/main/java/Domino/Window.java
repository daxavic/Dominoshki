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

    public static void main(String[] args)
    {
        new Window();
    }

    private Window()
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

        JMenuItem choose = new JMenuItem("Выбрать Костяшки");
    choose.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent event) {
            JFrame myWindow = new SecondWindow();
            myWindow.setVisible(true);
            setVisible(false);
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
    }

}
