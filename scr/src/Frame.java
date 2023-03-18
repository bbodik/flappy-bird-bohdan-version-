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
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    Thread jumpThread = new Thread(() -> {
                        if (bird.isAlive) {
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
                        }
                    });
                    jumpThread.start();
                }
            }
        });
        JLabel count = new JLabel(bird.getCountS());
        backgroundLabel.add(count);
        count.setBounds(10, 10, 200, 50);
        count.setFont(new Font("Arial", Font.BOLD, 20));
        count.setForeground(Color.YELLOW);
        JLabel collum1PNG = new JLabel(new ImageIcon("image/collums2.png"));
        collum1PNG.setBounds(1290, rnd.nextInt(100) - 150, 100, 415);
        backgroundLabel.add(collum1PNG);
        JLabel collum2PNG = new JLabel(new ImageIcon("image/collums1.png"));
        collum2PNG.setBounds(1290, collum1PNG.getIcon().getIconHeight() + collum1PNG.getY() + 200, 100, 415);
        backgroundLabel.add(collum2PNG);
        Thread collum = new Thread(() -> {
            while (bird.isAlive) {
                collum1PNG.setLocation(1290, rnd.nextInt(100) - 150);
                collum2PNG.setLocation(1290, collum1PNG.getIcon().getIconHeight() + collum1PNG.getY() + 200);
                while (bird.isAlive) {
                    checkInCrash(bird, collum1PNG, collum2PNG);
                    if (collum1PNG.getX() == 100) {
                        bird.setCount(bird.getCount() + 1);
                        count.setText(bird.getCountS());
                        repaint();
                    }
                    int temp = collum1PNG.getX();
                    if (temp < -100) break;
                    collum1PNG.setLocation(temp - 1, collum1PNG.getY());
                    collum2PNG.setLocation(temp - 1, collum2PNG.getY());
                    try {
                        Thread.sleep(4);
                    } catch (Exception e) {
                        System.exit(6);
                    }
                }
            }
        });

        JLabel collum1PNG1 = new JLabel(new ImageIcon("image/collums2.png"));
        collum1PNG1.setBounds(1290, rnd.nextInt(100) - 150, 100, 415);
        backgroundLabel.add(collum1PNG1);
        JLabel collum2PNG2 = new JLabel(new ImageIcon("image/collums1.png"));
        collum2PNG2.setBounds(1290, collum1PNG1.getIcon().getIconHeight() + collum1PNG1.getY() + 200, 100, 415);
        backgroundLabel.add(collum2PNG2);
        Thread collum1 = new Thread(() -> {
            try {
                Thread.sleep(3400);
            } catch (Exception e) {
                System.out.println("11");
            }
            while (bird.isAlive) {
                collum1PNG1.setLocation(1290, rnd.nextInt(100) - 150);
                collum2PNG2.setLocation(1290, collum1PNG1.getIcon().getIconHeight() + collum1PNG1.getY() + 200);
                while (bird.isAlive) {
                    checkInCrash(bird, collum1PNG1, collum2PNG2);
                    if (collum1PNG.getX() == 100) {
                        bird.setCount(bird.getCount() + 1);
                        count.setText(bird.getCountS());
                        repaint();
                    }
                    int temp = collum1PNG1.getX();
                    if (temp < -100) break;
                    collum1PNG1.setLocation(temp - 1, collum1PNG1.getY());
                    collum2PNG2.setLocation(temp - 1, collum2PNG2.getY());
                    try {
                        Thread.sleep(4);
                    } catch (Exception e) {
                        System.exit(6);
                    }
                }
            }
        });
        Thread chekingDeath = new Thread(() -> {
            while (bird.isAlive) {
                try {
                    Thread.sleep(4);
                } catch (Exception e) {
                    System.out.println("1");
                }
            }
            bird.setIcon(new ImageIcon("image/DeadBird.png"));
        });

        collum.start();
        chekingDeath.start();
        collum1.start();
        backgroundLabel.add(bird);
        add(backgroundLabel);
        setVisible(true);
    }

    private void checkInCrash(bohdanBird jLabel1, JLabel jLabel2, JLabel jLabel3) {
        Rectangle bounds1 = jLabel1.getBounds();
        Rectangle bounds2 = jLabel2.getBounds();
        Rectangle bounds3 = jLabel3.getBounds();

        if (bounds1.intersects(bounds2) || bounds1.intersects(bounds3)) {
            jLabel1.isAlive = false;
        }
    }
}
