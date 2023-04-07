import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class f {
    GUI gui;
    String fileName;
    String fileAddress;

    public f(GUI gui){
        this.gui =gui;

    }
    public void newFile(){
        gui.t.setText("");
        gui.w.setTitle("New");// new file name
        fileName =null;
        fileAddress=null;
    }
    public void open() {
        FileDialog fd = new FileDialog(gui.w, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.w.setTitle(fileName);
        }
        System.out.println("File address and file anme " + fileAddress + fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName)); // you need the address to read a file
            gui.t.setText("");
            String line;
            while((line = br.readLine())!=null) {
                gui.t.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File not Opned!");
        }
    }
    public void save(){
        if(fileName==null){
            saveAs();
        }
        else{
            try{
                FileWriter fw =new FileWriter(fileAddress + fileName);
                fw.write(gui.t.getText());
                gui.w.setTitle(fileName);
                fw.close();
            }catch (Exception e){
                System.out.println("SOMETHING WRONG!");
            }
        }

    }

    public void saveAs(){
        FileDialog fd =new FileDialog(gui.w, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress =fd.getDirectory();
            gui.w.setTitle(fileName);
        }
        try{
            FileWriter fw =new FileWriter(fileAddress + fileName);
            fw.write(gui.t.getText());
            fw.close();
        }catch (Exception e){
            System.out.println("SOMETHING WRONG!");
        }
    }

public  void exit(){
        System.exit(0);
}







}


