package com.block.tools;


import com.block.Apis;

import java.io.File;


public class Tool {

    public static  String getKeystore() {
        return getAbsolutePath()+ Apis.KEYSTORE;
    }

    public static  String getAbsolutePath() {
        return new File("").getAbsolutePath();
    }

}
