package com.bvan.jc.junit;

import org.junit.*;

/**
 * @author bvanchuhov
 */
public class SimpleTest {

    private String name;

    public SimpleTest() {
        System.out.println("SimpleTest: constructor");
        System.out.println();
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BEFORE CLASS");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AFTER CLASS");
    }

    @Before
    public void before() throws Exception {
        System.out.println("Before");
        name = "John";
    }

    @After
    public void after() throws Exception {
        System.out.println("After");
    }

    @Test
    public void test1() {
        System.out.println("Test 1: " + name);
    }

    @Test
    public void test2() {
        System.out.println("Test 2: " + name);
    }
}
