
//package notepad;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


 abstract class FileOperations {
     public  static File save(String content) throws IOException{
            JFileChooser fileChooser = new JFileChooser();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int returnValue = fileChooser.showOpenDialog(frame);
             File selectedFile = fileChooser.getSelectedFile();
//             if(!selectedFile.exists()){
                  File file = new File(selectedFile.getAbsolutePath());
                  FileWriter  writer = new FileWriter(file,false);
                  BufferedWriter bw = new BufferedWriter(writer);
                  bw.write(content);
                  bw.close();
                  return file;
     } 
     public static void openFile(String path){
     
     }
     public static void RenameFile(String old_name,String new_name){
     
     }
     
    public static File getFileToOpen() throws IOException{
        JFileChooser fileChooser = new JFileChooser();
        // Set the file filter (optional - restricts the file types to be selected)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();
            
            // Get the path of the selected file
            String filePath = selectedFile.getAbsolutePath();

            // Display the selected file path
            System.out.println("Selected file: " + filePath);
            return selectedFile;
            // You can use this filePath for opening the file or performing operations on it
        } else {
            System.out.println("No file chosen");
//            System.out.println("the directory choosed is : "+selectedFile.getAbsolutePath());
            return null;
        }
    } 
    
    public     static Object lecture(String s) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(new File(s));
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        ois.close();
        return o;
    }
    
    public static void sauvgarder(String s,Object e) throws IOException{
     FileOutputStream fos = new FileOutputStream(new File(s));
     ObjectOutputStream oos = new ObjectOutputStream(fos);
     oos.writeObject(e);
     oos.close();
    }
    
    
}
