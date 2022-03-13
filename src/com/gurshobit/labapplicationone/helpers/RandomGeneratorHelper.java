package com.gurshobit.labapplicationone.helpers;

import java.util.Random;

public class RandomGeneratorHelper {

    public String passwordGenerator(int passwordLength, boolean hasSpecialCharacters, boolean canUseUpperCaseAndLowerCase, boolean canOccurAtLeastOnce){
        final String ALPHA_LOWER_CASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
        final String ALPHA_UPPER_CASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String NUMERIC_CHARACTERS = "0123456789";
        final String SPECIAL_CHARACTERS = "!@#$%^&*(){}[]<>?";
        final int MINIMUM_PASSWORD_LENGTH = 8;

        String possibleCharacters =  ALPHA_LOWER_CASE_CHARACTERS+NUMERIC_CHARACTERS;
        int maximumPasswordLength = MINIMUM_PASSWORD_LENGTH;

        if (passwordLength > MINIMUM_PASSWORD_LENGTH) {
            maximumPasswordLength = passwordLength;
        }

        StringBuilder password = new StringBuilder();
        int remainingLength = 0;
        if(canUseUpperCaseAndLowerCase){
            possibleCharacters = ALPHA_LOWER_CASE_CHARACTERS+ALPHA_UPPER_CASE_CHARACTERS+NUMERIC_CHARACTERS;
        }
        if(hasSpecialCharacters){
            possibleCharacters = ALPHA_LOWER_CASE_CHARACTERS+ALPHA_UPPER_CASE_CHARACTERS+NUMERIC_CHARACTERS+SPECIAL_CHARACTERS;
        }

        for(int i = remainingLength; i < maximumPasswordLength; i++){
            if(canOccurAtLeastOnce && i < 4){
                password.append(randomizeArrayElements(ALPHA_LOWER_CASE_CHARACTERS.toCharArray())[randomIntegerGenerator(0, ALPHA_LOWER_CASE_CHARACTERS.length() - 1)]);
                password.append(randomizeArrayElements(ALPHA_UPPER_CASE_CHARACTERS.toCharArray())[randomIntegerGenerator(0, ALPHA_UPPER_CASE_CHARACTERS.length() - 1)]);
                password.append(randomizeArrayElements(NUMERIC_CHARACTERS.toCharArray())[randomIntegerGenerator(0, NUMERIC_CHARACTERS.length() - 1)]);
                password.append(randomizeArrayElements(SPECIAL_CHARACTERS.toCharArray())[randomIntegerGenerator(0, SPECIAL_CHARACTERS.length() - 1)]);
                i=3;
            } else{
                password.append(randomizeArrayElements(possibleCharacters.toCharArray())[randomIntegerGenerator(0, possibleCharacters.length() - 1)]);
            }
        }

        return password.toString();
    }

    public int randomIntegerGenerator(int minimum,int maximum){
        if(minimum == 0){
            minimum = 1;
        }
        if(maximum == 0){
            maximum = 10;
        }
        int range = maximum - minimum + 1;
        return (int)(Math.random() * range) + minimum;
    }

    public char[] randomizeArrayElements(char[] inputArray){
        Random rand = new Random();

        for (int i = 0; i < inputArray.length; i++) {
            int randomIndexToSwap = rand.nextInt(inputArray.length);
            char temp = inputArray[randomIndexToSwap];
            inputArray[randomIndexToSwap] = inputArray[i];
            inputArray[i] = temp;
        }
        return inputArray;
    }

}
