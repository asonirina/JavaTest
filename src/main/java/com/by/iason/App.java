package com.by.iason;

import com.by.iason.config.Node;
import com.by.iason.config.NodesLoader;
import multichain.command.MultiChainCommand;
import multichain.object.StreamKeyItem;
import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        int index = Integer.valueOf(args[0]) - 1;

        List<Node> nodes = new NodesLoader().getAllNodes();
        Node node = nodes.get(index);

        MultiChainCommand cmd =
                new MultiChainCommand(node.getRpchost(), node.getRpcport(), node.getRpcuser(), node.getRpcpassword());

        System.out.println("Enter action: " +
                "1 - write to messages,\n" +
                "2 - read from messages, \n" +
                "3 - publish PK, \n" +
                "4 - write secret message to ..., \n" +
                "5 - read latest secret message,  \n" +
                "0 - quit");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int action = Integer.valueOf(br.readLine());

        while (action != 0) {
            switch (action) {

                case 1:
                    cmd.getStreamCommand().publish("messages", "fromJava", Hex.encodeHexString(("Hello, " + new Date()).getBytes()));
                    break;

                case 2:
                    StreamKeyItem item = cmd.getStreamCommand().listStreamKeyItems("messages", "fromJava", false, 1).get(0);
                    System.out.print("from: " + item.getPublishers().get(0) + ", messsage: ");
                    System.out.println(Arrays.toString(Hex.decodeHex(item.getData().toCharArray())));
                    break;

                case 3:
                    new PublicKeysExporter().publishPublicKey(cmd, node);
                    break;

                case 4:
                    System.out.println("Enter recipient number: 1, 2, 3");

                    int to = Integer.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine());
                    Node toNode = nodes.get(to - 1);

                    new SecretMessageSender().send(cmd, toNode);

                    break;

                case 5:
                    new SecretMessageSender().get(cmd, node);
                break;

                default:
                    break;
            }

            System.out.println("Enter action: " +
                    "1 - write to messages,\n" +
                    "2 - read from messages, \n" +
                    "3 - publish PK, \n" +
                    "4 - write secret message to ..., \n" +
                    "5 - read latest secret message,  \n" +
                    "0 - quit");
            action = Integer.valueOf(br.readLine());
        }
        System.out.println("Exit...");

    }

}
