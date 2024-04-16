package com.snack_shop.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashTokenGenerator {
    public static String generateHashToken(String password) throws NoSuchAlgorithmException {
        return hashPassword(password);
    }
    private static String hashPassword(String password) {
        try {
            // Get all the number of the password then add secret keyword "az" to the end
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher =  pattern.matcher(password);
            String salt = "";
            while (matcher.find()) {
                salt += matcher.group();
            }
            salt += "az";
            byte[] saltByte = salt.getBytes();
            // Combine password and saltByte (salt in bytes)
            byte[] passwordWithSalt = (password + Base64.getEncoder().encodeToString(saltByte)).getBytes();
            // Create MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Update digest with password and salt
            byte[] hashedBytes = digest.digest(passwordWithSalt);

            // Convert hashed bytes to base64
            return Base64.getEncoder().encodeToString(hashedBytes);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
