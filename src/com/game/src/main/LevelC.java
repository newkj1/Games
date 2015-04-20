package com.game.src.main;

import java.awt.*;

/**
 * Created by Agil on 18/04/15.
 */
public class LevelC {

    public Rectangle nextButton = new Rectangle(Game.WIDTH /2 +120, 250, 100, 50);
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


        g2d.draw(nextButton);
        g.drawString("Next", nextButton.x + 19, nextButton.y+ 30 );



    }
}
