
//package notepad;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.text.StyleConstants;

public class FontPanel extends JPanel {
         JPanel theme;
         JPanel font;
         JPanel size;
         JPanel fontcolor;
         JPanel testPan;
         JLabel exemple;
         JTextField thexemple;
         Zone zone;
      public FontPanel(Zone z,Tabs tabbed){
          this.zone = z;
          this.thexemple = new JTextField();
          this.thexemple.setText("exemple");
          
          
               this.theme = new JPanel();
               this.theme.setLayout(new BoxLayout(this.theme,BoxLayout.X_AXIS));
               this.font = new JPanel();
               this.font.setLayout(new BoxLayout(this.font , BoxLayout.Y_AXIS));
               JRadioButton white = new JRadioButton(" white mode ");
              JRadioButton dark = new JRadioButton("black mode");

                     
            JPanel pvalidate = new JPanel();
            pvalidate.setLayout(new BoxLayout(pvalidate , BoxLayout.X_AXIS));
            JButton validate = new JButton("definir");
            validate.setSize(80, 50);
            pvalidate.add(validate);
                 validate.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) {
                        Zone.font = exemple;
                        Zone.theme = thexemple;
                        zone.setFont(Zone.font.getFont());
                        zone.setBackground(Zone.theme.getBackground());
                        zone.setForeground(Zone.font.getForeground());
//                        tabbed.f = exemple.getFont();
//                        tabbed.th = thexemple.getBackground();
//                        tabbed.revalidate();
//                        for (int i =0;i<tabbed.getTabCount()-1;i++){
//                            MainPanel pan = (MainPanel)tabbed.getComponentAt(i);
//                            pan.zone.setBackground(tabbed.th);
////                            z.setForeground(tabbed.f.getForeground());
//                            pan.zone.setFont(tabbed.f);
//                            pan.zone.revalidate();
//                            pan.revalidate();
//                        }
                        
//                        tabbed.revalidate();
//                        tabbed.repaint();
                        zone.revalidate();
                        validate.revalidate();
                   }
                 
               });
              this.add(pvalidate);
               
               
               
               
//               this.theme = new JPanel();
//               this.theme.setLayout(new BoxLayout(this.theme,BoxLayout.X_AXIS));
//               this.font = new JPanel();
//               this.font.setLayout(new BoxLayout(this.font , BoxLayout.Y_AXIS));
//               JRadioButton white = new JRadioButton(" white mode ");
//              JRadioButton dark = new JRadioButton("black mode");


        ButtonGroup group = new ButtonGroup();
        group.add(white);
        group.add(dark);
        JLabel selectTheamLabel = new JLabel();
        selectTheamLabel.setText("selectionner le theme a utiliser                 ");
                theme.add(selectTheamLabel);
                theme.add(white);
                theme.add(dark);
        white.setSelected(true);
        white.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (white.isSelected()) {
                     thexemple.setBackground(Color.WHITE);
                    thexemple.setForeground(Color.BLACK);
                }
            }
        });

        dark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dark.isSelected()) {
                    Color color = new Color(73, 69, 78); // RGB values for red
                     thexemple.setBackground(color);
                     thexemple.setForeground(Color.WHITE);
                }
            }
        });
        
//               JPanel family = new JPanel();
//               family.setLayout(new BoxLayout(family,BoxLayout.X_AXIS));
//               JLabel lfamily = new JLabel();
              


        JPanel style = new JPanel();
        style.setLayout(new BoxLayout(style,BoxLayout.X_AXIS));
        JLabel setStyleLabel = new JLabel();
         setStyleLabel.setText("selectionner le style a utiliser                     ");
        String[] fontStyles = {"Arial","Times New Roman", "Verdana", "Tahoma","Helvetica","Courier New","Georgia","Comic Sans MS","Palatino","Impact","Lucida Console", "Trebuchet MS",
                                         "Book Antiqua","Century Gothic","Garamond","Franklin Gothic Medium", "Copperplate", "Baskerville","Futura","Rockwell"
                                            };

        JComboBox cstyle = new JComboBox<>(fontStyles);
        style.add(setStyleLabel);
        style.add(cstyle);
        this.font.add(style);
        cstyle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFontStyle = (String) cstyle.getSelectedItem();       
                        Font newFont = new Font(selectedFontStyle, Font.PLAIN, exemple.getFont().getSize());
                exemple.setFont(newFont);
                exemple.revalidate();
            }
        });
         
           
           this.size = new JPanel();
           this.size.setLayout(new BoxLayout(this.size , BoxLayout.X_AXIS));
           this.font.add(size);
           JLabel lsize = new JLabel();
           lsize.setText("selectionnez le size                                       ");
           String[] fs = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
           JComboBox csize = new JComboBox(fs);
           this.size.add(lsize);
           this.size.add(csize);
        csize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Font newFont = new Font(lsize.getFont().getFontName(), Font.PLAIN, Integer.parseInt((String) csize.getSelectedItem()));
                exemple.setFont(newFont);
                exemple.revalidate();
            }
        });


               this.fontcolor = new JPanel();
               this.font.add(fontcolor);
               fontcolor.setLayout(new BoxLayout(fontcolor , BoxLayout.X_AXIS));
               JButton foregroundcolor = new JButton("choisir font color");
               fontcolor.add(foregroundcolor);
                foregroundcolor.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) {
                        Color selectedColor = JColorChooser.showDialog(null, "Choose Font Color", Color.BLACK);
                         if (selectedColor != null) {
                            exemple .setForeground(selectedColor);
                            exemple.revalidate();
                         }  
                   }
                 
               });
        
        this.testPan = new JPanel();
        this.font.add(testPan);
        this.testPan.setLayout(new BoxLayout(this.testPan, BoxLayout.X_AXIS));
        this.exemple = new JLabel();
        this.exemple.setText("this is example");
        this.testPan.add(this.exemple);
        


        
        
            this.setVisible(true);
            this.add(this.theme);
            this.add(this.font);
           
//            this.add(this.size);
//            this.add(this.fontcolor);
//            this.add(this.testPan);
            
            
            

            
            
            
      }
      
//      public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//          int width  = 500;
//          int high = 300;
//          JFrame frame = new JFrame();
//          frame.setResizable(false);
//          frame.setLocationRelativeTo(null);
//          frame.setSize(width,high);
//          FontPanel panel = new FontPanel(new Zone());
//         panel .setSize(width,high);
//           frame.add(panel,BorderLayout.CENTER);
//           frame.setVisible(true);
//           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//    }
}
