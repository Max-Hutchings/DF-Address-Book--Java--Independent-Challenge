package com.addressbook.validator;

// TODO: build test and implement validateName()
// TODO: build test and implement validatePhoneNumber()
// TODO: Build test and implement validateEmail()

public class Validators {

    public static String validateName(String name) throws Exception{
        if (name.isEmpty()) throw new Exception("Your name cannot be empty");
        String[] illegalCharacters = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "/", ".", ",", ";", ":", "#", "@"};
        for (String character: illegalCharacters){
            if (name.contains(character)) throw new Exception("Cannot use the character: " + "'" + character + "'");
        }
        if (name.length() > 50) throw new Exception("Please enter a shorter name");
        return name;
    }



}
