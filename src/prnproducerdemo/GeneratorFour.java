/*
 * @(#) GeneratorFour.java  1.0  Dec 29, 2017
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
 * Random number generator No:4
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class GeneratorFour implements Generator {

    // Constructor
    public GeneratorFour() {
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
     * Generates random number equal to timestamp + seed
     *
     * @param seed
     * @param timestamp
     * @return long
     */
    public long PseudoRandomNumberGenrator(int seed, long timestamp) {
        long result = timestamp + seed;
        return result;
    }
}
