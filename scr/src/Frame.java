import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Frame extends JFrame {
    private int score;

    Frame() {
        Random rnd =new Random();
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
                        bird.setLocation(100, temp - 6);
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
            JLabel lbl=new JLabel(new ImageIcon("image/collums.png"));
            lbl.setBounds(1300,-10,100,1000);
            this.add(lbl);
            lbl.setVisible(true);
            while(bird.isAlive){
                lbl.setLocation(1300,rnd.nextInt(26) - 25);
                while (bird.isAlive){
                    int temp=lbl.getX();
                    lbl.setLocation(temp-3, lbl.getY());
                    if(temp<0)break;
                    System.out.println(lbl.getX()+"x"+lbl.getY());
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException error) {
                        System.exit(4);
                    }
                }
            }

        });
        Thread secondCollum=new Thread(()->{
            JLabel lbl=new JLabel(new ImageIcon("image/collums.png"));
        });
        firstCollum.setDaemon(true);
        firstCollum.start();
        add(backgroundLabel);
        setVisible(true);
    }


}
