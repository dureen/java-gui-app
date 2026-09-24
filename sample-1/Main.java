import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Sample 1 – Minimal Swing window with a button.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI Application");
        JButton button = new JButton("Press");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.getContentPane().add(button);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
