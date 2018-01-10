/*
 * @(#) GeneratorOne.java  1.0  Dec 29, 2017
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
 * Random number generator No:1
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class GeneratorOne implements Generator {

    // Constructor
    public GeneratorOne() {
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
     * Generates pseudo random number based on seed
     *
     * @param seed
     * @return long
     */
    public long PseudoRandomNumberGenrator(int seed) {
        long temp = 0;
        temp ^= (seed << 10);
        temp ^= (temp >>> 15); // >>> will always put a 0 in the left most bit
        temp ^= (temp << 3);
        return temp;
    }

    /**
     * Generates random number equal to seed to the power of two (2^seed)/65536
     *
     * @param seed in range 1 - 98
     * @param timestamp (not used)
     * @return int random number in range 1 - 9604 There are only 98 possible
     * outputs
     */
    public long PseudoRandomNumberGenrator(int seed, long timestamp) {
        long result = 0;

        result = (long) seed * seed; // seed to the power of two
        return result;
    }
}
