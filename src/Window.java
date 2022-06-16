import Book.MainPage;

import javax.swing.*;

public class Window extends JFrame {
    MainPage HomePage=new MainPage();

    public Window(){
        setSize(1000,700);
        setContentPane(HomePage);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
