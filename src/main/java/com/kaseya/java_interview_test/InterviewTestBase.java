package com.kaseya.java_interview_test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public abstract class InterviewTestBase implements ConsoleHandler {

    private Console console;

    protected final void run() throws Exception {
        clearScreen();
        System.out.println("********************************************************************************");
        System.out.println("******************  Java Interview Test - Search Engine App  *******************");
        System.out.println("********************************************************************************");

        indexResourceFiles(getResourceFileList("files/"));

        System.out.print("\nPlease provide search terms:");
        console = new Console(this);
        console.start();
    }

    public abstract void indexResourceFiles(List<String> searchFiles) throws Exception;
    public abstract boolean handleInput(String line);

    protected final void clearScreen() {
        if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
            String ANSI_CSI = "\u001b[";
            System.out.print(ANSI_CSI + 2 + "J");
            System.out.flush();
            System.out.print(ANSI_CSI + "1;1H");
            System.out.flush();
        }
    }

    private final List<String> getResourceFileList(String prefix) throws Exception {
        List<String> files = new ArrayList<String>();
        Enumeration<URL> paths = Thread.currentThread().getContextClassLoader().getResources(prefix);
        while (paths.hasMoreElements()) {
            URL path = paths.nextElement();
            File dir = new File(path.getPath());
            for (File file : dir.listFiles()) {
                files.add(prefix + file.getName());
            }
        }
        return files;
    }

}
