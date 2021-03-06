package com.jackie.patterns.bebavioral.state;

/**
 * Created by jackie on 6/14/2016.
 */
public class GameContext {
    private PlayerState playerState = null;
    private Player player = new Player();

    public void setPlayerState(PlayerState state) {
        this.playerState = state;
    }

    public void gameAction() {
        playerState.action(player);
    }
}
