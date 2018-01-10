/*
 * @(#) GeneratorTwo.java  1.0  Dec 29, 2017
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
 * Random number generator No:2
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class GeneratorTwo implements Generator {

    // Constructor
    public GeneratorTwo() {
    }

    /**
     * For future use
     *
     * @return -1
     */
    public long PseudoRandomNumberGenrator() {
        return -1;
    }

    /**
     * For future use
     *
     * @param seed
     * @return -1
     */
    public long PseudoRandomNumberGenrator(int seed) {
        return -1;
    }

    /**
     * Generates random number 2 to the power of seed. The seed should be in the
     * range (0-31) to avoid overflow
     *
     * @param seed
     * @param timestamp
     * @return int random number Only 32 possible outputs
     */
    public long PseudoRandomNumberGenrator(int seed, long timestamp) {
        long result = 1 << seed; // 2 to the powe of seed
        return result;
    }
}
