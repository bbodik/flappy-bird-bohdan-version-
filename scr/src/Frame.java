import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Frame extends JFrame {
    private int score;

    Frame() {
        Random rnd = new Random();
        setTitle("Flappy Bird");
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(50, 10, 1280, 720);
        JLabel backgroundLabel = new JLabel(new ImageIcon("image/background.png"));
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        bohdanBird bird = new bohdanBird(this);
        backgroundLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Thread jumpThread = new Thread(() -> {
                    for (int i = 0; i < 35; i++) {
                        int temp = bird.getY();
                        if (bird.getY() > 0) {
                            bird.setLocation(100, temp - 3);
                        }
                        try {
                            Thread.sleep(3);
                        } catch (InterruptedException error) {
                            System.exit(2);
                        }
                    }
                });
                jumpThread.start();
            }
        });
        JLabel collumPNG = new JLabel(new ImageIcon("image/collums.png"));
        collumPNG.setBounds(1290, rnd.nextInt(100) - 150, 100, 1000);
        backgroundLabel.add(collumPNG);
        Thread collum = new Thread(() -> {
            while (bird.isAlive) {
                collumPNG.setLocation(1290, rnd.nextInt(100) - 150);
                while (bird.isAlive) {
                    int temp = collumPNG.getX();
                    if (temp < -100) break;
                    collumPNG.setLocation(temp - 1, collumPNG.getY());
                    try {
                        Thread.sleep(4);
                    } catch (Exception e) {
                        System.exit(6);
                    }
                }
            }
        });
        collum.start();
        JLabel collumPNG1 = new JLabel(new ImageIcon("image/collums.png"));
        collumPNG1.setBounds(1290, rnd.nextInt(100) - 150, 100, 1000);
        backgroundLabel.add(collumPNG1);
        Thread collum1 = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                System.exit(6);
            }
            while (bird.isAlive) {
                collumPNG1.setLocation(1290, rnd.nextInt(100) - 150);
                while (bird.isAlive) {
                    int temp = collumPNG1.getX();
                    if (temp < -100) break;
                    collumPNG1.setLocation(temp - 1, collumPNG1.getY());
                    try {
                        Thread.sleep(4);
                    } catch (Exception e) {
                        System.exit(6);
                    }
                }
            }
        });
        collum1.start();
        backgroundLabel.add(bird);
        add(backgroundLabel);
        setVisible(true);
    }


}
