package com.addressbook.validators;

import com.addressbook.validator.Validators;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
