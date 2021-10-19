package com.banamex.ibm.applyforacreditcard.util;

public final class AreLetters {
    public static boolean verify(String stringToValidate){
        if (stringToValidate == null || stringToValidate.isEmpty())
            return false;
        int index = 0;
        for(; index<stringToValidate.length();index++){
            if(!Character.isLetter(stringToValidate.charAt(index))){
                return false;
            }
        }
        return true;
    }
}
