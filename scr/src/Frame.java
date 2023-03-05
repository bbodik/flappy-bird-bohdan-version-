import javax.swing.*;

public class Frame extends JFrame {
    private int score;
    Frame(){
        setTitle("Flappy Bird");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(50, 10, 1280, 720);
        JLabel backgroundLabel = new JLabel(new ImageIcon("image/background.png"));
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(backgroundLabel);
        setVisible(true);
    }


}
