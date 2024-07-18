
//package notepad;
import javax.swing.*;
import java.awt.event.*;

public class MyMenu extends JMenuBar{
          FileMenu file ;
          EditMenu edit;
          ViewMenu view;
          public MyMenu(MainPanel mainPan,Tabs tabbed,Window window){
              this.file = new FileMenu("file",tabbed,window);
              this.edit = new EditMenu("edit",tabbed,mainPan.zone, window);
              this.view = new ViewMenu("view",tabbed);
              this.add(this.file);
              this.add(this.edit);
              this.add(this.view);
          }
}
