import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bohdanBird extends JLabel {
    boolean isAlive = true;
    Thread t;

    bohdanBird(Frame frame) {
        super(new ImageIcon("./image/bird.png"));
        setBounds(50, 300, 80, 80);
        setVisible(true);
        t = new Thread(() -> {
            try {
                Thread.sleep(3000);
                while (isAlive) {
                    int temp = getY();
                    setLocation(50, temp + 1);
                    Thread.sleep(8);
                }
            } catch (InterruptedException e) {
                System.exit(1);
            }
        });
        t.start();
        frame.add(this);
    }


}