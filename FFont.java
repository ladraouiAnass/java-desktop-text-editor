
//package notepad;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author admin
 */

public class FFont extends JFrame {
          public FontPanel panel;
          public FFont(Window win){
//                this.panel = new MainPanel(win);
//                this.add(this.panel);
                       int width  = 500;
                       int high = 300;
//                    this = new JFrame();
                    this.setResizable(false);
                    this.setLocationRelativeTo(null);
                    this.setSize(width,high);
                    this.panel = new FontPanel(((MainPanel)win.tabbed.getComponentAt(0)).zone,win.tabbed);
                    this.panel .setSize(width,high);
                     this.add(panel,BorderLayout.CENTER);        
                     this.setVisible(false);
          }
    
}
