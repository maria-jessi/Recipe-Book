package Book;

import javax.swing.*;

public class MainPage extends JPanel {
    Title Header=new Title();
    public MainPage(){
        setLayout(null);
        setBounds(0,0,1000,700);
        add(Header);
    }
}