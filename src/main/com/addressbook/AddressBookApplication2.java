package com.addressbook;

import com.addressbook.dao.CompleteUserBuilder;
import com.addressbook.entity.User;

public class AddressBookApplication2 {

    public static void main(String[] args) {


        User user = CompleteUserBuilder.getUserWithContent("Ed", "Wright");

        user.getAddressBookArrayList().get(0).printAddressBook();
        user.getAddressBookArrayList().get(1).printAddressBook();
    }
}
