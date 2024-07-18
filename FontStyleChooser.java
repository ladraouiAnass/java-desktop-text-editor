
//package notepad;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class FontStyleChooser extends JFrame {

    private JTextField textField;
    private JComboBox<String> fontStyleComboBox;

    // Mapping font style names to Font style constants
    private Map<String, Integer> fontStyleMap;

    public FontStyleChooser() {
        setTitle("Font Style Chooser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField("Text");

        // Create the font style map
        fontStyleMap = new HashMap<>();
        fontStyleMap.put("Plain", Font.PLAIN);
        fontStyleMap.put("Bold", Font.BOLD);
        fontStyleMap.put("Italic", Font.ITALIC);

        String[] fontStyles = {"Plain", "Bold", "Italic"};
        fontStyleComboBox = new JComboBox<>(fontStyles);

        fontStyleComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFontStyle = (String) fontStyleComboBox.getSelectedItem();

                // Set the font style based on the selection from the combo box
                int selectedStyle = fontStyleMap.get(selectedFontStyle);
                Font currentFont = textField.getFont();
                Font newFont = new Font(currentFont.getFontName(), selectedStyle, currentFont.getSize());

                textField.setFont(newFont);
            }
        });

        add(textField);
        add(fontStyleComboBox);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FontStyleChooser();
        });
    }
}
