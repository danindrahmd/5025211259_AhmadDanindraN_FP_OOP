AHMAD DANINDRA NUGROHO
5025211259

Casting/Conversion: The watchForPause method converts the KeyEvent.VK_P constant to an int value when checking if the P key is pressed.

Constructor : The Keyboard class includes a constructor, which is a special method that is called when an object of the class is created. The constructor initializes the keys array. (Keyboard.java)

Overloading public Render() {
}

public Render(int x, int y, String imagePath) {
    Toolkit.getDefaultToolkit().sync();
    this.x = x;
    this.y = y;
    this.image = Util.loadImage(imagePath);
} (Render.java)

Overriding

Encapsulation: The Game class has private fields such as paused and keyboard, and public methods such as update and getRenders.(Game.java)
               The App class has private static fields such as WIDTH and HEIGHT, and a public static method called main. (App.java)
               The Util class has private static fields such as cache and a public static method called loadImage. (Util,java)

Inheritance: The PipeMessi class extends the Pipe class and inherits its methods and fields.(Game.java)
             The GamePanel class extends the JPanel class from the Swing library and inherits its methods and fields.(App.java)
             The GamePanel class extends the JPanel class from the Swing library and inherits its methods and fields. (GamePanel.java)

Polymorphism: The getRenders method returns an ArrayList of Render objects, which can be any class that extends the Render class.(Game.java)
              The main method adds the Keyboard object as a key listener to the JFrame, and the Keyboard class implements the KeyListener interface.                     (App.Java)
              The GamePanel class implements the Runnable interface and provides an implementation for the run method. (GamePanel.java)

ArrayList : The Game class uses an ArrayList to store a list of PipeMessi objects. An ArrayList is a data structure that can store a variable-sized list of             objects. It allows objects to be added, removed, and accessed using an index. (Game.java)

Exception Handling: The run method uses an exception handling block to handle any exceptions that are thrown while the GamePanel is running.
                    GUI. (GamePanel.java)
                    The loadImage method uses a try-catch block to handle any IOException that is thrown while loading the image from the file system.                         (Util.java)

Interface

Abstract Class

Generics: The ArrayList objects in the code, such as pipeMessis, use generics to specify the type of object they can hold. For example, the pipeMessis   n           ArrayList is declared as ArrayList<PipeMessi> and can only hold PipeMessi objects.(Game.java)
          The addKeyListener method takes an argument of type KeyListener, which is a generic interface. (App.java)
          The ArrayList object returned by the game object's getRenders method uses generics to specify the type of object it can hold.(GamePanel.java)
          he cache field is a HashMap object that uses generics to specify the types of the keys and values it can hold.(Util.java)
  
Collection: The cache field is a HashMap object that can store and retrieve multiple values. (Util.java)
  
Input/Output: The loadImage method uses the ImageIO class to read an image from the file system. (Util.java)
