package Book;

import javax.swing.*;

public class MainPage extends JPanel {
    Title Header=new Title();
    Label label1=new Label("Name",30,80);
    public MainPage(){
        setLayout(null);
        setBounds(0,0,1000,700);
        add(Header);
        add(label1);

    }
}
