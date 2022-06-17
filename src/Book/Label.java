package Book;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String text,int x ,int y){
        setBounds(x,y,150,50);
        setText(text);
        setFont(new Font("Serif", Font.BOLD, 23));

    }
}
