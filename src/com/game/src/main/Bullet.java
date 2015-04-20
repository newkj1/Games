package com.game.src.main;

import com.game.src.main.classes.EntityA;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Agil on 11/04/15.
 */
public class Bullet extends GameObject implements EntityA {



    private Textures tex;
    private Game game;

    BufferedImage image;

    public Bullet(double x, double y, Textures tex, Game game){
        super(x,y);
        this.tex = tex;
        this.game = game;

    }

    public void tick(){
        x += 10;


    }

    public void render(Graphics g){
        g.drawImage(tex.Bullet, (int) x, (int) y, null);
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }


    public double getX() {
        return 0;
    }

    public double getY(){
        return y;
    }


}
