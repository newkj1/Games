package com.game.src.render;

import com.game.src.main.Game;

import java.awt.*;

/**
 * Created by Agil on 18/04/15.
 */
public class end {

    public Rectangle restartButton = new Rectangle(Game.WIDTH /2 +120, 250, 100, 50);
     Game game;

    public void render(Graphics g, Game game){
        this.game = game;
        Graphics2D g2d = (Graphics2D) g;

        Font Fnt0 = new Font("arial", Font.BOLD, 30);
        g.setFont(Fnt0);
        g.setColor(Color.magenta);
        g.drawString("Game Over", 260, 100);

        Font Fnt1 = new Font("arial", Font.BOLD, 20);
        g.setFont(Fnt1);


        g2d.draw(restartButton);
        g.drawString("Menu", restartButton.x + 19, restartButton.y+ 30 );



    }
}
