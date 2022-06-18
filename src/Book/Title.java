package Book;

import javax.swing.*;
import java.awt.*;

public class Title extends JLabel {
    public Title(){
        setFont(new Font("Blackadder ITC", Font.BOLD, 40));
        setForeground(Color.decode("#212121"));
        setBounds(175,75,300,60);
        setText("Recipe Book");
    }
}
