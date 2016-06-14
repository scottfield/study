package com.jackie.patterns.bebavioral.state;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by jackie on 6/14/2016.
 */
public class GameContextTest extends TestCase {
    @Test
    public void testGameAction() throws Exception {
        GameContext context = new GameContext();
        context.setPlayerState(new HealthyState());
        context.gameAction();
        context.setPlayerState(new SurviveState());
        context.gameAction();
        context.setPlayerState(new DeadState());
        context.gameAction();
    }
}