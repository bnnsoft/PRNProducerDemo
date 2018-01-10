/*
 * @(#) SeedGenerator.java  1.0  Dec 29, 2017
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
package prnproducerdemo;

/**
 * Generates random numbers
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class SeedGenerator {

    // Constructor
    public SeedGenerator() {
    }

    /**
     * Generates random integer
     *
     * @return int (1..98)
     */
    public int GetSeedAlpha() {
        int seed = 0;
        seed = (int) (Math.random() * (98 - 1)) + 1;
        return seed;
    }

    /**
     * Generates random integer
     *
     * @return int (1..10)
     */
    public int GetSeedBeta() {
        int seed = 0;
        seed = (int) (Math.random() * 11);
        return seed;
    }

    /**
     * Generates random integer
     *
     * @return int 0 - 31
     */
    public int GetSeedGamma() {
        int seed = 0;
        seed = (int) (Math.random() * (32 - 1));
        return seed;
    }

    /**
     * Returns the current value of the running JVM time in nanoseconds.
     *
     * @return lonf
     */
    public long GetTimeStamp() {
        return System.nanoTime();
    }
}
