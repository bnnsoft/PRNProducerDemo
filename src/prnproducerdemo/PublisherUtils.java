/*
 * @(#) PublisherUtils.java  1.0  Dec 29, 2017
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

import java.util.Hashtable;
import java.util.prefs.Preferences;

/**
 * Publisher Utilities
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class PublisherUtils {

    public static final String PathToKafka = "/Users/bojannokovic/desktop/kafka_2.11-1.0.0";
    public static final Preferences pref = Preferences.userRoot().node(PathToKafka);
    public static final int RANDOM_NUMBER_RANGE = 65536;
    public static final int GEN_ONE_RANDOM_NUMBER_RANGE = 9604;
    public static final int GEN_TWO_RANDOM_NUMBER_RANGE = 1024;

    // 0 < Seed < 99 
    public static int SEED_MIN = 1;
    public static int SEED_MAX = 98;

    // Publisher properties
    public static final String TOPIC = "randomnumbers";
    public static final String KAFKA_SERVER_URL = "172.31.19.227";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 33554432;
    public static final int CONNECTION_TIMEOUT = 60000;
    public static final String CLIENT_ID = "";

    // Constructor
    private PublisherUtils() {
    }
}
