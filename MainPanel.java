
//package notepad;
import javax.swing.*;
import java.awt.*;



public class MainPanel extends JPanel {
    
    public Zone zone;
    public JScrollPane scrollPane;
    public MainPanel(Window window){
            this.setLayout(new BorderLayout());
            this.zone = new Zone(window);
            this.scrollPane = new JScrollPane(this.zone);
            this.add(this.scrollPane);      
                      
   }

}