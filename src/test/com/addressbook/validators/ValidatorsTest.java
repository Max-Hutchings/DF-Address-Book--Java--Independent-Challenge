package com.addressbook.validators;

import com.addressbook.validator.Validators;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.mail.internet.InternetAddress;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorsTest {

    @Nested
    class nameValidators{

        @Test
        public void testRejectIllegalCharacter(){
//            Arramge
            String nameWillIllegalCharacter = "John#Doe";
//            Assert
            assertThrows(Exception.class, () -> {
                Validators.validateName(nameWillIllegalCharacter);
            });

        }

        @Test
        public void testNameTooLong(){
//            Arrange
            String nameTooLong = "This is my friend named david and he loves to jump up and down all the time. He is a great friend";
//            Assert
            assertThrows(Exception.class, () -> {
                Validators.validateName(nameTooLong);
            });
        }

        @Test
        public void testNoNameEntered(){
            String noName = "";
            assertThrows(Exception.class, () -> {
                Validators.validateName(noName);
            });
        }

        @Test
        public void testEmptyNameEntered(){
            String emptyName = "    ";
            assertThrows(Exception.class, () -> {
                Validators.validateName(emptyName);
            });
        }
    }


    @Nested
    class phoneNumberValidators{

        @Test
        public void testCorrectLength(){
            // 11 is correct for 07710308733
            // 13 is correct for +447710308733
            String[] incorrectLengthNumbers = {
                    "0000000000", // 10
                    "000000000000", // 12
                    "00000000000000" // 13
            };
            for (String number: incorrectLengthNumbers){
                assertThrows(Exception.class, () -> {
                    Validators.validatePhoneNumber(number);
                });
            }
        }

        @Test
        public void testStartOfNumber() {
//            Incorrect Number
            assertThrows(Exception.class, () -> {
                Validators.validatePhoneNumber("97710308733");
            });
            try {
                // Correct Number
                String result1 = Validators.validatePhoneNumber("07710308733");
                assertEquals("07710308733", result1);

//            Correct other number type
                String result2 = Validators.validatePhoneNumber("+447710308733");
                assertEquals("+447710308733", result2);

            }catch(Exception e){
                fail("Exception should not be thrown");
            }
        }

        @Test
        public void checkAllNumbersBesidesPlus() {
            try {
                String correctNumber = "+447710308733";
                String result = Validators.validatePhoneNumber(correctNumber);
                assertEquals(correctNumber, result);
            } catch(Exception e){
                fail("Exception should not be thrown");
            }

            String incorrectNumber = "077103t8733";
            assertThrows(Exception.class, () -> {
                Validators.validatePhoneNumber(incorrectNumber);
            });
        }
    }

    @Nested
    class emailValidators{

        @Test
        public void testValidateEmail(){
            try {
                String email = "m.hutchings22@gmail.com";
                InternetAddress emailAddressExpectedResult = new InternetAddress(email);
                InternetAddress result = Validators.validateEmail(email);
                assertEquals(emailAddressExpectedResult, result);
            } catch(Exception e){
                fail("This test should have passed with Exception");
            }


        }

    }
}

