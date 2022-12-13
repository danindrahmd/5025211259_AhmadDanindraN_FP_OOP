import java.awt.*;

public interface finalvariable {

    static int plusMethodInt(int x, int y) {
        return x + y;
    }
    static int plusMethodInt(int x, int y, int z) {
        return x + y + z;
    }

    int myNum1 = plusMethodInt(35,10);
    int myNum2 = plusMethodInt(10,10,12);

    static int width = myNum1;
    static int height = myNum2;
}