package com.game.src.main.classes;

import java.awt.*;

/**
 * Created by Agil on 17/04/15.
 */
public interface EntityB {

    public void tick();
    public void render(Graphics g);
    public Rectangle getBounds();



    public double getX();
    public double getY();



}
