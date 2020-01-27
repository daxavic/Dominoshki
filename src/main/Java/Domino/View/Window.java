package Domino.View;

import Domino.Logic.Chain;
import Domino.Logic.Pair;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Window extends JFrame {
    private JPanel panel;
    private JMenu menu;
    private final int IMAGE_WIDTH = 71;    //ширина одной картинки
    private final int IMAGE_HEIGHT = 142; //высота одной картинки
    private final int INDENT = 30;        //отступ
    //Knuckles knuckles = new Knuckles();


    public Window(Chain pop) throws IOException {
        initPanel(pop);
        initMenu();
        initFrame();
    }


    private void initPanel(Chain pop) {
        panel = new JPanel();
        draw(pop);
        panel.add(label(pop));

        panel.setPreferredSize(new Dimension(1300, 900));
        add(panel);
    }

    // данный label показывает, какие костяшки были выбраны
    private JLabel label(Chain pop) {
        String res = "";//в данную переменную записываются костящки
        if (pop != null) {
            ArrayList<String> str = pop.toStr();
            for (int i = 0; i < str.size(); i++) {
                res = res + " (" + str.get(i) + ")";
                if (i == 17) res = res + "<br>";
            }
        } else res = "не выбраны";

        JLabel label = new JLabel();
        label.setText("<html>Костяшки: " + res + "<html>");
        Font font = new Font("BOLD", Font.BOLD, 24);
        label.setPreferredSize(new Dimension(1250, 870));
        label.setFont(font);
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.LEFT);
        return label;
    }

    //настраиваем меню
    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        menu = new JMenu("Меню");
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 24);
        menu.setFont(BigFontTR);

        //открываем второе окно,где выбираем костяшки
        JMenuItem choose = new JMenuItem("Выбрать Костяшки");
        choose.setFont(BigFontTR);
        choose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                SecondWindow ct = null;
                try {
                    ct = new SecondWindow();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ct.setVisible(true);
                dispose();
            }
        });
        menu.add(choose);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void initFrame() throws IOException {
        setBackground(new Color(142, 204, 197));
        pack();  //размер
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Domino");
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(getImage("66"));
    }

//    private JButton start(JButton start, Chain pop) {
//        start.setPreferredSize(new Dimension(100, 50));
//        //start.setVerticalAlignment(JLabel.CENTER);
//        //start.setHorizontalAlignment(JLabel.RIGHT);
//        start.setText("начать");
//        start.setBackground(Color.WHITE);
//        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 18);
//        start.setFont(BigFontTR);
//        start.setBounds(1110, 670, 150, 50);
//        start.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent event) {
//                draw(pop);
//                repaint();
//
//            }
//        });
//        return start;
//    }

    //  данный метод находит путь к картинке
    private BufferedImage getImage(String name) throws IOException {
        String filename = "im/k" + name.toLowerCase() + ".png";
        BufferedImage icon = ImageIO.read(new File("src/main/resources/" + filename));
        // ImageIcon icon = new ImageIcon("src/main/resources/" + filename);
        return icon;
    }

    //данный метод поварачивает картинку на оределенное количество градусов
    public BufferedImage rotate(BufferedImage image, Double degrees) {
        int width = image.getWidth();
        int height = image.getHeight();

        // рассчитаем новый размер изображения на основе угла поворота
        double radians = Math.toRadians(degrees);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int newWidth = (int) Math.round((width * cos + height * sin));
        int newHeight = (int) Math.round(width * sin + height * cos);

        // новая картинка
        BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotate.createGraphics();

        // Рассчитаем «опорную» точку, вокруг которой будет вращаться изображение
        int x = (newWidth - width) / 2;
        int y = (newHeight - height) / 2;

        // поварачиваем
        AffineTransform at = new AffineTransform();
        at.setToRotation(radians, x + (width / 2), y + (height / 2));
        at.translate(x, y);
        g2d.setTransform(at);
        // Paint the originl image
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return rotate;
    }

    //данный метод рисует заданную цепочку
    public void draw(Chain pop) {
        if (pop == null) panel = new JPanel();
        else {
            ArrayList<Pair> res = pop.result();

            panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int resNumber = 0;   //считает, какая костяшка рисуется из цепочки

                    String write = res.get(resNumber).compareWrite();
                    try {
                        BufferedImage original;
                        BufferedImage rotated;
                        int coorY = INDENT;
                        int m = 0;      // считает, сколько в ряду костяшек
                        int n = 0;     //показывает, какой из рядов рисуется
                        boolean bool;  //показывает, нужно ли повернуть картинку
                        while (resNumber < res.size()) {
                            original = getImage(res.get(resNumber).compareWrite());
                            bool = res.get(resNumber).compare();
                            switch (n) {
                                case 0: {
                                    if (bool)
                                        rotated = rotate(original, 90.0d);
                                    else
                                        rotated = rotate(original, -90.0d);
                                    g.drawImage(rotated,
                                            m * IMAGE_HEIGHT + INDENT,

                                            coorY, this);

                                    m++;
                                    if (m == 7) {
                                        m--;
                                        n++;

                                        coorY = coorY + IMAGE_WIDTH;
                                    }
                                }
                                break;

                                case 1: {
                                    if (bool)
                                        rotated = rotate(original, 180.0d);
                                    g.drawImage(original,
                                            (2 * m + 1) * IMAGE_WIDTH + INDENT, coorY, this);
                                    coorY = coorY + IMAGE_HEIGHT;
                                    n++;
                                }
                                break;

                                case 2: {
                                    if (bool)
                                        rotated = rotate(original, -90.0d);
                                    else
                                        rotated = rotate(original, 90.0d);
                                    g.drawImage(rotated,
                                            m * IMAGE_HEIGHT + INDENT, coorY, this);
                                    m--;
                                    if (m == -1) {
                                        m++;
                                        n++;
                                        coorY = coorY + IMAGE_WIDTH;
                                    }
                                }
                                break;
                                case 3: {
                                    if (bool)
                                        rotated = rotate(original, 180.0d);
                                    g.drawImage(original,
                                            INDENT, coorY, this);
                                    coorY = coorY + IMAGE_HEIGHT;
                                    n = 0;
                                }
                                break;
                                default:
                                    break;
                            }
                            resNumber++;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

        }

    }


}
