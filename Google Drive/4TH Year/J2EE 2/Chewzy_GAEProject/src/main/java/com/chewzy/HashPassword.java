package com.chewzy;

/**
 * Created by Misa on 9/10/2016.
 */
public class HashPassword {
    public static String MD5conversion(String pword) {
        try {
            String hashpword="";
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(pword.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            hashpword = sb.toString();
            return hashpword;
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
