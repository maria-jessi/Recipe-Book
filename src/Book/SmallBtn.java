package Book;

import javax.swing.*;
import java.awt.*;

public class SmallBtn extends JButton {
    public SmallBtn(String s, int x){
        setBounds(x*130+75,580,120,40);
        setText(s);
        setBackground(Color.WHITE);
        setBorderPainted(false);
        setFocusPainted(false);
        setFont(new Font("Serif", Font.BOLD, 20));
        setOpaque(false);
    }
}