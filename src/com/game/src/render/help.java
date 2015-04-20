package com.game.src.render;

import com.game.src.main.Game;

import java.awt.*;

/**
 * Created by Agil on 18/04/15.
 */
public class help {


    public Rectangle backButton = new Rectangle(Game.WIDTH /2 +120, 400, 100, 50);




    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        Font Fnt0 = new Font("arial", Font.BOLD, 30);
        g.setFont(Fnt0);
        g.setColor(Color.BLUE);
        g.drawString("Help", 260, 100);
        g.drawString("Use either the Arrow keys or the WASD", 10, 200);

        Font Fnt1 = new Font("arial", Font.BOLD, 20);
        g.setFont(Fnt1);


        g2d.draw(backButton);
        g.drawString("Back", backButton.x + 19, backButton.y+ 30 );


    }
}
