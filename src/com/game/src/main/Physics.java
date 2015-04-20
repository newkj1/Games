package com.game.src.main;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

import java.util.LinkedList;

/**
 * Created by Agil on 18/04/15.
 */
public class Physics {

    public static boolean Collision(EntityA enta, EntityB entb) {


        if (enta.getBounds().intersects(entb.getBounds())) {
            return true;

        }
        return false;
    }





    public static boolean Collision(EntityB entb, EntityA enta){


            if(entb.getBounds().intersects(enta.getBounds())){
                return true;


        }
        return false;
    }



}