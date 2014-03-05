package com.kaseya.java_interview_test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class InterviewTestTest extends TestCase {

    public InterviewTestTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(InterviewTestTest.class);
    }

    public void testSomething() {
        assertTrue(true);
    }
}
