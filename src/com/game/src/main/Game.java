package com.game.src.main;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.render.*;
import javazoom.jl.decoder.JavaLayerException;

import javax.sound.sampled.Mixer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.LinkedList;

/*
 * Created by Agil on 11/03/15.
 */

public class Game extends Canvas implements Runnable {


    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public final String TITLE = "Little red riding-hood";
    public final String AUTHOR = "Samuel Newcombe";



    private boolean running = false;
    private Thread thread;
    public static Mixer mixer;


    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage background = null;




    private boolean is_shooting = false;


    private int enemy_count = 1;
    private int enemy_killed = 0;
    private int Score = 0;
    private int Ammo = 10;
    private int death = 0;
    private static int music = 1;
    public static int HEALTH = 100 * 2;



    private Sound sound;



    private Player p;
    private Controller c;
    private Textures tex;
    private com.game.src.render.Menu menu;
    private com.game.src.render.help help;
    private com.game.src.render.end end;
    private LevelC LevelC;
    private Graphics g;
    private Options options;





    public LinkedList<EntityA> ea;
    public LinkedList<EntityB> eb;




    public int Score() {
        return 0;
    }



    public static enum STATE{
        MENU,
        GAME,
        HELP,
        END,
        LEVELC,
        OPTIONS
    };



    public static STATE State = STATE.MENU;
    public static STATE hState = STATE.HELP;
    public static STATE eState = STATE.END;
    public static STATE lState = STATE.LEVELC;
    public static STATE oState = STATE.OPTIONS;



    public void init(){

        requestFocus();
        BufferedImageLoader loader = new BufferedImageLoader();
        try{

            spriteSheet = loader.loadImage("/Sprite_sheet.png");

            background = loader.loadImage("/background.png");

        }catch(IOException e){
            e.printStackTrace();
        }

        this.addKeyListener(new KeyInput(this));
        this.addMouseListener(new MouseInput());

        tex = new Textures(this);

        c = new Controller(tex, this, g);
        p = new Player(200, 200, tex, this, c);
        menu = new com.game.src.render.Menu();
        help = new help();
        end = new end();
        LevelC = new LevelC();
        options = new Options();


        c.createEnemy(enemy_count);

        ea = c.getEntityA();
        eb = c.getEntityB();


    }


    private synchronized void start() {
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();

    }

    private synchronized void stop() {
        if(!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);

    }

    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();


        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " Ticks, Fps" + frames);
                System.out.println("Author " + AUTHOR );
                updates = 0;
                frames = 0;

            }
            {
            }
        }
        stop();
    }


    private void tick(){

        if(State == STATE.GAME) {
            p.tick();
            c.tick();


            if(HEALTH < 0 ) {
                setdeath(0);
                State = STATE.END;


            }
        }
        if(enemy_killed >= enemy_count)
        {
            enemy_count += 2;
            enemy_killed = 0;
            c.createEnemy(enemy_count);
        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null){
            createBufferStrategy(3);
            return;
        }


        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.fillRect(0, 0, 800, 800);

        if(State == STATE.GAME) {



            g.drawImage(background, 0, 0, null);
            p.render(g);
            c.render(g);





            Font Fnt0 = new Font("arial", Font.BOLD, 20);
            g.setFont(Fnt0);
            g.setColor(Color.BLUE);
            g.drawString("Score"+ Score, 470, 30);
            g.drawString("Bread "+ Ammo, 10, 450 );

            if (getAmmo() <= 0){
                State = STATE.END;
                setAmmo(10);



            }
            if(getScore() >= 50){
                State = STATE.LEVELC;
            }


            g.setColor(Color.gray);
            g.fillRect(5, 5, 200, 50);

            g.setColor(Color.green);
            g.fillRect(5, 5, HEALTH, 50);

            g.setColor(Color.white);
            g.drawRect(5, 5, 200, 50);

        }else if(State == STATE.MENU){

            menu.render(g);


        }else if(State == STATE.HELP){
        help.render(g);
        g.setColor(Color.BLACK);

        }else if(State == STATE.END){
            end.render(g, this);
            g.setColor(Color.BLACK);



        }else if (State == STATE.LEVELC){
            LevelC.render(g, this);
        }else if (State == STATE.OPTIONS){
            Options.render(g);
        }



        g.dispose();
        bs.show();




    }

    public void keyPressed(KeyEvent e) {
        int key = e.getExtendedKeyCode();
        if(State == STATE.GAME) {

            if (key == KeyEvent.VK_D) {
                p.setVelX(5);

            } else if (key == KeyEvent.VK_A) {
                p.setVelX(-5);

            } else if (key == KeyEvent.VK_S) {
                p.setVelY(5);

            } else if (key == KeyEvent.VK_W) {
                p.setVelY(-5);

            } else if (key == KeyEvent.VK_SPACE && getAmmo() >= 1 && !is_shooting) {
                is_shooting = true;
                c.addEntity(new Bullet(p.getX(), p.getY(), tex, this));
                setAmmo(getAmmo() -1);

            }else if (key == KeyEvent.VK_ESCAPE ){
                State = STATE.END;

            }

            if (key == KeyEvent.VK_RIGHT) {
                p.setVelX(5);

            } else if (key == KeyEvent.VK_LEFT) {
                p.setVelX(-5);

            } else if (key == KeyEvent.VK_DOWN) {
                p.setVelY(5);

            } else if (key == KeyEvent.VK_UP) {
                p.setVelY(-5);

            }
        }
    }





    public void keyReleased(KeyEvent e) {

        int key = e.getExtendedKeyCode();

        if (key == KeyEvent.VK_D) {
            p.setVelX(0);

        } else if (key == KeyEvent.VK_A) {
            p.setVelX(0);

        } else if (key == KeyEvent.VK_S) {
            p.setVelY(0);

        } else if (key == KeyEvent.VK_W) {
            p.setVelY(0);

        }

        if (key == KeyEvent.VK_RIGHT) {
            p.setVelX(0);

        } else if (key == KeyEvent.VK_LEFT) {
            p.setVelX(0);

        } else if (key == KeyEvent.VK_DOWN) {
            p.setVelY(0);

        } else if (key == KeyEvent.VK_UP) {
            p.setVelY(0);

        }else if (key == KeyEvent.VK_SPACE){
            is_shooting = false;
        }

    }

    public static void main(String args[]) throws FileNotFoundException {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));


        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();

        if (getmusic() >= 1) {
            File file;
            file = new File("/Users/Agil/IdeaProjects/Games/res/Adventure.wav");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            try {

                javazoom.jl.player.Player player = new javazoom.jl.player.Player(bis);
                player.play();

            } catch (JavaLayerException ex) {
            }


        }
    }


    public BufferedImage getSpriteSheet(){
        return spriteSheet;
    }

    public int getEnemy_count(){
        return enemy_count;
    }

    public void setEnemy_count(int enemy_count){
        this.enemy_count = enemy_count;
    }

    public int getEnemy_killed(){
        return enemy_killed;
    }

    public void setEnemy_killed(int enemy_killed){
        this.enemy_killed = enemy_killed;
    }

    public int getScore(){
        return Score;
    }

    public void setScore(int Score){
        this.Score = Score;
    }

    public int getAmmo(){
        return Ammo;
    }

    public void setAmmo(int Ammo){
        this.Ammo = Ammo;
    }

    public int getHealth(){
        return HEALTH;
    }

    public void setHealth(int HEALTH){
        this.HEALTH = HEALTH;
    }

    public int getdeath(){
        return death;
    }

    public void setdeath(int death){
        this.death = death;
    }

    public static int getmusic(){
        return music;
    }

    public void setmusic(int music){
        this.music = music;
    }




}
