import javax.swing.*;
import java.awt.event.*;

public class Frame extends JFrame {
    private int score;

    Frame() {
        setTitle("Flappy Bird");
        setResizable(false);
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
                    for (int i = 0; i < 25; i++) {
                        int temp = bird.getY();
                        bird.setLocation(50, temp - 6);
                        try {
                            Thread.sleep(12);
                        } catch (InterruptedException error) {
                            System.exit(2);
                        }
                    }
                });
                jumpThread.start();
            }
        });
        Thread firstCollum=new Thread(()->{

        });
        Thread secondCollum=new Thread(()->{

        });
        add(backgroundLabel);
        setVisible(true);
    }


}
