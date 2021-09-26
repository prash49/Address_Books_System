package com.bridgelabz.adressbookssystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        List<Contact> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first name");
        String firstName = sc.nextLine();
        System.out.println("enter the last name");
        String lastName = sc.nextLine();
        System.out.println("enter the addres");
        String address = sc.nextLine();
        System.out.println("enter the city");
        String city = sc.nextLine();

        System.out.println("enter the state");
        String state = sc.nextLine();
        System.out.println("enter the zip code");
        String zip = sc.nextLine();
        System.out.println("enter the phone no");
        String phone = sc.nextLine();
        System.out.println("enter the email Id ");
        String email = sc.nextLine();

        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);

        list.add(contact);

        System.out.println(list.get(0));
    }
}

