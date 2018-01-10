/*
 * @(#) Guesser.java  1.0  Dec 29, 2017
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

import java.util.Random;
import static prnproducerdemo.PublisherUtils.RANDOM_NUMBER_RANGE;

/**
 * Guess random number
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class Guesser {

    Random randomNum = new Random();

    // Constructor
    public Guesser() {
    }

    /**
     * Generates random number in the range [0 - 65534] Uniform distribution
     *
     * @return int
     */
    public int GuessRundomNumber() {
        return (new Random()).nextInt(RANDOM_NUMBER_RANGE);
    }

    /**
     * Guess random number with some previous knowledge if i == 0 -> random
     * number is in the range: ts +- seed i == 1 -> random number is in the
     * range: 2 to the power (1-8) i == 2 & seed < 49 -> random number is in the
     * range: seed*(1-49) i == 2 & seed > 49 -> random number is in the range:
     * seed*(50-98)
     *
     * @param i
     * @param seed
     * @param ts
     * @return long
     */
    public long GuessRundomNumber(int i, long seed, long ts) {
        long result = 0;
        int coinFLip;

        if (i == 0) {
            coinFLip = randomNum.nextInt(2);
            if (coinFLip == 0) {
                result = ts - seed;
            } else {
                result = ts + seed;
            }
        } else if (i == 1) {
            int guessPower = (int) (Math.random() * (9 - 1)) + 1;
            return seed << (1 << guessPower);
        } else {
            int guessMultiplier;
            if (seed < 49) {
                guessMultiplier = (int) (Math.random() * (50 - 1)) + 1;
            } else {
                guessMultiplier = (int) (Math.random() * (98 - 49)) + 1;
            }
            result = (long) seed * guessMultiplier;
        }

        return result;
    }
}
