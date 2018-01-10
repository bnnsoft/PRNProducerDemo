/*
 * @(#)Generator.java  1.0  Dec 29, 2017
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
 * Generator interface
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public interface Generator {

    public long PseudoRandomNumberGenrator();
    
    public long PseudoRandomNumberGenrator(int seed);
    
    public long PseudoRandomNumberGenrator(int seed, long timestamp);

}
