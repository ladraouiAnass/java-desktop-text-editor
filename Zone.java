
//package notepad;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Zone extends JTextPane{
      int fontDeg = 16;
      File file;
      public static JLabel font;
      public static JTextField theme;
      Window win;
      
       public Zone(Window window){
           Zone z =this;
           this.win = window;
           Zone.theme = new JTextField();
           Zone.theme.setText("exemple");
           Zone.font = new JLabel();
           Zone.font.setText("exemple");
           this.file=null;
           this.fontDeg = 16;
           Font customFont = new Font("Arial", Font.PLAIN, this.fontDeg); // "Arial" with size 16
           this.setFont(customFont);
           this.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); 
                }
                @Override
                public void keyPressed(KeyEvent e) {
                       try {
                              if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
                                        int selectedIndex = window.tabbed.getSelectedIndex();
                                        Component pan = window.tabbed.getComponent(selectedIndex);
                                        if(file != null){
                                                  String path = file.getAbsolutePath();
                                                  String content = getText();
                                                   File file = new File(path);
                                                   FileWriter writer = new FileWriter(file,false);
                                                   BufferedWriter bw = new BufferedWriter(writer);
                                                   bw.write(content);
                                                   bw.close();               
                                       }else{
                                            File file = FileOperations.save(getText());
                                            window.tabbed.setTitleAt(window.tabbed.getSelectedIndex(), file.getName());
                                            file = file;
                                            revalidate();
                                            window.tabbed.revalidate();
                                      }
                              }
                       } catch (IOException ex) {
                            Logger.getLogger(FileMenu.class.getName()).log(Level.SEVERE, null, ex);
                       }
                 }
                @Override
                public void keyReleased(KeyEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet.");
                }
           });
           
           this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
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
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });
           

           this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
                        System.out.println("new tab added");
                        window.tabbed.addTab(new MainPanel(window),"untitled-2");
                        int indx = window.tabbed.getTabCount()-1;
                        window.tabbed.setSelectedIndex(indx);
                        window.tabbed.revalidate();
                    }
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });           
           
           this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() && e.isShiftDown() &&e.getKeyCode() == KeyEvent.VK_N) {
                            new Window();
                    }
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });   
        
           this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown()  && e.isShiftDown()&& e.getKeyCode() == KeyEvent.VK_S) {
                        
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
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });
          
           
           this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() &&   e.getKeyCode() == KeyEvent.VK_W) {
                                     int selectedIndex = window.tabbed.getSelectedIndex();
                                    window.tabbed.remove(selectedIndex);
                    }
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });  
     
           this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() &&  e.isShiftDown()  && e.getKeyCode() == KeyEvent.VK_W) {
                          window.dispose();
                    }
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });  
           
           
           this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() &&  e.isAltDown()  && e.getKeyCode() == KeyEvent.VK_S) {
                    for (int i = 0; i < window.tabbed.getTabCount(); i++) {
                        Component pan = window.tabbed.getComponent(i);
                        System.out.println("saved as");
                        System.out.println("saved");
                         try {
                             File file = FileOperations.save(((MainPanel)pan).zone.getText());
                             window.tabbed.setTitleAt(i, file.getName());
                             ((MainPanel)pan).zone.file = file;
                             ((MainPanel)pan).zone.revalidate();
                             window.tabbed.revalidate();
                         } catch (IOException ex) {
//                             Logger.getLogger(FileMenu.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    }
                    }
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });            
           
            this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() && !e.isShiftDown() &&  e.getKeyCode() == KeyEvent.VK_F) {
                        window.findpan.setVisible(true);
                    }
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });  
  
           this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() &&  e.isShiftDown()  && e.getKeyCode() == KeyEvent.VK_F) {
//                      if(!window.frame.isVisible()){
                                    window.frame.panel.zone  = ((MainPanel)window.tabbed.getComponentAt(window.tabbed.getSelectedIndex())).zone;
                                    window.frame.setVisible(true);
                                    window.frame.panel.revalidate();
                                    window.frame.panel.repaint();             
                                    window.revalidate();
//                      }    
                    }
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });     
           
           
            this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() &&   e.getKeyCode() == KeyEvent.VK_SPACE) {
                                    System.out.println("zoomed in");
                                    int selectedIndex = window.tabbed.getSelectedIndex();
                                    Component selectedPanel = window.tabbed.getComponentAt(selectedIndex);
                                    if(selectedPanel instanceof  MainPanel){
                                          for(int i =0;i<window.tabbed.tabs.size();i++){
                                              if( window.tabbed.tabs.get(i)==(MainPanel)selectedPanel){
                                                   window.tabbed.tabs.get(i).zone.fontDeg+=2;
                                                Font customFont = new Font(window.tabbed.tabs.get(i).zone.getFont().getName(), Font.PLAIN, window.tabbed.tabs.get(i).zone.fontDeg);
                                                 window.tabbed.tabs.get(i).zone.setFont(customFont);
                                                 window.tabbed.tabs.get(i).zone.revalidate();
                                              }
                                          }
                                    }
                    }
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });  
            
    
           
             this.addKeyListener(new KeyListener(){

               @Override
               public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() &&   e.getKeyCode() == KeyEvent.VK_MINUS) {
                                    System.out.println("zoomed in");
                                    int selectedIndex = window.tabbed.getSelectedIndex();
                                    Component selectedPanel = window.tabbed.getComponentAt(selectedIndex);
                                    if(selectedPanel instanceof  MainPanel){
                                          for(int i =0;i<window.tabbed.tabs.size();i++){
                                              if( window.tabbed.tabs.get(i)==(MainPanel)selectedPanel){
                                                  if(window.tabbed.tabs.get(i).zone.fontDeg>2) window.tabbed.tabs.get(i).zone.fontDeg-=2;
                                                Font customFont = new Font(window.tabbed.tabs.get(i).zone.getFont().getName(), Font.PLAIN, window.tabbed.tabs.get(i).zone.fontDeg);
                                                 window.tabbed.tabs.get(i).zone.setFont(customFont);
                                                 window.tabbed.tabs.get(i).zone.revalidate();
                                              }
                                          }
                                    }
                    }
               }
               @Override
               public void keyTyped(KeyEvent e) {}

               @Override
               public void keyReleased(KeyEvent e) {}
           
           });            
           
           
      }
}
