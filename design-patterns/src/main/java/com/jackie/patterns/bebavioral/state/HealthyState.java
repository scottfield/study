package com.jackie.patterns.bebavioral.state;

/**
 * Created by jackie on 6/14/2016.
 */
public class HealthyState implements PlayerState {
    @Override
    public void action(Player player) {
        player.attack();
        player.fireBumb();
        player.fireGunblade();
        player.fireLaserPistol();
    }
}
