package com.jackie.patterns.structural.proxy;

import org.junit.Test;

/**
 * Created by jackie on 5/30/2016.
 */
public class CommandExecutorProxyTest {

    @Test
    public void runCommand() throws Exception {
        CommandExecutor executor = new CommandExecutorProxy("jackie", "myPdassword");
        try {
            executor.runCommand("cmd.exe");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }
    }
}