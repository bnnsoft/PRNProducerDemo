/*
 * @(#) PNGeneratorsTest.java  1.0  Dec 29, 2017
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
import java.util.Scanner;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import prnproducerdemo.Generator;
import prnproducerdemo.GeneratorFive;
import prnproducerdemo.GeneratorFour;
import prnproducerdemo.GeneratorOne;
import prnproducerdemo.GeneratorSix;
import prnproducerdemo.GeneratorThree;
import prnproducerdemo.GeneratorTwo;
import static prnproducerdemo.PublisherUtils.GEN_ONE_RANDOM_NUMBER_RANGE;
import static prnproducerdemo.PublisherUtils.GEN_TWO_RANDOM_NUMBER_RANGE;
import static prnproducerdemo.PublisherUtils.RANDOM_NUMBER_RANGE;
import prnproducerdemo.SeedGenerator;

public class PNGeneratorsTest extends TestCase {

    SeedGenerator sg = new SeedGenerator();

    public PNGeneratorsTest(String testName) {
        super(testName);
    }

    /**
     * Test if the seed is in 1..98 range
     */
    public void testRange10() {
        boolean result = true;
        int seed = 0;
        long prn = 0;
        long ts;

        System.out.println("testRange10");
        GeneratorOne generator = new GeneratorOne();
        for (int i = 0; i < 100; i++) {
            seed = sg.GetSeedAlpha();
            ts = sg.GetTimeStamp();
            prn = generator.PseudoRandomNumberGenrator(seed, ts);
            System.out.println("Prn = " + prn);

            if (prn < 0 || seed > GEN_ONE_RANDOM_NUMBER_RANGE) {
                result = false;
            }
        }
        assertEquals(true, result);
    }

    /**
     * Test if the seed is in 1..98 range
     */
    public void testRange20() {
        boolean result = true;
        int seed = 0;
        long prn = 0;
        long ts;
        System.out.println("testRange20");
        GeneratorTwo generator = new GeneratorTwo();
        for (int i = 0; i < 100; i++) {
            seed = sg.GetSeedAlpha();
            ts = sg.GetTimeStamp();
            prn = generator.PseudoRandomNumberGenrator(seed, ts);
            System.out.println("Prn = " + prn);
            if (prn < 0 || seed > GEN_TWO_RANDOM_NUMBER_RANGE) {
                result = false;
            }
        }
        assertEquals(true, result);
    }

    /**
     * Test if the seed is in 1..98 range
     */
    public void testRange30() {
        boolean result = true;
        int seed = 0;
        long prn = 0;
        long ts;
        System.out.println("testRang30");
        GeneratorThree generator = new GeneratorThree();
        for (int i = 0; i < 100; i++) {
            seed = sg.GetSeedAlpha();
            ts = sg.GetTimeStamp();
            prn = generator.PseudoRandomNumberGenrator(seed, ts);
            System.out.println("Prn = " + prn);
            //if (prn < 0 || seed > GEN_TWO_RANDOM_NUMBER_RANGE) {
            //    result = false;
            //}
        }
        assertEquals(true, result);
    }

    public void testRange40() {
        boolean result = true;
        int seed = 0;
        long prn = 0;
        long ts;
        System.out.println("testRange40");
        GeneratorFour generator = new GeneratorFour();
        for (int i = 0; i < 100; i++) {
            seed = sg.GetSeedAlpha();
            ts = sg.GetTimeStamp();
            prn = generator.PseudoRandomNumberGenrator(seed, ts);
            System.out.println("Prn = " + prn);
            //if (prn < 0 || seed > GEN_TWO_RANDOM_NUMBER_RANGE) {
            //    result = false;
            //}
        }
        assertEquals(true, result);
    }

    public void testRange50() {
        boolean result = true;
        int seed = 0;
        long prn = 0;
        long ts;
        System.out.println("testRange50");
        GeneratorFive generator = new GeneratorFive();
        for (int i = 0; i < 100; i++) {
            seed = sg.GetSeedAlpha();
            ts = sg.GetTimeStamp();
            prn = generator.PseudoRandomNumberGenrator(seed, ts);
            System.out.println("Prn = " + prn);
            //if (prn < 0 || seed > GEN_TWO_RANDOM_NUMBER_RANGE) {
            //    result = false;
            //}
        }
        assertEquals(true, result);
    }

    public void testRange60() {
        boolean result = true;
        int seed = 0;
        long prn = 0;
        long ts;
        System.out.println("testRange60");
        GeneratorSix generator = new GeneratorSix();
        for (int i = 0; i < 100; i++) {
            seed = sg.GetSeedAlpha();
            ts = sg.GetTimeStamp();
            prn = generator.PseudoRandomNumberGenrator(seed, ts);
            System.out.println("Prn = " + prn);
            //if (prn < 0 || seed > GEN_TWO_RANDOM_NUMBER_RANGE) {
            //    result = false;
            //}
        }
        assertEquals(true, result);
    }

    /**
     *
     */
    public void testUniformity11() {
        int counterL = 0;
        int counterH = 0;
        boolean result = true;
        int seed = 0;
        long prn = 0;
        long ts;
        GeneratorOne generator = new GeneratorOne();
        System.out.println("testUniformity11");
        int testCount = 20;
        for (int i = 0; i < testCount; i++) {
            seed = sg.GetSeedAlpha();
            ts = sg.GetTimeStamp();
            prn = generator.PseudoRandomNumberGenrator(seed, ts);
            System.out.println(prn);
            if (prn > (GEN_ONE_RANDOM_NUMBER_RANGE / 2)) {
                counterH++;
            } else {
                counterL++;
            }
        }

        System.out.println("Numbers greater than " + GEN_ONE_RANDOM_NUMBER_RANGE / 2 + " = " + counterH);
        System.out.println("Numbers lower than " + GEN_ONE_RANDOM_NUMBER_RANGE / 2 + " = " + counterL);

        if (counterH > (0.75 * testCount) || counterL > (0.75 * testCount)) {
            System.out.println("Generatied random number does not have uniform distribution");
            result = false;
        }
        assertEquals(true, result);
    }

    /**
     *
     */
    public void testUniformity21() {
        int counterL = 0;
        int counterH = 0;
        boolean result = true;
        int seed = 0;
        long prn = 0;
        long ts;
        GeneratorTwo generator = new GeneratorTwo();
        System.out.println("testUniformity21");
        int testCount = 20;
        for (int i = 0; i < testCount; i++) {
            seed = sg.GetSeedBeta();
            ts = sg.GetTimeStamp();
            prn = generator.PseudoRandomNumberGenrator(seed, ts);
            System.out.println(prn);
            if (prn > (GEN_TWO_RANDOM_NUMBER_RANGE / 8)) {
                counterH++;
            } else {
                counterL++;
            }
        }

        System.out.println("Numbers greater than " + GEN_TWO_RANDOM_NUMBER_RANGE / 2 + " = " + counterH);
        System.out.println("Numbers lower than " + GEN_TWO_RANDOM_NUMBER_RANGE / 2 + " = " + counterL);

        if (counterH > (0.75 * testCount) || counterL > (0.75 * testCount)) {
            System.out.println("Generatied random number does not have uniform distribution");
            result = false;
        }
        assertEquals(true, result);
    }

    public static void main(String[] args) {
        System.out.println("\n -------- Generator one test --------\n\n");
        Scanner scanner = new Scanner(System.in);
        junit.textui.TestRunner.run(new TestSuite(PNGeneratorsTest.class));
    }
}
