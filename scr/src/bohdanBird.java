import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bohdanBird extends JLabel {
    boolean isAlive = true;
    Thread t;
    bohdanBird(Frame frame) {
        super(new ImageIcon("./image/bird.png"));
        setBounds(100, 300, 80, 80);
        setVisible(true);
        t = new Thread(() -> {
            try {
                while (isAlive) {
                    if (getY() < 600) {
                        int temp = getY();
                        setLocation(100, temp + 3);
                        Thread.sleep(8);
                    }
                    Thread.sleep(4);
                }
            } catch (InterruptedException e) {
                System.exit(1);
            }
        });
        t.start();
        frame.add(this);
    }


}
