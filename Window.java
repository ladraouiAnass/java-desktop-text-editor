
//package notepad;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

public class Window  extends JFrame{
      MyMenu  menu;
      JPanel mainPanel;
      Tabs tabbed;
       JPanel bigpan;
       JPanel findpan;
       JButton search;
       JButton next;
       JButton previous;
       JButton close;
       JTextField field;
       JTextField repfield;
       JButton replace;
       JButton rep_all;
        FFont frame;
       public static int order = 1;
      public Window(){
          

          this.close = new JButton("close");
          this.field = new JTextField();
          this.search = new JButton("find");
          this.next = new JButton("find next");
          this.previous = new JButton("find previous");
          this.repfield = new JTextField();
          this.replace = new JButton("replace");
          this.rep_all = new JButton("replace all");
          this.findpan = new JPanel();
          this.findpan.setLayout(new BoxLayout(this.findpan,BoxLayout.X_AXIS));
          this.findpan.add(this.field);
          this.findpan.add(this.search);
          this.findpan.add(this.next);
          this.findpan.add(this.previous);
          this.findpan.add(this.repfield);
          this.findpan.add(this.replace);
          this.findpan.add(this.rep_all);
          this.findpan.add(this.close);
          this.findpan.setVisible(false);
            this.bigpan = new JPanel(new BorderLayout());
            this.mainPanel = new MainPanel(this);    
            this.tabbed = new Tabs();
            this.menu = new MyMenu((MainPanel) this.mainPanel,this.tabbed,this);
            this.setJMenuBar(this.menu);
            this.tabbed.addTab((MainPanel) mainPanel, "untitled");
            this.setSize(900, 500);
           this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            this.bigpan.add(this.tabbed,BorderLayout.CENTER);
            this.bigpan.add(this.findpan,BorderLayout.SOUTH);
//        getContentPane().add(this.tabbed); 
            getContentPane().add(this.bigpan);
            
             this.frame = new FFont(this);
            
         this.close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findpan.setVisible(!findpan.isVisible());
                Window.order = 1;
            }
        });
         this.search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Zone zone = (Zone)((MainPanel)tabbed.getComponent(tabbed.getSelectedIndex())).zone;
                if(field.getText().length()!=0 && zone.getText().length()!=0){
                    Window.order=1;
                     EditOperations.find(field.getText(), zone,Window.order);
                }
             }
        });
  
         this.next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Zone zone = (Zone)((MainPanel)tabbed.getComponent(tabbed.getSelectedIndex())).zone;
                if(field.getText().length()!=0 && zone.getText().length()!=0){
                     Window.order +=1;
                     EditOperations.find(field.getText(), zone,Window.order);
                }
                }
        });
    
         this.previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Zone zone = (Zone)((MainPanel)tabbed.getComponent(tabbed.getSelectedIndex())).zone;
                if(field.getText().length()!=0 && zone.getText().length()!=0){
                     if(Window.order>=1) Window.order-=1;
                     EditOperations.find(field.getText(), (Zone)((MainPanel)tabbed.getComponent(tabbed.getSelectedIndex())).zone,Window.order);
                }
                }
        });
         
          this.replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                 Zone zone = (Zone)((MainPanel)tabbed.getComponent(tabbed.getSelectedIndex())).zone;
                if(zone.getText().length()!=0 && field.getText().length()!=0 && repfield.getText().length()!=0){
                       EditOperations.replaceSelected(zone,field.getText(),repfield.getText());
                }
            }
        });        
         
         this.rep_all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window.order=1;
                Zone zone = (Zone)((MainPanel)tabbed.getComponent(tabbed.getSelectedIndex())).zone;
                if(zone.getText().length()!=0 && field.getText().length()!=0 && repfield.getText().length()!=0){
                      EditOperations.replaceAllSelected(zone,field.getText(),repfield.getText());
                }
            }
        });
          
      }
      
      public static void main(String args[]){
           new Window();
      }
      
}
