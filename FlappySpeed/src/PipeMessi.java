import java.awt.Image;

public class PipeMessi {

    public int x;
    public int y;
    public int width;
    public int height;

    public String orientation;

    private Image image;

    public PipeMessi(String orientation) {
        this.orientation = orientation;
        reset();
    }

    public void reset() {
        width = 100;
        height = 380;

        if (orientation.equals("south")) {
            y = -(int)(Math.random() * 120) - height / 2;
        }
    }


    public Render getRender() {
        Render r = new Render();
        r.x = x;
        r.y = y;

        if (image == null) {
            image = Util.loadImage("lib/pipe-" + orientation + ".png");
        }
        r.image = image;

        return r;
    }
}
