import java.awt.Color;

public class Function_Color {
    GUI gui;
    public  Function_Color(GUI gui){
        this.gui =gui;
    }
        public  void changeColor(String color){

            switch (color) {
                case "Black" -> {
                    gui.w.getContentPane().setBackground(Color.black);
                    gui.t.setBackground(Color.black);
                    gui.t.setForeground(Color.white);
                    break;
                }
                case "Blue" -> {
                    gui.w.getContentPane().setBackground(Color.blue);
                    gui.t.setBackground(Color.blue);
                    gui.t.setForeground(Color.white);
                    break;
                }
                case "Red" -> {
                    gui.w.getContentPane().setBackground(Color.red);
                    gui.t.setBackground(Color.red);
                    gui.t.setForeground(Color.black);
                    break;
                }
                case "Yellow" -> {
                    gui.w.getContentPane().setBackground(Color.yellow);
                    gui.t.setBackground(Color.yellow);
                    gui.t.setForeground(Color.black);
                    break;
                }
                case "Purple" -> {
                    gui.w.getContentPane().setBackground(Color.pink);
                    gui.t.setBackground(Color.pink);
                    gui.t.setForeground(Color.blue);
                    break;
                }
                case "Green" -> {
                    gui.w.getContentPane().setBackground(Color.green);
                    gui.t.setBackground(Color.green);
                    gui.t.setForeground(Color.black);
                    break;
                }
            }
        }
}
