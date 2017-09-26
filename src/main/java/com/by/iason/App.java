package com.by.iason;

import multichain.command.MultiChainCommand;
import multichain.object.StreamKeyItem;
import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        int index = Integer.valueOf(args[0]) - 1;
        Node node = Node.values()[index];

        MultiChainCommand cmd =
                new MultiChainCommand("localhost", node.getRpcport(), node.getRpcuser(), node.getRpspwd());

        System.out.println("Enter action: 1 - write to messages, 2 - read from messages, 0 - quit");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int action = Integer.valueOf(br.readLine());

        while (action != 0) {
            switch (action) {
                case 1:
                    cmd.getStreamCommand().publish("messages", "fromJava", toHex("Hello, " + new Date()));
                    break;
                case 2:
                    StreamKeyItem item = cmd.getStreamCommand().listStreamKeyItems("messages", "fromJava", false, 1).get(0);
                    System.out.print("from: " + item.getPublishers().get(0) + ", messsage: ");
                    System.out.println(fromHex(item.getData()));
                    break;
                default:

                    break;
            }
            System.out.println("Enter action: 1 - write to messages, 2 - read from messages, 0 - quit");
            action = Integer.valueOf(br.readLine());
        }
        System.out.println("Exit...");

    }

    public static String toHex(String arg) {
        return String.format("%x", new BigInteger(1, arg.getBytes()));
    }

    public static String fromHex(String hexString) throws Exception {
        byte[] bytes = Hex.decodeHex(hexString.toCharArray());
        return new String(bytes, "UTF-8");
    }
}
