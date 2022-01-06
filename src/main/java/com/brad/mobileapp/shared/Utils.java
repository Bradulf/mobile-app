package com.brad.mobileapp.shared;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {
    private final Random random = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateUserId(int length){
        return generateRandomString(length);
    }

    //
    private String generateRandomString(int length){
        //using string builder
        StringBuilder returnValue = new StringBuilder(length);

        //we will randomly iterate through alphabet a given number of times then append
        for (int i = 0; i < length; i++) {
            //alphabet is the source of characters
            returnValue.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

}
