package com.kaseya.java_interview_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import jline.console.ConsoleReader;

public final class InterviewTest extends InterviewTestBase {

    @Override
    public final boolean handleInput(String line) {
        //TODO - Handle user input and provide search results
        return false;
    }

    @Override
    public final void indexResourceFiles(List<String> searchFiles) throws Exception {
        System.out.print("preparing text files for search");
        for (String file : searchFiles) {
            System.out.print(".");
            StringBuffer sb = new StringBuffer();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                                    Thread.currentThread().getContextClassLoader().getResourceAsStream(file)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    //TODO process text files, index contents for later searching
                }
            } catch (Exception ex) {
                throw ex;
            }
        }
        System.out.println("done");
    }

    public static void main(String[] args) {
        final InterviewTest interviewTest = new InterviewTest();
        try {
            interviewTest.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
