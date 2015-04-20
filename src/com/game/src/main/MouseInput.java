package com.game.src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Agil on 18/04/15.
 */

public class MouseInput implements MouseListener {


    public void mouseClicked(MouseEvent e) {


    }

    private Game game;




    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        /**
         public Rectangle playButton = new Rectangle(Game.WIDTH /2 +120, 150, 100, 50);
         public Rectangle helpButton = new Rectangle(Game.WIDTH /2 +120, 210, 100, 50);
         public Rectangle quitButton = new Rectangle(Game.WIDTH /2 +120, 330, 100, 50);
         public Rectangle OptionsButton = new Rectangle(Game.WIDTH /2 +120, 270, 100, 50);
         public static Rectangle musicButton = new Rectangle(Game.WIDTH/ 2 + 12, 300, 100, 50);
         */

        if(Game.State == Game.STATE.MENU) {
            //Play Button
            if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
                if (my >= 150 && my <= 200) {
                    //Presed Play button
                    Game.State = Game.STATE.GAME;

                }
            }


            //Quit Button
            if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
                if (my >= 330 && my <= 380) {
                    //Presed Quit button
                    System.exit(1);
                }
            }


            //Help Button
            if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
                if (my >= 210 && my <= 260) {
                    //Presed Help button
                    Game.State = Game.STATE.HELP;
                }
            }
            if (Game.State == Game.STATE.MENU) {
                if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
                    if (my >= 270 && my <= 310) {

                        Game.State = Game.STATE.OPTIONS;
                    }
                }
                if(Game.State == Game.STATE.OPTIONS) {
                    if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
                        if (my >= 400 && my <= 450) {

                            Game.State = Game.STATE.MENU;

                        }
                    }
                }
        }

        //Back Button
        if(Game.State == Game.STATE.HELP) {
            if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
                if (my >= 400 && my <= 450) {

                    Game.State = Game.STATE.MENU;

                }
            }
        }
        if(Game.State == Game.STATE.END) {
            if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
                if (my >= 250 && my <= 300) {

                    Game.State = Game.STATE.MENU;
                }
            }


            }
        }

        //Back Button

            if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
                if (my >= 400 && my <= 450) {

                    Game.State = Game.STATE.MENU;

                }
            }

        /*if(Game.State == Game.STATE.OPTIONS){
            if (mx >= Game.WIDTH / 2 + 120 && mx <= Game.WIDTH / 2 + 220) {
                if (my >= 400 && my <= 450) {

                    if(game.getmusic() >= 0) {
                        game.setmusic(1);
                    }else
                        if(game.getmusic() >= 0 ){
                            game.setmusic(0);
                        }


                }

                }

        }
        */





    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
