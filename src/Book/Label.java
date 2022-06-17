package Book;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String text,int x ,int y){
        setBounds(x,y,200,100);
        setText(text);
        setFont(new Font("Serif", Font.BOLD, 20));

    }
}
