
//package notepad;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;



public class Tabs extends JTabbedPane {
      ArrayList<MainPanel> tabs;
      public Font f ;
      public Color th;
      public Tabs(){
           this.tabs = new ArrayList<>();
      }
      
      public int addTab(MainPanel pan,String name){
          System.out.println(name+" added succesfully");
              this.addTab(name,pan);
              this.tabs.add(pan);
              return 1;      }
}
