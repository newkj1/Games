package com.game.src.main;

import java.awt.image.BufferedImage;

/**
 * Created by Agil on 17/04/15.
 */
public class Textures {

    public BufferedImage player, Bullet, Enemy;

    private SpriteSheet ss;

    public Textures(Game game){
        ss = new SpriteSheet(game.getSpriteSheet());

        getTextures();
            }
    private void getTextures () {
        player = ss.grabImage(1, 1, 32, 32);
        Bullet = ss.grabImage(3, 1, 32, 32);
        Enemy = ss.grabImage(2, 1, 32, 32);


    }
}
