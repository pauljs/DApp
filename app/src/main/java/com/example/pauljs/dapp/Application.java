package com.example.pauljs.dapp;

import com.parse.Parse;

/**
 * Created by pauljs on 10/28/2015.
 */
public class Application extends com.activeandroid.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String appID = "TgxfadnYwKEoruCIICuJZkxNErjnbQzjjwXmaOej";
        String client_key = "EOSsDJyLsJZjVmvNFffDwUs6Q0Gnt6hYjNznEYPW";
        Parse.initialize(this, appID, client_key);
    }
}
