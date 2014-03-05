package com.kaseya.java_interview_test;

import jline.console.ConsoleReader;

public final class Console extends Thread {

    private ConsoleHandler handler;

    public Console(ConsoleHandler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            String line = "";
            ConsoleReader reader = new ConsoleReader();
            reader.setBellEnabled(false);

            //read input
            while ((line = reader.readLine("\n> ")) != null) {
                if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                    System.out.println("Bye");
                    break;
                } else {
                    if (!handler.handleInput(line)) {
                        System.out.println("I dont understand the input");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.exit(1);
        }
    }

}
