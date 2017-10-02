package com.by.iason.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by iason
 * on 9/29/2017.
 */
public class NodesLoader {

    public List<Node> getAllNodes() throws Exception {
        Properties prop = new Properties();

        ClassLoader classLoader = NodesLoader.class.getClassLoader();
        InputStream stream = classLoader.getResourceAsStream("config.properties");

        prop.load(stream);

        int count = prop.size() / 5;
        List<Node> nodes = new ArrayList<Node>();

        for (int i = 0; i < count; i++) {
            Node node = new Node();
            node.setName(prop.getProperty("default" + i + ".name"));
            node.setRpchost(prop.getProperty("default" + i + ".rpchost"));
            node.setRpcport(prop.getProperty("default" + i + ".rpcport"));
            node.setRpcuser(prop.getProperty("default" + i + ".rpcuser"));
            node.setRpcpassword(prop.getProperty("default" + i + ".rpcpassword"));

            nodes.add(node);
        }

        return nodes;
    }
}
