package Book;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPage extends JPanel {
    Title Header=new Title();
    Label label1=new Label("Name",30,80);
    ArrayList<String> foodName = new ArrayList<>();
    Label label2=new Label("Ingredients",30,150);
    ArrayList<String> foodIngredients = new ArrayList<>();
    Label label3=new Label("Procedure",460,10);
    ArrayList<String> foodProcedure = new ArrayList<>();
    JComboBox<String> foodList = new JComboBox<>();
    JTextArea ingredientsText=new JTextArea();
    JTextArea procedureText=new JTextArea();



    public MainPage(){
        setLayout(null);
        setBounds(0,0,1000,700);


        add(Header);
        add(label1);
        add(label2);
        add(label3);
        add(foodList);
        add(ingredientsText);
        add(procedureText);

        foodList.setBounds(110,80,300,50);
        foodList.setFont(new Font("Serif", Font.BOLD, 20));
        ingredientsText.setBounds(25,200,405,400);
        procedureText.setBounds(455,65,510,570);


        foodName.add("rice");
        foodName.add("tomato curry");
        foodName.add(1,"omelette");

        for (int i = 0; i < foodName.size(); i++) {
            foodList.addItem(foodName.get(i));

        }
    }
}
