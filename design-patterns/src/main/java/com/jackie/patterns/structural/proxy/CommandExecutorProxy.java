package com.jackie.patterns.structural.proxy;

/**
 * Created by jackie on 5/30/2016.
 */
public class CommandExecutorProxy implements CommandExecutor {
    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user, String pwd) {
        if ("jackie".equals(user) && "myPassword".equals(pwd)) {
            isAdmin = true;
        }
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for non-admin users.");
            } else {
                executor.runCommand(cmd);
            }
        }
    }
}
