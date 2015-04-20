package com.game.src.main;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

import java.awt.*;
import java.util.Random;

/**
 * Created by Agil on 17/04/15.
 */
public class Enemy extends GameObject implements EntityB {

    private Textures tex;
    Random r = new Random();
    private Game game;
    private Controller c;
    private int GAmmo = r.nextInt(10);
    private Graphics g;

    private int speed = r.nextInt(3) + 1;

    public Enemy(double x, double y, Textures tex, Controller c, Game game, Graphics g){
        super(x,y);
        this.tex = tex;
        this.c = c;
        this.game = game;
        this.g = g;


    }


    public void tick() {

        x -= speed;

        if (y > (Game.HEIGHT * Game.SCALE)) {
            y = 0;
            x = r.nextInt(Game.WIDTH * Game.SCALE);


        }

        for (int i = 0; i < game.ea.size(); i++) {
            EntityA tempEnt = game.ea.get(i);

            if (Physics.Collision(this, tempEnt))
            {
                game.setScore(game.getScore()+ 1);
                c.removeEntity(tempEnt);
                c.removeEntity(this);
                game.setEnemy_killed(game.getEnemy_killed() + 1);
                int GAmmo = r.nextInt(10);

                if(game.getdeath() <= 1 ){


                }



                if(GAmmo <= 5) {

                    game.setAmmo(game.getAmmo() + 2);


                }
                System.out.println(GAmmo);



            }



        }


        }



    public void render( Graphics g){
        g.drawImage(tex.Enemy, (int)x, (int)y, null);



    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    public double getX(){
        return y;
    }


    public double getY() {
        return 0;
    }

    public void setY(double y){
        this.y = y;
    }

}
