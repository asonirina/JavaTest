package com.by.iason;

/**
 * Created by iason
 * on 9/26/2017.
 */
public enum Node {
    NODE1("4333", "multichainrpc", "GjCMwewz4xD92YbDeeq4qTRsVMiHSvXJbXZVDmL3bupH"),
    NODE2("4334", "multichainrpc", "3AJT8Rt4Dq1hPtYTZEMBFHhxcJ8Aq1RoyCmNtqnQDgW7"),
    NODE3("4337", "multichainrpc", "FJCJariiWX3xb5Zx2UbLT1AzLPQ8ajwp2hHpd2qQnEGu");

    String rpcport;
    String rpcuser;
    String rpspwd;

    Node(String rpcport, String rpcuser, String rpspwd) {
        this.rpcport = rpcport;
        this.rpcuser = rpcuser;
        this.rpspwd = rpspwd;
    }

    public String getRpcport() {
        return rpcport;
    }

    public String getRpcuser() {
        return rpcuser;
    }

    public String getRpspwd() {
        return rpspwd;
    }
}
