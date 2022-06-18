package Book;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPage extends JPanel {
    JTextField nameText=new JTextField();
    SmallBtn add=new SmallBtn("New",0);
    SmallBtn delete=new SmallBtn("Delete",1);
    SmallBtn edit=new SmallBtn("Edit",2);
    SmallBtn doneAdd=new SmallBtn("Done",0);
    SmallBtn doneEdit=new SmallBtn("Done",0);
    SmallBtn cancel=new SmallBtn("Cencel",1);

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

        doneAdd.setVisible(false);
        doneEdit.setVisible(false);
        cancel.setVisible(false);
        nameText.setVisible(false);


        add(Header);
        add(label1);
        add(label2);
        add(label3);
        add(foodList);
        add(ingredientsText);
        add(procedureText);
        add(add);
        add(delete);
        add(edit);
        add(doneAdd);
        add(doneEdit);
        add(cancel);
        add(nameText);

        foodList.setBounds(110,80,300,50);
        foodList.setFont(new Font("Serif", Font.BOLD, 20));
        foodList.setEditable(true);
        ingredientsText.setBounds(25,200,405,400);
        procedureText.setBounds(455,65,510,570);
        procedureText.setFont(new Font("Serif",Font.BOLD,20));
        ingredientsText.setFont(new Font("Serif",Font.BOLD,20));
        nameText.setBounds(110,80,300,50);
        procedureText.setEditable(false);
        ingredientsText.setEditable(false
        );



        add("Omelette","Egg, Oill","Just cook");
        add("Lentil","Onion,Lentil,Oil,Water","hfgkryeduf");

        foodList.addActionListener(e -> {
            int x=foodList.getSelectedIndex();
            if(x>-1){
                ingredientsText.setText(foodIngredients.get(x));
                procedureText.setText(foodProcedure.get(x));
            }
        });

        delete.addActionListener(e -> {
            int x=foodList.getSelectedIndex();
            if(x>-1){
                remove(x);
            }
        });

        add.addActionListener(e -> {

            foodList.setVisible(false);
            delete.setVisible(false);
            edit.setVisible(false);
            add.setVisible(false);

            nameText.setVisible(true);
            cancel.setVisible(true);
            doneAdd.setVisible(true);

            procedureText.setText("");
            ingredientsText.setText("");
            procedureText.setEditable(true);
            ingredientsText.setEditable(true);
        });

        doneAdd.addActionListener(e -> {
            add(nameText.getText(),ingredientsText.getText(),procedureText.getText());
            foodList.setVisible(true);
            delete.setVisible(true);
            edit.setVisible(true);
            add.setVisible(true);

            nameText.setVisible(false);
            cancel.setVisible(false);
            doneAdd.setVisible(false);

            procedureText.setText("");
            ingredientsText.setText("");
            procedureText.setEditable(false);
            ingredientsText.setEditable(false);

        });

        cancel.addActionListener(e -> {
            foodList.setVisible(true);
            delete.setVisible(true);
            edit.setVisible(true);
            add.setVisible(true);

            nameText.setVisible(false);
            cancel.setVisible(false);
            doneAdd.setVisible(false);
            doneEdit.setVisible(false);

            procedureText.setText("");
            ingredientsText.setText("");
            procedureText.setEditable(false);
            ingredientsText.setEditable(false);
        });

        edit.addActionListener(e -> {
            foodList.setVisible(false);
            delete.setVisible(false);
            edit.setVisible(false);
            add.setVisible(false);

            nameText.setVisible(true);
            cancel.setVisible(true);
            doneEdit.setVisible(true);

            procedureText.setEditable(true);
            ingredientsText.setEditable(true);
            nameText.setText(foodList.getItemAt(foodList.getSelectedIndex()));
        });
        doneEdit.addActionListener(e -> {
            foodName.add(nameText.getText());
            foodIngredients.add(ingredientsText.getText());
            foodProcedure.add(procedureText.getText());

            foodList.setVisible(true);
            delete.setVisible(true);
            edit.setVisible(true);
            add.setVisible(true);

            nameText.setVisible(false);
            cancel.setVisible(false);
            doneEdit.setVisible(false);

            procedureText.setText("");
            ingredientsText.setText("");
            procedureText.setEditable(false);
            ingredientsText.setEditable(false);

        });


    }
    public void update(){
        foodList.removeAllItems();
        for (int i = 0; i < foodName.size(); i++) {
            foodList.addItem(foodName.get(i));
        }
    }
    public void add(String name,String ing,String proc){
        foodName.add(name);
        foodIngredients.add(ing);
        foodProcedure.add(proc);
        update();
    }
    public void remove(int id){
        foodName.remove(id);
        foodIngredients.remove(id);
        foodProcedure.remove(id);
        procedureText.setText("");
        ingredientsText.setText("");
        update();
    }
}
