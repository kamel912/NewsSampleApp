package com.teamvii.news.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.teamvii.news.network.ApiKeys.APP_ID;
import static com.teamvii.news.network.ApiKeys.APP_SECRET;
import static com.teamvii.news.network.ApiKeys.HASH_KEY;

public class NetworkUtils {

    public static String getSignature(String... parameters) {
        StringBuilder signatureString = new StringBuilder();
        for (String parameter : parameters) {
            signatureString.append(parameter);
        }
        signatureString.append(APP_ID).append(APP_SECRET).append(HASH_KEY);
        return md5(signatureString.toString());
    }

    private static String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
