package com.by.iason.config;

/**
 * Created by iason
 * on 9/29/2017.
 */

public class Node {

    private String name;
    private String rpchost;
    private String rpcport;
    private String rpcuser;
    private String rpcpassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRpchost() {
        return rpchost;
    }

    public void setRpchost(String rpchost) {
        this.rpchost = rpchost;
    }

    public String getRpcport() {
        return rpcport;
    }

    public void setRpcport(String rpcport) {
        this.rpcport = rpcport;
    }

    public String getRpcuser() {
        return rpcuser;
    }

    public void setRpcuser(String rpcuser) {
        this.rpcuser = rpcuser;
    }

    public String getRpcpassword() {
        return rpcpassword;
    }

    public void setRpcpassword(String rpcpassword) {
        this.rpcpassword = rpcpassword;
    }
}
