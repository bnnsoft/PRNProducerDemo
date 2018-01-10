/*
 * @(#) PRNGenerator.java  1.0  Dec 29, 2017
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
 * A pseudo-random number generator
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class PRNGenerator {

    // Constructor 
    public PRNGenerator() {
    }

    public long PRNGenerator(int generator, int seed, long timestamp) {

        long randomNumber = 0;

        switch (generator) {
            case 0:
                randomNumber = (new GeneratorOne()).PseudoRandomNumberGenrator(seed, timestamp);
                break;
            case 1:
                randomNumber = (new GeneratorTwo()).PseudoRandomNumberGenrator(seed, timestamp);
                break;
            case 2:
                randomNumber = (new GeneratorThree()).PseudoRandomNumberGenrator(seed, timestamp);
                break;
            case 3:
                randomNumber = (new GeneratorFour()).PseudoRandomNumberGenrator(seed, timestamp);
                break;
            case 4:
                randomNumber = (new GeneratorFive()).PseudoRandomNumberGenrator(seed, timestamp);
                break;
            case 5:
                randomNumber = (new GeneratorSix()).PseudoRandomNumberGenrator(seed, timestamp);
                break;
            default:
                randomNumber = -1;
                break;
        }
        return randomNumber;
    }
}
