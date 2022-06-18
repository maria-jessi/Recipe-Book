package Book;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPage extends JPanel {
    SmallBtn add=new SmallBtn("New",0);
    SmallBtn delete=new SmallBtn("Delete",1);
    SmallBtn edit=new SmallBtn("Edit",2);
    SmallBtn doneAdd=new SmallBtn("Done",0);
    SmallBtn doneEdit=new SmallBtn("Done",0);
    SmallBtn cancel=new SmallBtn("Cancel",1);

    Title Header=new Title();
    Label label1=new Label("Name",30,80);
    Label label2=new Label("Ingredients",170,150);
    Label label3=new Label("Procedure",700,50);

    ArrayList<String> foodName = new ArrayList<>();
    ArrayList<String> foodIngredients = new ArrayList<>();
    ArrayList<String> foodProcedure = new ArrayList<>();
    JComboBox<String> foodList = new JComboBox<>();
    JTextArea ingredientsText=new JTextArea();
    JTextArea procedureText=new JTextArea();
    JTextField nameText=new JTextField();

    JTextArea line = new JTextArea();

    public MainPage(){
        setLayout(null);
        setBounds(0,0,1000,700);
        setBackground(Color.WHITE);

        doneAdd.setVisible(false);
        doneEdit.setVisible(false);
        cancel.setVisible(false);
        nameText.setVisible(false);

        foodList.setBounds(105,80,320,50);
        ingredientsText.setBounds(25,200,450,400);
        procedureText.setBounds(515,100,460,500);
        nameText.setBounds(110,80,300,50);

        nameText.setFont(new Font("Serif", Font.BOLD, 20));
        procedureText.setFont(new Font("Serif",Font.BOLD,18));
        ingredientsText.setFont(new Font("Serif",Font.BOLD,18));
        foodList.setFont(new Font("Serif", Font.BOLD, 20));

        procedureText.setEditable(false);
        ingredientsText.setEditable(false);
        foodList.setEditable(true);

        line.setBounds(485,30,1,600);
        line.setBackground(Color.BLACK);
        line.setText("");
        line.setEditable(false);

        add(line);
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

        add("Omelette","Egg, Oill","Just cook");
        add("Lentil","Onion,Lentil,Oil,Water","hfgkryeduf");
        view();

        foodList.addActionListener(e -> view());

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

            nameText.setText("");
            procedureText.setText("");
            ingredientsText.setText("");
            procedureText.setEditable(true);
            ingredientsText.setEditable(true);

            line.setVisible(false);
            procedureText.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            ingredientsText.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
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

            procedureText.setEditable(false);
            ingredientsText.setEditable(false);

            foodList.setSelectedIndex(foodName.size()-1);

            line.setVisible(true);
            procedureText.setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
            ingredientsText.setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
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

            procedureText.setEditable(false);
            ingredientsText.setEditable(false);

            line.setVisible(true);
            procedureText.setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
            ingredientsText.setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
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

            line.setVisible(false);
            procedureText.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            ingredientsText.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        });


        doneEdit.addActionListener(e -> {
            int x = foodList.getSelectedIndex();
            foodName.set(x,nameText.getText());
            foodIngredients.set(x,ingredientsText.getText());
            foodProcedure.set(x,procedureText.getText());

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

            update();
            foodList.setSelectedIndex(x);

            line.setVisible(true);
            procedureText.setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
            ingredientsText.setBorder(BorderFactory.createLineBorder(Color.WHITE,0));

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
    public void view(){
        int x=foodList.getSelectedIndex();
        if(x>-1){
            ingredientsText.setText(foodIngredients.get(x));
            procedureText.setText(foodProcedure.get(x));
        }
    }
}
