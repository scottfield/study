package com.jackie.patterns.bebavioral.state;

/**
 * Created by jackie on 6/14/2016.
 */
public class Player {
    public void attack() {
        System.out.println("attack");
    }

    public void fireBumb() {
        System.out.println("fire bumb");
    }

    public void fireGunblade() {
        System.out.println("fire gun blade");
    }

    public void fireLaserPistol() {
        System.out.println("fire laser pistol");
    }

    public void firePistol() {
        System.out.println("fire pistol");
    }

    public void survive() {
        System.out.println("surviving");
    }

    public void dead() {
        System.out.println("dead! game over");
    }
}
