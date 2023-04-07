import java.awt.*;

public class f1 {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;
    public f1(GUI gui) {
        this.gui = gui;

    }

    public void wordWrap() {
        if (!gui.wordWrapOn) {
            gui.wordWrapOn = true;
            gui.t.setLineWrap(true);
            gui.t.setWrapStyleWord(true);
            gui.iwrap.setText("Word Wrap: On");
        } else {
            gui.wordWrapOn = false;
            gui.t.setLineWrap(false);
            gui.t.setWrapStyleWord(false);
            gui.iwrap.setText("Word Wrap: Off");
        }

    }


    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font) {
        selectedFont = font;

        switch (selectedFont) {
            case "Arial" -> gui.t.setFont(arial);
            case "Comic Sans MS" -> gui.t.setFont(comicSansMS);
            case "Times New Roman" -> gui.t.setFont(timesNewRoman);
        }
    }
}
