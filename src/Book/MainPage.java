package Book;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainPage extends JPanel {
    SmallBtn add=new SmallBtn("New",0);
    SmallBtn delete=new SmallBtn("Delete",1);
    SmallBtn edit=new SmallBtn("Edit",2);
    SmallBtn doneAdd=new SmallBtn("Done",0);
    SmallBtn doneEdit=new SmallBtn("Done",0);
    SmallBtn cancel=new SmallBtn("Cancel",1);

    Title Header=new Title();
    Label label1=new Label("Name",100,150);
    Label label2=new Label("Ingredients",200,210);
    Label label3=new Label("Procedure",675,75);

    ArrayList<String> foodName = new ArrayList<>();
    ArrayList<String> foodIngredients = new ArrayList<>();
    ArrayList<String> foodProcedure = new ArrayList<>();
    JComboBox<String> foodList = new JComboBox<>();
    JTextArea ingredientsText=new JTextArea();
    JTextArea procedureText=new JTextArea();
    JTextField nameText=new JTextField();
    JLabel background = new JLabel();

    public MainPage(){
        setLayout(null);
        setBounds(0,0,1000,700);
        setBackground(Color.WHITE);
        try {
            Image img = ImageIO.read(getClass().getResource("bg.png"));
            background.setIcon(new ImageIcon(img));
        } catch (IOException ex) { throw new RuntimeException(ex);}

        doneAdd.setVisible(false);
        doneEdit.setVisible(false);
        cancel.setVisible(false);
        nameText.setVisible(false);
        nameText.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        foodList.setBounds(180,160,250,35);
        ingredientsText.setBounds(100,270,350,300);
        procedureText.setBounds(555,150,370,450);
        nameText.setBounds(180,160,250,35);

        nameText.setFont(new Font("Serif", Font.BOLD, 20));
        procedureText.setFont(new Font("Serif",Font.BOLD,18));
        ingredientsText.setFont(new Font("Serif",Font.BOLD,18));
        foodList.setFont(new Font("Serif", Font.BOLD, 20));

        procedureText.setEditable(false);
        ingredientsText.setEditable(false);
        foodList.setEditable(true);

        procedureText.setOpaque(false);
        ingredientsText.setOpaque(false);
        foodList.setOpaque(false);
        nameText.setOpaque(false);
        background.setBounds(0,0,1000,700);

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
        add(background);

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
