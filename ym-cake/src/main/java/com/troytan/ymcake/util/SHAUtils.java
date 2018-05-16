package com.troytan.ymcake.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtils {

    public static String getSha1(String data) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
        return "";
    }
}
