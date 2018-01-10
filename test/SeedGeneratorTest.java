/*
 * @(#) SeedGeneratorTest.java  1.0  Dec 29, 2017
 *
 * Copyright (c) 2017 Bojan Nokovic
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of the
 * Bojan Nokovic. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with the Bojan Nokovic.
 */
import junit.framework.TestCase;
import junit.framework.TestSuite;
import prnproducerdemo.SeedGenerator;

public class SeedGeneratorTest extends TestCase {

    SeedGenerator sg = new SeedGenerator();

    public SeedGeneratorTest(String testName) {
        super(testName);
    }

    /**
     * Test if the seed is in 1..98 range
     */
    public void testRange() {
        boolean result = true;
        int seed = 0;

        System.out.println("Test seeds range");

        for (int i = 0; i < 10000; i++) {
            seed = sg.GetSeedAlpha();
            if (seed < 1 || seed > 98) {
                result = false;
            }
        }

        assertEquals(true, result);
    }

    /**
     *
     */
    public void testUniformity() {
        int counterL = 0;
        int counterH = 0;
        boolean result = true;
        int seed = 0;

        System.out.println("Test seeds uniformity");

        for (int i = 0; i < 100; i++) {
            seed = sg.GetSeedAlpha();
            if (seed > 49) {
                counterH++;
            } else {
                counterL++;
            }
        }

        if (counterH > 60 || counterH > 60) {
            result = false;
        }

        assertEquals(true, result);
    }

    public static void main(String[] args) {
        System.out.println("\n -------- Seed generator test --------\n\n");
        junit.textui.TestRunner.run(new TestSuite(SeedGeneratorTest.class));
    }
}
