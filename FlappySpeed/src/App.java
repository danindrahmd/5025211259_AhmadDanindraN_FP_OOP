/*
1. Casting/Conversion -> pipemessi
2. Constructor -> All class
3. Overloading -> finalvariable
4. Overriding -> Ingfo
5. Encapsulation ->
6. Inheritance -> Ingfo
7. Polymorphism -> finalvariable
8. ArrayList -> game.java
9. Exception Handling -> game exception
10. GUI -> app
11. Interface -> finalvariable
12. Abstract Class -> iniAbstract
13. Generics -> name
14. Collection -> hash map
15. Input Output -> util
 */
import javax.swing.*;

public class App {

    public static int WIDTH = 500;
    public static int HEIGHT = 520;

    public static void main(String[] args) {

        Ingfo ingfo = new Ingfo();
        ingfo.iniBuatNama();
        ingfo.iniBuatNRP();
        Name<String> welcome = new Name<>("Instructions : Space to Jump");
        System.out.println(welcome.getNama());
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Keyboard keyboard = Keyboard.getInstance();
        frame.addKeyListener(keyboard);

        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
    }
}
