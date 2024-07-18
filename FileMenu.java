
//package notepad;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileMenu extends JMenu {
    
          JMenuItem new_tab;
          JMenuItem new_window;
          JMenuItem open;
          JMenuItem save;
          JMenuItem save_as;
          JMenuItem save_all;
          JMenuItem page_setup;
          JMenuItem print;
          JMenuItem close_tab;
          JMenuItem close_window;
          JMenuItem exit;
         public FileMenu(String txt,Tabs tabbed,Window window){
             super(txt);
             this.new_tab =            new JMenuItem("new tab                               CTRL+N");
             this.new_window =   new JMenuItem("new window           CTRL+SHIFT+N");
             this.open =                   new JMenuItem("open                                    CTRL+O");
             this.save =                    new JMenuItem("save                                     CTRL+S");
             this.save_as =             new JMenuItem("save as                   CTRL+SHIFT+S");
             this.save_all =             new JMenuItem("save all                       CTRL+ALT+S");
             this.page_setup =      new JMenuItem("page setup                                         ");
             this.print =                    new JMenuItem("print                                       CTRL+P");
             this.close_tab =          new JMenuItem("close tab                              CTRL+W");
             this.close_window = new JMenuItem("close window          CTRL+SHIFT+W");
             this.exit  = new JMenuItem("exit");
             this.add(this.new_tab);
             this.add(this.new_window);
             this.add(this.open);
             this.add(this.save);
             this.add(this.save_as);
             this.add(this.save_all);
             this.add(this.page_setup);
             this.add(this.print);
             this.add(this.close_tab);
             this.add(this.close_window);
             this.add(this.exit);
             
             this.new_tab.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("new tab added");
                   tabbed.addTab(new MainPanel(window),"untitled tab");
                   int indx = tabbed.getTabCount()-1;
                   tabbed.setSelectedIndex(indx);
                   tabbed.revalidate();
                 }
             });
              
             this.new_window.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                     
                   System.out.println("new window added");
                    new Window();
                 }
             });
             
             this.open.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("opened");
                    File file;
                 try {
                                
                        int optionChosen = JOptionPane.showOptionDialog(
                              window,
                              "open with color?:",
                              "Button Dialog",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE,
                              null,
                              new Object[]{"yes", "no"},
                              "yes");  
                              file = FileOperations.getFileToOpen();

                                if (optionChosen == JOptionPane.YES_OPTION) {
                                      Zone newzone;

                                      newzone = (Zone)FileOperations.lecture(file.getAbsolutePath());

                                      int indx = window.tabbed.getTabCount()-1;
                                      ((MainPanel)window.tabbed.getComponentAt(indx)).zone.setText(newzone.getText()) ;
                                      ((MainPanel)window.tabbed.getComponentAt(indx)).zone.setForeground(newzone.getForeground()); 
                                      ((MainPanel)window.tabbed.getComponentAt(indx)).zone.setBackground(newzone.getBackground());
                                      ((MainPanel)window.tabbed.getComponentAt(indx)).zone.setFont(newzone.getFont());
                                      ((MainPanel)window.tabbed.getComponentAt(indx)).zone.revalidate();
                                      window.tabbed.revalidate();
                                      window.revalidate();
                               } else if (optionChosen == JOptionPane.NO_OPTION) {
                                        BufferedReader reader = new BufferedReader(new FileReader(file));
                                        StringBuilder content = new StringBuilder();
                                        String line;
                                        while((line = reader.readLine())!=null){
                                             content.append(line).append("\n");
                                        }
                                        reader.close();
                                        MainPanel pan = new MainPanel(window);
                                        pan.zone.setText(content.toString());
                                        pan.zone.file = file;
                                        window.tabbed.addTab(pan, file.getName());
                                        int indx = window.tabbed.getTabCount()-1;
                                        window.tabbed.setSelectedIndex(indx);                   
                              } else {
                                         BufferedReader reader = new BufferedReader(new FileReader(file));
                                        StringBuilder content = new StringBuilder();
                                        String line;
                                        while((line = reader.readLine())!=null){
                                             content.append(line).append("\n");
                                        }
                                        reader.close();
                                        MainPanel pan = new MainPanel(window);
                                        pan.zone.setText(content.toString());
                                        pan.zone.file = file;
                                        window.tabbed.addTab(pan, file.getName());
                                        int indx = window.tabbed.getTabCount()-1;
                                        window.tabbed.setSelectedIndex(indx);      

                             }

                           } catch (IOException ex) {
                                System.out.println("il faut choisir un fichier est pas un folder");
                           }catch(ClassNotFoundException cnf) {
                                  System.out.println("pas de style pour ce text");                         
                           }
                 }
             });
             
             
             
             this.save.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("saved");
                   int selectedIndex = tabbed.getSelectedIndex();
                   Component pan = tabbed.getComponent(selectedIndex);
                   if(((MainPanel)pan).zone.file != null){
                        String path = ((MainPanel)pan).zone.file.getAbsolutePath();
                        String content = ((MainPanel)pan).zone.getText();
                       try {
                           File file = new File(path);
                           FileWriter writer = new FileWriter(file,false);
                           BufferedWriter bw = new BufferedWriter(writer);
                           bw.write(content);
                           bw.close();
                       } catch (IOException ex) {
//                           Logger.getLogger(FileMenu.class.getName()).log(Level.SEVERE, null, ex);
                           System.out.println("ce fichier n'est pas existe");
                       }
                   }else{
                       try {
                           File file = FileOperations.save(((MainPanel)pan).zone.getText());
                           tabbed.setTitleAt(selectedIndex, file.getName());
                           ((MainPanel)pan).zone.file = file;
                           ((MainPanel)pan).zone.revalidate();
                           tabbed.revalidate();
                       } catch (IOException ex) {
                           Logger.getLogger(FileMenu.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                 }
             });
             
             this.save_as.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("saved as");
                       
                            int optionChosen = JOptionPane.showOptionDialog(
               window,
               "save as with color?:",
               "Button Dialog",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,
               new Object[]{"yes", "no"},
               "yes");
                       
              if (optionChosen == JOptionPane.NO_OPTION) {
                           System.out.println("if lwla khasra");
                            int selectedIndex = window.tabbed.getSelectedIndex();
                            Component pan = window.tabbed.getComponent(selectedIndex);
                             try {
                                 File f = FileOperations.save(((MainPanel)pan).zone.getText());
                                 window.tabbed.setTitleAt(selectedIndex, f.getName());
                                 ((MainPanel)pan).zone.file = f;
                                 ((MainPanel)pan).zone.revalidate();
                                 window.tabbed.revalidate();
                             } catch (IOException ex) {
         //                        Logger.getLogger(FileMenu.class.getName()).log(Level.SEVERE, null, ex);
                             }                  
                }else if(optionChosen == JOptionPane.YES_OPTION){
                                int selectedIndex = window.tabbed.getSelectedIndex();
                               Component pan = window.tabbed.getComponent(selectedIndex);

                                try {
                                    File f = FileOperations.save("");
                                    FileOperations.sauvgarder(f.getAbsolutePath(),((MainPanel)pan).zone);
                                    window.tabbed.setTitleAt(selectedIndex, f.getName());
                                    ((MainPanel)pan).zone.file = f;
                                    ((MainPanel)pan).zone.revalidate();
                                    window.tabbed.revalidate();
                                } catch (IOException ex) {
            //                        Logger.getLogger(FileMenu.class.getName()).log(Level.SEVERE, null, ex);
                                }     
                }else{
                    System.out.println("il faut choisir");
                }  
                 }
             });
             
             this.save_all.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("all saved");
                    for (int i = 0; i < tabbed.getTabCount(); i++) {
                        Component pan = tabbed.getComponent(i);
                        System.out.println("saved as");
                        System.out.println("saved");
                         try {
                             File file = FileOperations.save(((MainPanel)pan).zone.getText());
                             tabbed.setTitleAt(i, file.getName());
                             ((MainPanel)pan).zone.file = file;
                             ((MainPanel)pan).zone.revalidate();
                             tabbed.revalidate();
                         } catch (IOException ex) {
                             Logger.getLogger(FileMenu.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    }
                 }
             });
//             
//             this.page_setup.addActionListener(new ActionListener(){
//                 public void actionPerformed(ActionEvent e){
//                   System.out.println("page setup showed");
//                 }
//             });
//             
//             this.print.addActionListener(new ActionListener(){
//                 public void actionPerformed(ActionEvent e){
//                   System.out.println("printed");
//                 }
//             });
             
             this.close_tab.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("tab closed");
                                    int selectedIndex = tabbed.getSelectedIndex();
                                    tabbed.remove(selectedIndex);
                 }
             });
             
             this.close_window.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("window closed");
                   window.dispose();

                 }
             });
             
             this.exit.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                   System.out.println("exited");
                   System.exit(0);
                 }
             });

             
             
             
             
             
             
         }
}
