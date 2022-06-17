package Book;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPage extends JPanel {
    Title Header=new Title();
    Label label1=new Label("Name",30,80);
    ArrayList<String> foodName = new ArrayList<>();
    JComboBox<String> foodList = new JComboBox<>();

    public MainPage(){
        setLayout(null);
        setBounds(0,0,1000,700);

        add(Header);
        add(label1);
        add(foodList);

        foodList.setBounds(150,100,200,50);
        foodList.setFont(new Font("Serif", Font.BOLD, 20));
    }
}
