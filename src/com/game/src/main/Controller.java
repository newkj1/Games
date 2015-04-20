package com.game.src.main;

import com.game.src.main.classes.*;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Agil on 11/04/15.
 */
public class Controller {

    private LinkedList<EntityA> ea = new LinkedList<EntityA>();
    private LinkedList<EntityB> eb = new LinkedList<EntityB>();


    EntityA enta;
    EntityB entb;
    private Textures tex;
    Random r = new Random();
    private Game game;
    private Graphics g;

    public Controller(Textures tex, Game game, Graphics g){
        this.tex = tex;
        this.game = game;
        this.g = g;
        



    }

    public void createEnemy(int enemy_count){

        for(int i = 0; i < enemy_count; i++){

            addEntity(new Enemy(640, r.nextInt(240), tex, this, game, g));
        }

    }





    public void tick() {
        //A class
        for(int i = 0; i < ea.size(); i++){
            enta = ea.get(i);

            enta.tick();
        }
        //B class
        for(int i = 0; i < eb.size(); i++){
            entb = eb.get(i);

            entb.tick();
        }

    }

    public void render(Graphics g) {
        //A class
        for(int i = 0; i < ea.size(); i++){
            enta = ea.get(i);

            enta.render(g);
        }
        //B class
        for(int i = 0; i < eb.size(); i++){
            entb = eb.get(i);

            entb.render(g);
        }

    }
    public void addEntity(EntityA block){
        ea.add(block);
    }

    public void removeEntity(EntityA block) {
        ea.remove(block);
    }

    public void addEntity(EntityB block){
        eb.add(block);
    }

    public void removeEntity(EntityB block) {
        eb.remove(block);
    }

    public LinkedList<EntityA> getEntityA(){
        return ea;
    }

    public LinkedList<EntityB> getEntityB(){
        return eb;
    }
}
