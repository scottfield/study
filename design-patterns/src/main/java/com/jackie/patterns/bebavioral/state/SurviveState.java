package com.jackie.patterns.bebavioral.state;

/**
 * Created by jackie on 6/14/2016.
 */
public class SurviveState implements PlayerState {
    @Override
    public void action(Player player) {
        player.firePistol();
        player.survive();
    }
}
