package com.game.src.main;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by Agil on 1/04/15.
 */
public class Player extends GameObject implements EntityA {



    private double velX = 0;
    private double velY = 0;

    private BufferedImage player;

    private Textures tex;
    Controller controller;
    Game game;

    public Player(double x, double y, Textures tex, Game game, Controller controller){
        super(x,y);
        this.tex = tex;
        this.game = game;
        this.controller = controller;





    }




    public void tick(){
        x+=velX;
        y+=velY;

        if(x <= 0)
            x = 0;
        if(x >= 640 -30)
            x = 640 -30;
        if(y <= 0)
            y = 0;
        if(y >= 480 - 40)
            y= 480 - 40;

        for(int i = 0; i < game.eb.size(); i++)
        {
            EntityB tempEnt = game.eb.get(i);

            if(Physics.Collision(this , tempEnt))
            {
                controller.removeEntity(tempEnt);
                game.HEALTH -= 10;
                game.setEnemy_killed(game.getEnemy_killed() + 1);
            }
        }







    }
    public void render(Graphics g){
        g.drawImage(tex.player, (int)x, (int)y, null);




        }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    public double getX(){
        return x;

    }
    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;

    }

    public void setY(double y){
        this.y = y;
    }

    public void setVelX(double velX){
        this.velX = velX;
    }

    public void setVelY(double velY){
        this.velY = velY;
    }



}
