package com.jackie.patterns.structural.proxy;

/**
 * Created by jackie on 5/30/2016.
 */
public class CommandExecutorImpl implements CommandExecutor {
    @Override
    public void runCommand(String cmd) throws Exception {
        //some heavy implementation
        //Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }
}
