import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Sample 2 – Swing window with menu bar, Exit action, and About dialog.
 */
public class Main implements ActionListener {

    public static final String APP_NAME = "My GUI Application 2";
    public static final Font DEFAULT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 13);

    public static void main(String[] args) {
        JFrame frame = new JFrame(APP_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 480);

        Main app = new Main();

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(DEFAULT_FONT);

        JMenuItem openItem = new JMenuItem("Open File...");
        openItem.setFont(DEFAULT_FONT);
        fileMenu.add(openItem);

        fileMenu.add(new JSeparator());

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setFont(DEFAULT_FONT);
        fileMenu.add(saveItem);

        JMenuItem saveAsItem = new JMenuItem("Save As...");
        saveAsItem.setFont(DEFAULT_FONT);
        fileMenu.add(saveAsItem);

        fileMenu.add(new JSeparator());

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(DEFAULT_FONT);
        exitItem.addActionListener(app);
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setFont(DEFAULT_FONT);

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setFont(DEFAULT_FONT);
        aboutItem.addActionListener(app);
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // Center panel
        JPanel center = new JPanel();
        center.add(new JLabel("Hello"));

        // Footer
        JPanel footer = new JPanel();
        JLabel footerLabel = new JLabel("Made with love in 2023");
        footerLabel.setFont(DEFAULT_FONT);
        footer.add(footerLabel);

        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, center);
        frame.getContentPane().add(BorderLayout.SOUTH, footer);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Exit":
                System.exit(0);
                break;

            case "About":
                JDialog about = new JDialog((JFrame) null, "About", true);

                String html = "<html>"
                        + "Version: 1.0<br/>"
                        + "Date Started: 2023-10-23<br/>"
                        + "Author: Dureen<br/>"
                        + "GitHub: https://github.com/dureen"
                        + "</html>";

                JLabel title = new JLabel(APP_NAME);
                JLabel info = new JLabel(html);
                info.setFont(DEFAULT_FONT);

                about.getContentPane().add(BorderLayout.NORTH, title);
                about.getContentPane().add(BorderLayout.CENTER, info);
                about.setSize(320, 200);
                about.setLocationRelativeTo(null);
                about.setVisible(true);
                break;
        }
    }
}
