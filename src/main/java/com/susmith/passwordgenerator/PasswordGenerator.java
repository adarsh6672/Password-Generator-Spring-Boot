package com.susmith.passwordgenerator;

import java.security.SecureRandom;

public class PasswordGenerator {

    public static String generate(PasswordRequest passwordRequest){
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()_-+=<>?";

        StringBuilder charSet = new StringBuilder();
        if(passwordRequest.isLowercase()){
            charSet.append(lowercaseChars);
        }
        if(passwordRequest.isUppercase()){
            charSet.append(uppercaseChars);
        }
        if(passwordRequest.isNumbers()){
            charSet.append(numberChars);
        }
        if(passwordRequest.isSpecialChars()){
            charSet.append(specialChars);
        }

        if(charSet.isEmpty()){
            throw new IllegalArgumentException("Please select at least one character set. ");
        }

        for(int i = 0; i<passwordRequest.getLength(); i++){
            int randomIndex = random.nextInt(charSet.length());
            password.append(charSet.charAt(randomIndex));
        }

        return password.toString();
    }
}
