package com.by.iason;

import com.by.iason.config.Node;
import multichain.command.MultiChainCommand;
import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by iason
 * on 9/29/2017.
 */
public class PublicKeysExporter {

    public void publishPublicKey(MultiChainCommand cmd, Node node) throws Exception {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        KeyPair keypair = kpg.generateKeyPair();

        export(node, keypair.getPrivate());
        export(node, keypair.getPublic());

        cmd.getStreamCommand().publish("public_keys", node.getName(), new String(Hex.encodeHex(keypair.getPublic().getEncoded())));
        System.out.println(node.getName() + " PK was published!");
    }

    public void export(Node node, PrivateKey privateKey) throws Exception {
        File exportedFile = new File(node.getName() + "/private_key");
        FileOutputStream fos = new FileOutputStream(exportedFile);
        fos.write(privateKey.getEncoded());
        fos.close();
    }

    public void export(Node node, PublicKey publicKey) throws Exception {
        File exportedFile = new File(node.getName() + "/public_key");
        FileOutputStream fos = new FileOutputStream(exportedFile);
        fos.write(publicKey.getEncoded());
        fos.close();
    }
}
