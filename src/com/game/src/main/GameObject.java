package com.game.src.main;

import java.awt.*;

/**
 * Created by Agil on 18/04/15.
 */
public class GameObject {

    public double x, y;

    public GameObject(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds(int Width, int Height) {
        return new Rectangle((int)x, (int)y, Width, Height);
    }

}
