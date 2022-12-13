import java.awt.event.KeyEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {

    public static final int PIPE_DELAY = 100;

    private Boolean paused;

    private int pauseDelay;
    private int restartDelay;
    private int pipeDelay;
    public int highScore = 0;
    private Speed speed;
    private ArrayList<PipeMessi> pipeMessis;
    private Keyboard keyboard;

    public int score;
    public Boolean gameover;
    public Boolean started;

    public Game() {
        keyboard = Keyboard.getInstance();
        restart();
    }

    public void restart() {
        paused = false;
        started = false;
        gameover = false;

        score = 0;
        pauseDelay = 0;
        restartDelay = 0;
        pipeDelay = 0;

        speed = new Speed();
        pipeMessis = new ArrayList<PipeMessi>();
    }

    public void update() {
        watchForStart();
        if (!started)
            return;

        watchForPause();
        watchForReset();

        if (paused)
            return;

        speed.update();

        if (gameover)
            return;

        movePipes();
        checkForCollisions();
    }

    public ArrayList<Render> getRenders() {
        ArrayList<Render> renders = new ArrayList<Render>();
        renders.add(new Render(0, 0, "lib/background.png"));
        for (PipeMessi pipeMessi : pipeMessis)
            renders.add(pipeMessi.getRender());
        renders.add(new Render(0, 0, "lib/foreground.png"));
        renders.add(speed.getRender());
        return renders;
    }


    private void watchForStart() {
        if (!started && keyboard.isDown(KeyEvent.VK_SPACE)) {
            started = true;
        }
    }

    private void watchForPause() {
        if (pauseDelay > 0)
            pauseDelay--;

        if (keyboard.isDown(KeyEvent.VK_P) && pauseDelay <= 0) {
            paused = !paused;
            pauseDelay = 10;
        }
    }

    private void watchForReset() {
        if (restartDelay > 0)
            restartDelay--;

        if (keyboard.isDown(KeyEvent.VK_R) && restartDelay <= 0) {
            restart();
            restartDelay = 10;
            return;
        }
    }

    private void movePipes() {
        pipeDelay--;

        if (pipeDelay < 0) {
            pipeDelay = PIPE_DELAY;
            PipeMessi northPipeMessi = null;
            PipeMessi southPipeMessi = null;

            // Look for pipes off the screen
            for (PipeMessi pipeMessi : pipeMessis) {
                if (pipeMessi.x - pipeMessi.width < 0) {
                    if (northPipeMessi == null) {
                        northPipeMessi = pipeMessi;
                    } else if (southPipeMessi == null) {
                        southPipeMessi = pipeMessi;
                        break;
                    }
                }
            }

            if (northPipeMessi == null) {
                PipeMessi pipeMessi = new PipeMessi("north");
                pipeMessis.add(pipeMessi);
                northPipeMessi = pipeMessi;
            } else {
                northPipeMessi.reset();
            }

            if (southPipeMessi == null) {
                PipeMessi pipeMessi = new PipeMessi("south");
                pipeMessis.add(pipeMessi);
                southPipeMessi = pipeMessi;
            } else {
                southPipeMessi.reset();
            }

            northPipeMessi.y = southPipeMessi.y + southPipeMessi.height + 175;
        }

        for (PipeMessi pipeMessi : pipeMessis) {
            pipeMessi.update();
        }
    }

    private void checkForCollisions() {

        for (PipeMessi pipeMessi : pipeMessis) {
            if (pipeMessi.collides(speed.x, speed.y, speed.width, speed.height)) {
                gameover = true;
                speed.dead = true;
            } else if (pipeMessi.x == speed.x && pipeMessi.orientation.equalsIgnoreCase("south")) {
                score++;
            }
        }

        // Ground + Bird collision
        if (speed.y + speed.height > App.HEIGHT - 80) {
            gameover = true;
            speed.y = App.HEIGHT - 80 - speed.height;
        }
    }

}
