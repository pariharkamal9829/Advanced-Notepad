/// importing the necessary classes from the javax.swing and java.io packages.

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
class Notepad extends JFrame implements ActionListener {
    // Text area for writing
    JTextArea t;

    // white board frame
    JFrame f;
    // Constructor
    Notepad()
    {
        f = new JFrame("Notepad");  // f name frame created
        f.setIconImage(new ImageIcon("icon/icon.png.jpeg").getImage());
        t = new JTextArea();   // Text name t



        // Set the look and feel of the menu bar and logo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Customize the menu bar
        JMenuBar mb = new JMenuBar();  // mb name menubar created
        mb.setBackground(Color.GRAY); // Set the background color of the menu bar


        // m1 menu created
        JMenu m1 = new JMenu("File");

        // m1 menu include 4 items (new,open,save,print)
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi4 = new JMenuItem("Print");
        JMenuItem mi5 = new JMenuItem("Exit");

        // use actionlister for detect action
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi5.addActionListener(this);

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi4);
        m1.add(mi5);

        // second menu list m2(edit)  created
        JMenu m2 = new JMenu("Edit");

        // in m2()edit have 3 option(cut,copy,paste)
        JMenuItem mi6 = new JMenuItem("Undo");
        JMenuItem mi7 = new JMenuItem("cut");
        JMenuItem mi8 = new JMenuItem("copy");
        JMenuItem mi9 = new JMenuItem("paste");

        // add action listener to (cut,copy,paste)
        mi6.addActionListener(this);
        mi7.addActionListener(this);
        mi8.addActionListener(this);
        mi9.addActionListener(this);

        m2.add(mi6);
        m2.add(mi7);
        m2.add(mi8);
        m2.add(mi9);
// last m3 menu created
        JMenuItem mc = new JMenuItem("close");

        mc.addActionListener(this);

        mb.add(m1);
        mb.add(m2);
        mb.add(mc);

        f.setJMenuBar(mb);
        f.add(t);
        f.setSize(500, 500);// size of gui notepad
        f.show();
}

    // If a button is pressed
    public void actionPerformed(ActionEvent e)  ///actionperformed is a method of action listner
    {
        String s = e.getActionCommand();

        switch (s) {
//            case "undo" -> t.undo(); break;
            case "cut" -> t.cut();
            case "copy" -> t.copy();
            case "paste" -> t.paste();
            case "Save" -> {
                // Create an object of JFileChooser class
                JFileChooser j = new JFileChooser("f:");

                // Invoke the showsSaveDialog function to show the save dialog
                int r = j.showSaveDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {

                    // Set the label to the path of the selected directory
                    File fi = new File(j.getSelectedFile().getAbsolutePath());

                    try {
                        // Create a file writer
                        FileWriter wr = new FileWriter(fi, false);

                        // Create buffered writer to write
                        BufferedWriter w = new BufferedWriter(wr);

                        // Write
                        w.write(t.getText());

                        w.flush();
                        w.close();
                    } catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                }
                // If the user cancelled the operation
                else
                    JOptionPane.showMessageDialog(f, "the user cancelled the operation");
            }
            case "Print" -> {
                try {
                    // print the file
                    t.print();
                } catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
            case "Open" -> {
                // Create an object of JFileChooser class
                JFileChooser j = new JFileChooser("f:");

                // Invoke the showsOpenDialog function to show the save dialog
                int r = j.showOpenDialog(null);

                // If the user selects a file
                if (r == JFileChooser.APPROVE_OPTION) {
                    // Set the label to the path of the selected directory
                    File fi = new File(j.getSelectedFile().getAbsolutePath());

                    try {
                        // String
                        String s1;
                        StringBuilder sl;

                        // File reader
                        FileReader fr = new FileReader(fi);

                        // Buffered reader
                        BufferedReader br = new BufferedReader(fr);

                        // Initialize sl
                        sl = new StringBuilder(br.readLine());

                        // Take the input from the file
                        while ((s1 = br.readLine()) != null) {
                            sl.append("\n").append(s1);
                        }

                        // Set the text
                        t.setText(sl.toString());
                    } catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                }
                // If the user cancelled the operation
                else
                    JOptionPane.showMessageDialog(f, "the user cancelled the operation");
            }
            case "New" -> t.setText("Unitiled.txt.1");
            case "close", "exit" -> {
                f.setVisible(false);
                System.exit(0);
            }
        }
    }

    // Main class
    public static void main(String[] args)
    {
        Notepad e = new Notepad();
    }
}