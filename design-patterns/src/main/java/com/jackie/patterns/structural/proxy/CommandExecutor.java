package com.jackie.patterns.structural.proxy;

/**
 * Created by jackie on 5/30/2016.
 */
public interface CommandExecutor {
    void runCommand(String cmd) throws Exception;
}
