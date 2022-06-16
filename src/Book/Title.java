package Book;

import javax.swing.*;
import java.awt.*;

public class Title extends JLabel {
    public Title(){
        setFont(new Font("Serif", Font.BOLD, 24));
        setForeground(Color.ORANGE);
        setBounds(20,0,200,50);
        setText("Recipe Book");
    }
}
