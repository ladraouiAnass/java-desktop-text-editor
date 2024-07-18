
//package notepad;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import java.awt.event.*;

public class EditMenu extends JMenu{
         JMenuItem undo;
         JMenuItem cut;
         JMenuItem paste;
         JMenuItem copy;
         JMenuItem delete;
         JMenuItem find;
         JMenuItem select_all;
         JMenuItem time_date;
         JMenuItem font;
         public EditMenu(String txt,Tabs tabbed,Zone zone,Window window){
             super(txt);
             this.undo = new         JMenuItem("undo            CTRL+Z           ");
             this.cut = new             JMenuItem("cut               CTRL+X           ");
             this.paste = new        JMenuItem("paste           CTRL+V           ");
             this.copy = new          JMenuItem("copy            CTRL+C          ");
             this.delete = new       JMenuItem("delete                                   ");
             this.find = new            JMenuItem("find              CTRL+F           ");
             this.select_all = new JMenuItem("select all     CTRL+A           ");
             this.time_date = new JMenuItem("time date                             ");
             this.font = new             JMenuItem("font            CTRL+SHIFT+F");
             
             this.add(this.undo);
             this.add(this.cut);
             this.add(this.paste);
             this.add(this.copy);
             this.add(this.delete);
             this.add(this.find);
             this.add(this.select_all);
             this.add(this.time_date);
             this.add(this.font);
             
             this.undo.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("undo");
                   
                 }
             });
             this.cut.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("cut");
                   zone.cut();
                 }
             });
             this.paste.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("paste");
                   zone.paste();
                 }
             });
              this.copy.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("copied");
                   zone.copy();
                 }
             });
             this.delete.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("deleted");
                   
                 }
             });
             this.find.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                         window.findpan.setVisible(true);
                 }
             });
             this.select_all.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("all selected");
                 }
             });
              this.time_date.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("time_date");
                 }
             });
              this.font.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                                    window.frame.panel.zone  = ((MainPanel)window.tabbed.getComponentAt(window.tabbed.getSelectedIndex())).zone;
                                    window.frame.setVisible(true);
                                    window.frame.panel.revalidate();
                                    window.frame.panel.repaint();             
                                    window.revalidate();
                 }
             });
         }
}
