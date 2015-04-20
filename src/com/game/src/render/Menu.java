package com.game.src.render;

import com.game.src.main.Game;

import java.awt.*;

/**
 * Created by Agil on 18/04/15.
 */
public class Menu {

    public Rectangle playButton = new Rectangle(Game.WIDTH /2 +120, 150, 100, 50);
    public Rectangle helpButton = new Rectangle(Game.WIDTH /2 +120, 210, 100, 50);
    public Rectangle quitButton = new Rectangle(Game.WIDTH /2 +120, 330, 100, 50);
    //public Rectangle OptionsButton = new Rectangle(Game.WIDTH /2 +120, 270, 100, 50);



    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        Font Fnt0 = new Font("arial", Font.BOLD, 30);
        g.setFont(Fnt0);
        g.setColor(Color.BLUE);
        g.drawString("Little Red Riding hood", Game.WIDTH / 4, 100);

        Font Fnt1 = new Font("arial", Font.BOLD, 20);
        g.setFont(Fnt1);


        g2d.draw(playButton);
        g.drawString("Play", playButton.x + 19, playButton.y+ 30 );
        g2d.draw(helpButton);
        g.drawString("help", helpButton.x + 19, helpButton.y+ 30 );
        g2d.draw(quitButton);
        g.drawString("quit", quitButton.x + 19, quitButton.y+ 30 );

        /*g2d.draw(OptionsButton);
        g.drawString("Options", OptionsButton.x + 19, OptionsButton.y+ 30 );
        */
    }
}
