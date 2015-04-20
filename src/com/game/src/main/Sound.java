package com.game.src.main;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 * Created by Agil on 20/04/15.
 */
public class Sound {

    public static final Sound sound = new Sound("/Adventure.wav");

    private AudioClip clip;

    public Sound(String filename){
        try{
            clip = Applet.newAudioClip(Sound.class.getResource(filename));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void play(){
        try{
            new Thread(){
                public void run(){
                    clip.play();
                }

            }.start();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
