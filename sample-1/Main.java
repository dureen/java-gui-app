import javax.swing.*;

public class Main {
    public static void main(String[] args){
        // System.out.println("Hello World!");
        JFrame frame = new JFrame("My First GUI Application");
        JButton button = new JButton("Press");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.getContentPane().add(button);

        frame.setVisible(true);        
    }
}