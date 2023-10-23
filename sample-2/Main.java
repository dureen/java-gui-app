// import javax.swing.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Main implements ActionListener {
    public static String appName = "My GUI Application 2";
    public static Font defaultFont = new Font(Font.SANS_SERIF, Font.PLAIN, 13);

    public static void main(String[] args){
        // System.out.println("Hello World!");
        JFrame frame = new JFrame(Main.appName);
        
        // app configuration
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720,480);

        
        Main instanceOfMainClass = new Main();

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // Create menu
        JMenu mFile = new JMenu("File");
        mFile.setFont(defaultFont);
        JMenu mHelp = new JMenu("Help");
        mHelp.setFont(defaultFont);

        // Create menu item

        JMenuItem miOpenFile = new JMenuItem("Open File...    ");
        miOpenFile.setFont(defaultFont);
        mFile.add(miOpenFile);

        mFile.add(new JSeparator());

        JMenuItem miSave = new JMenuItem("Save");
        miSave.setFont(defaultFont);
        mFile.add(miSave);

        JMenuItem miSaveAs = new JMenuItem("Save As...");
        miSaveAs.setFont(defaultFont);
        mFile.add(miSaveAs);

        mFile.add(new JSeparator());

        JMenuItem miExit = new JMenuItem("Exit");
        miExit.setFont(defaultFont);
        // miExit.addActionListener(new ActionListener(){
        //     public void actionPerformed(ActionEvent e){
        //         // System.out.println("The end is near!");
        //         System.exit(0);
        //     }
        // });
        miExit.addActionListener(instanceOfMainClass);
        mFile.add(miExit);

        // Help Menu
        // ... code ...
        // mHelp.add(new JSeparator());

        JMenuItem miAbout = new JMenuItem("About");
        miAbout.setFont(defaultFont);
        miAbout.addActionListener(instanceOfMainClass);
        mHelp.add(miAbout);
        
        // Load MenuBar menu
        menuBar.add(mFile);
        menuBar.add(mHelp);

        // Center Panel
        JPanel container = new JPanel();
        JLabel containerLabel = new JLabel("Hello");
        container.add(containerLabel);

        // Bottom Panel
        JPanel footer = new JPanel();
        JLabel footerLabel = new JLabel("Made with love in 2023");
        footerLabel.setFont(defaultFont);
        footer.add(footerLabel);

        // JButton button = new JButton("Press");

        // Font
        
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, container);
        frame.getContentPane().add(BorderLayout.SOUTH, footer);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
    }

    public void actionPerformed(ActionEvent e){
        String targetCommand = e.getActionCommand();
        switch (targetCommand) {
            case "Exit":
                System.exit(0);
                break;
            case "About":
                JDialog aboutApp = new JDialog(new JFrame(), "About");
                    JLabel labelA = new JLabel((String) this.appName);
                    // labelA.setFont(defaultFont);
                    String text = "<html>";
                    text += "Version: 1.0<br/>";
                    text += "Date Started: 2023-10-23<br/>";
                    text += "Author: Dureen DPDevProject<br/>";
                    text += "Github: <a href='https://github.com/dureen' target='_blank'>https://github.com/dureen</a><br/>";
                    text += "</html>";
                    JLabel labelB = new JLabel();
                    labelB.setText(text);
                    labelB.setFont(defaultFont);
                    aboutApp.getContentPane().add(BorderLayout.NORTH,labelA);
                    aboutApp.getContentPane().add(BorderLayout.CENTER,labelB);
                    aboutApp.setSize(300,300);
                    aboutApp.setLocationRelativeTo(null);
                    aboutApp.setModal(true);
                    aboutApp.setAlwaysOnTop(true);
                    aboutApp.setVisible(true);
                break;
        }
    }
}