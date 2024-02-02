package com.addressbook.validator;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validators {

    public static String validateName(String name) throws Exception{
        if (name.trim().isEmpty()) throw new Exception("Your name cannot be empty");
        String[] illegalCharacters = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "/", ".", ",", ";", ":", "#", "@"};
        for (String character: illegalCharacters){
            if (name.contains(character)) throw new Exception("Cannot use the character: " + "'" + character + "'");
        }
        if (name.length() > 50) throw new Exception("Please enter a shorter name");
        return name;
    }

    public static String validatePhoneNumber(String number)throws Exception{
        String tempNum = number.trim();
        int length = tempNum.length();
        if (length != 11 && length != 13) throw new Exception("Please enter a correct length number");
        if (tempNum.charAt(0) != '0' && tempNum.charAt(0) != '+') throw new Exception("Please start the number with a 0 or +");
        if (!tempNum.matches("^[0-9+]*$")) throw new Exception("Please enter valid characters");
        return tempNum;
    }


    public static InternetAddress validateEmail(String email) throws Exception{
        try{
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
            return emailAddress;
        } catch(AddressException ex){
            throw new Exception("Invalid Email Address");
        }
    }



}
