import javax.swing.*; /// for displaying window we used this library
import javax.swing.JTextArea;  //for dispaly text area we used
import javax.swing.JMenuBar;  //menu bar
import javax.swing.JScrollPane; //scroll bar
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.event.UndoableEditEvent;  // undo library
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class GUI implements ActionListener {
    static JFrame w;
    JTextArea t;
    boolean wordWrapOn =false;
    JScrollPane sl;  //For vertical and horizontal scroll bar
    JMenuBar mb;  // for menu bar
    JMenuItem m1;
    JMenuItem m2;
    JMenuItem m3;
    JMenuItem m4;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iPrint, iExit; ///file menu list
    JMenuItem iundo, iredo, icopy, ipaste, idelete, icut, iselectall ;
    JMenuItem iwrap;
    JMenuItem iFontArial;
    JMenuItem iFontCSMS;
    JMenuItem iFontTNR;
    JMenu menuFont;
    JMenu menuFontSize;
    JMenuItem iblack, ired, iblue ,iyellow, igreen, ipurple; /// color menu list
    f file =new f(this);  // link f.java  menu 1st function file
    //link f1.java menu edit fucnction file
    f1 format =new f1(this);
    Function_Color color =new Function_Color(this);  //color function file link
    Function_edit edit =new Function_edit(this);  // edit menu function file
    UndoManager um =new UndoManager(); // undo library link in f1

    public static void main(String[] args) {
        //-----------------adding oniline NImubus Theme for creative viual in notepad
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // replace with your preferred theme
        } catch (Exception e) {
            e.printStackTrace();
        }
        new GUI();

    }
//------------------------------------------------------------------------------------------------------------

    public GUI() {
        createWindow();
        createTextarea();
        createMenubar();
        createFileMenu();
        createEditMenu();
        createViewMenu();
        createColorMenu();

        format.selectedFont = "Arial";
        format.createFont(14);
        format.wordWrap();
        color.changeColor("Black");
        w.setVisible(true);
        t.setBackground(new Color(43, 43, 43));  // textarea bg color default
        t.setForeground(new Color(248, 248, 242));
        Image icon = Toolkit.getDefaultToolkit().getImage("src/resource/notepad.png");
        w.setIconImage(icon);/// load new icon of notepad in text editor


    }


    public void createWindow() {
        w = new JFrame("Notepad");
        w.setSize(600, 600);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextarea() {

        t = new JTextArea();
        t.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                }
        );
        sl = new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sl.setBorder(BorderFactory.createEmptyBorder());
        w.add(sl);
    }

    public void createMenubar() {
        mb = new JMenuBar();
        w.setJMenuBar(mb);

        m1 = new JMenu("File");
        mb.add(m1);

        m2 = new JMenu("Edit");
        mb.add(m2);

        m3 = new JMenu("View");
        mb.add(m3);

        m4 = new JMenu("Color");
        mb.add(m4);
    }

    public void createFileMenu() {
        iNew = new JMenuItem("New           Ctrl+N");
        iNew.addActionListener(this);
        iNew.setActionCommand("New" );
        m1.add(iNew);
        iOpen = new JMenuItem("Open          Ctrl+O");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open" );
        m1.add(iOpen);
        iSave = new JMenuItem("Save          Ctrl+S");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save" );
        m1.add(iSave);
        iSaveAs = new JMenuItem("Save As    Ctrl+Shift+S");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs" );
        m1.add(iSaveAs);
        iPrint = new JMenuItem("Print           Ctrl+P");
        iPrint.addActionListener(this);
        iPrint.setActionCommand("Print" );
        m1.add(iPrint);
        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit" );
        m1.add(iExit);
    }

    private void createEditMenu() {

        iundo =new JMenuItem("Undo                Ctrl+Z ");
        iundo.addActionListener(this);
        iundo.setActionCommand("Undo");
        m2.add(iundo);
        iredo =new JMenuItem("Redo                Ctrl+Y ");
        iredo.addActionListener(this);
        iredo.setActionCommand("Redo");
        m2.add(iredo);
        icut =new JMenuItem("Cut                   Ctrl+X ");
        icut.addActionListener(this);
        icut.setActionCommand("Cut");
        m2.add(icut);
        icopy =new JMenuItem("Copy                Ctrl+C ");
        icopy.addActionListener(this);
        icopy.setActionCommand("Copy");
        m2.add(icopy);
        ipaste =new JMenuItem("Paste               Ctrl+V");
        ipaste.addActionListener(this);
        ipaste.setActionCommand("Paste");
        m2.add(ipaste);
        idelete =new JMenuItem("Delete              Del");
        idelete.addActionListener(this);
        idelete.setActionCommand("Delete");
        m2.add(idelete);
        iselectall =new JMenuItem("Select All        Ctrl+A");
        iselectall.addActionListener(this);
        iselectall.setActionCommand("Select All");
        m2.add(iselectall);
    }

    private void createViewMenu() {
        iwrap =new JMenuItem("Word Wrap: Off");
        iwrap.addActionListener(this);
        iwrap.setActionCommand("Word Wrap");
        m3.add(iwrap);

        menuFont =new JMenu("Font");
        m3.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);


        menuFontSize =new JMenu("Font Size");
        m3.add(menuFontSize);

        int[] fontSizes = {8, 10, 12, 16, 20, 28,36,54 };

        for (int fontSize : fontSizes) {
            JMenuItem menuItem = new JMenuItem(Integer.toString(fontSize));
            menuItem.addActionListener(this);
            menuItem.setActionCommand(Integer.toString(fontSize));
            menuFontSize.add(menuItem);
        }
    }


    private void createColorMenu() {
    iblack =new JMenuItem("Black   Bg");
    iblack.addActionListener(this);
    iblack.setActionCommand("Black");
    m4.add(iblack);
    ired =new JMenuItem("Red     Bg");
    ired.addActionListener(this);
    ired.setActionCommand("Red");
    m4.add(ired);
    igreen =new JMenuItem("Green  Bg");
    igreen.addActionListener(this);
    igreen.setActionCommand("Green");
    m4.add(igreen);
    iyellow =new JMenuItem("Yellow  Bg");
    iyellow.addActionListener(this);
    iyellow.setActionCommand("Yellow");
    m4.add(iyellow);
    ipurple =new JMenuItem("Purple  Bg");
    ipurple.addActionListener(this);
    ipurple.setActionCommand("Purple");
    m4.add(ipurple);

    iblue =new JMenuItem("Blue Bg");
    iblue.addActionListener(this);
    iblue.setActionCommand("blue");
    }



    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New" -> file.newFile();
            case "Open" -> file.open();
            case "Save" -> file.save();
            case "SaveAs" -> file.saveAs();
            case "Print" -> {
                try {
                    // print the file
                    t.print();
                } catch (Exception evt) {
                    JOptionPane.showMessageDialog(t, evt.getMessage());
                }
            }
            case "Exit" -> file.exit();
            case "Undo" ->edit.undo();
            case "Redo" ->edit.redo();
            case "Cut" ->t.cut();
            case "Copy" ->t.copy();
            case "Paste" ->t.paste();
            case "Delete" ->t.replaceSelection("");
            case "Select All" ->t.selectAll();
            case "Word Wrap" -> format.wordWrap();
            case "Arial", "Comic Sans MS", "Times New Roman" -> format.setFont(command);
            case "Black","Blue", "Yellow", "Red", "Green", "Purple" -> color.changeColor(command);
            case "8", "10", "12", "16", "20", "28", "36","54" -> {
                int fontSize = Integer.parseInt(e.getActionCommand());
                format.createFont(fontSize);
            }
        }
    }
}

