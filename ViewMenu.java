
//package notepad;
import java.awt.Component;
import java.awt.Font;
import java.awt.List;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ViewMenu extends JMenu {
       JMenuItem zoom_in;
       JMenuItem zoom_out;
        JMenuItem default_zoom;
    
       public ViewMenu(String txt,Tabs tabbed){
           super(txt);
            this.zoom_in = new JMenuItem   ("zoom in         CTRL+SPACE     ");
            this.zoom_out = new JMenuItem("zoom out       CTRL+-      ");
            this.default_zoom =  new JMenuItem("restore default           ");

            this.add(this.zoom_in);
            this.add(this.zoom_out);
            this.add(this.default_zoom);
           
             this.zoom_in.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                                    System.out.println("zoomed in");
                                    int selectedIndex = tabbed.getSelectedIndex();
                                    Component selectedPanel = tabbed.getComponentAt(selectedIndex);
                                    if(selectedPanel instanceof  MainPanel){
                                          for(int i =0;i<tabbed.tabs.size();i++){
                                              if( tabbed.tabs.get(i)==(MainPanel)selectedPanel){
                                                   tabbed.tabs.get(i).zone.fontDeg+=2;
                                                Font customFont = new Font(tabbed.tabs.get(i).zone.getFont().getName(), Font.PLAIN, tabbed.tabs.get(i).zone.fontDeg);
                                                 tabbed.tabs.get(i).zone.setFont(customFont);
                                                 tabbed.tabs.get(i).zone.revalidate();
                                              }
                                          }
                                    }
                        }
             });
             this.zoom_out.addActionListener(new ActionListener(){
                          public void actionPerformed(ActionEvent e){
                                    System.out.println("zoomed out");
                                    int selectedIndex = tabbed.getSelectedIndex();
                                    Component selectedPanel = tabbed.getComponentAt(selectedIndex);
                                    if(selectedPanel instanceof  MainPanel){
                                          for(int i =0;i<tabbed.tabs.size();i++){
                                              if( tabbed.tabs.get(i)==(MainPanel)selectedPanel){
                                                   tabbed.tabs.get(i).zone.fontDeg-=2;
                                                Font customFont = new Font(tabbed.tabs.get(i).zone.getFont().getName(), Font.PLAIN, tabbed.tabs.get(i).zone.fontDeg);
                                                 tabbed.tabs.get(i).zone.setFont(customFont);
                                                 tabbed.tabs.get(i).zone.revalidate();
                                              }
                                          }
                                    }
                          }
             });

              this.default_zoom.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                        System.out.println("default zoom restored");
                                    int selectedIndex = tabbed.getSelectedIndex();
                                    Component selectedPanel = tabbed.getComponentAt(selectedIndex);
                                    if(selectedPanel instanceof  MainPanel){
                                          for(int i =0;i<tabbed.tabs.size();i++){
                                              if( tabbed.tabs.get(i)==(MainPanel)selectedPanel){
                                                   tabbed.tabs.get(i).zone.fontDeg=16;
                                                Font customFont = new Font("Arial", Font.PLAIN, tabbed.tabs.get(i).zone.fontDeg);
                                                 tabbed.tabs.get(i).zone.setFont(customFont);
                                                 tabbed.tabs.get(i).zone.revalidate();
                                              }
                                          }
                                    }
                            }
             });
           
       }
}
