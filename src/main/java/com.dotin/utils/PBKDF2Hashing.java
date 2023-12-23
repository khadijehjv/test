package com.example.demo.utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;


public class PBKDF2Hashing {



    public static String toHash(String password) {
//        MessageDigest md = null;
        byte[] hash={0};
        byte[] salt = hexStringToByteArray("0123456789abcdefghijklmnopqrstuv");
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = factory.generateSecret(spec).getEncoded();
//            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException |InvalidKeySpecException e) {
            e.printStackTrace();
        }finally {
            String s=new String(hash, StandardCharsets.UTF_8);
            return s;
        }
//        md.update(salt);
//        return md.digest(password.getBytes(StandardCharsets.UTF_8));

    }


    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
