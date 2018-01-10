/*
 * @(#) PRNProducer.java  1.0  Dec 29, 2017
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

import java.util.*;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * Produce PRN and sends it to Kafka
 *
 * @author Bojan Nokovic
 * @version 1.0 Jan. 01, 2018 Created.
 */
public class PRNProducer extends Thread {

    static String topicName = "randomnumbers";
    static int msgToTransmit = 4;
    static int transmittDelay = 500;

    Timer timer;
    Properties props = new Properties();
    KafkaProducer<String, String> producer;

    public PRNProducer() {

        // System.out.println("Start of Producer Application");
        SetProducerParamethers();

        // Host id, private EC2 AWS IP
        props.put("bootstrap.servers", "172.31.19.227:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
    }

    /**
     *
     * @return Topic name
     */
    public String GetTopic() {
        return topicName;
    }

    /**
     * Send message every "delay" ms
     */
//    public void StartProducer() {
//        timer = new Timer();
//        timer.schedule(new PeriodicTask(msgToTransmit), 0, delay);
//    }
    /**
     * Publish message
     */
    public void run() {
        int messageNo = 1;
        long startTime = System.currentTimeMillis();
        while (msgToTransmit > 0) {
            System.out.println("Msg " + messageNo + " transmitting");

            LinkedList<Record> record = MyPublisher();

            // Temp, pass record to Kafka as string
            String srecord = "";
            ListIterator<Record> listIterator = record.listIterator();
            while (listIterator.hasNext()) {
                srecord += listIterator.next().toString();
            }

            // Simple asynch transmission 
            //           producer.send(new ProducerRecord<String, String>(topicName,
            //                            Integer.toString(messageNo), srecord));
            producer.send(new ProducerRecord<String, String>(topicName,
                    Integer.toString(messageNo), srecord), new PRNDemoCallBack(startTime, messageNo, srecord));

            msgToTransmit--;
            ++messageNo;
        }
        producer.close();
    }

    /**
     * Create the record to be published. The record has - random number -
     * guess1 - guess2 - guess3 - seed - time stamp
     *
     * @return List of six records
     */
    public static LinkedList<Record> MyPublisher() {

        LinkedList<Record> rl = new LinkedList<Record>();

        // We generate six random numbers by six "generators"
        for (int i = 0; i < 6; i++) {
            // Get the seed and the timestamp
            SeedGenerator gs = new SeedGenerator();
            int seed = gs.GetSeedAlpha();
            long ts = gs.GetTimeStamp();

            PRNGenerator pnr = new PRNGenerator();

            // Special case (2 to power of seed)
            if (i == 1) {
                // If the seed is bigger than 32 
                // take only five least significant bits. 
                if (seed > 32) {
                    seed = seed & 0x1F;
                }
            }

            // Get a random number
            long x = pnr.PRNGenerator(i, seed, ts);

            // Get three guesses
            long y[];
            y = new long[3];
            Guesser guess = new Guesser();
            for (int j = 0; j < 3; j++) {
                y[j] = guess.GuessRundomNumber(j, seed, ts);
            }
            // Create the record
            Record rec = new Record();
            rec.SetRecord(x, y, seed, ts);
            // Sore the record
            rl.push(rec);
        }
        return rl;
    }

    /**
     * Allows to set - the topic name - numbers of messages to transmit.
     *
     * @return validParams, true is params OK
     */
    private static boolean SetProducerParamethers() {
        boolean validParams = true;

        // Create a scanner to read the command line input
        Scanner scanner = new Scanner(System.in);

        // Prompt for the parameters
        System.out.print("Set publisher parameters Y/N:");
        String setParam = scanner.next();
        if (setParam.matches("Y") || setParam.matches("y")) {

            System.out.print("Enter topic name (randomnumbers):");
            topicName = scanner.next();
            // Check if input is empty string
            if (topicName.matches("")) {
                topicName = "randomnumbers";
                validParams = false;
            }

            System.out.print("Enter number of messages to transmit [1..100000] (4):");
            msgToTransmit = scanner.nextInt();
            if (msgToTransmit < 1 || msgToTransmit > 100000) {
                msgToTransmit = 10;
                validParams = false;
            }
//            System.out.print("Enter delay [ms] between message transmission [50..5000] (500):");
//            msgToTransmit = scanner.nextInt();
//            if (transmittDelay < 50 || transmittDelay > 5000) {
//                transmittDelay = 500;
//                validParams = false;
//            }
        }
        return validParams;
    }

    /**
     * Send message based on timer event
     */
//    class PeriodicTask extends TimerTask {
//
//        PeriodicTask(int numMsgToTransmit) {
//            nbOfTransmissions = numMsgToTransmit;
//        }
//
//        public void run() {
//            if (nbOfTransmissions > 0) {
//
//                LinkedList<Record> record = MyPublisher();
//
//                // Temp, pass record to Kafka as string
//                String srecord = "";
//                ListIterator<Record> listIterator = record.listIterator();
//                while (listIterator.hasNext()) {
//                    srecord += listIterator.next().toString();
//                }
//                try {
//                    producer.send(new ProducerRecord<String, String>(topic,
//                            Integer.toString(nbOfTransmissions), srecord)).get();
//                    nbOfTransmissions--;
//                } catch (InterruptedException | ExecutionException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                System.out.println("Transmission Done");
//                timer.cancel();
//            }
//        }
//    }
    /**
     * This class is based on Kafka Producer implementation. It is licensed to
     * the Apache Software Foundation (ASF) We use it in compliance with the
     * License http://www.apache.org/licenses/LICENSE-2.0
     *
     */
    class PRNDemoCallBack implements Callback {

        private final long startTime;
        private final String message;

        public PRNDemoCallBack(long startTime, int key, String message) {
            this.startTime = startTime;
            this.message = message;
        }

        /**
         * A callback method the user can implement to provide asynchronous
         * handling of request completion. This method will be called when the
         * record sent to the server has been acknowledged.
         *
         * @param metadata The metadata for the record that was sent (i.e. the
         * partition and offset).
         * @param exception The exception thrown during processing of this
         * record.
         */
        public void onCompletion(RecordMetadata metadata, Exception e) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (metadata != null) {
                System.out.println(
                        "Message:" + message + " sent to partition(" + metadata.partition()
                        + "), " + "offset(" + metadata.offset() + ") in " + elapsedTime + " ms");
            } else {
                e.printStackTrace();
            }
        }
    }
}
