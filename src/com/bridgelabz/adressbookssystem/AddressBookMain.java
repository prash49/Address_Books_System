package com.bridgelabz.adressbookssystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
    static List<Contact> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int EXIT = 6;

        int choice = 0;
        while (choice != EXIT) {

            System.out.println("1 : Add Contact\n2 : Edit Contact\n3 : Display Contact\n4: Delete Contact\n5: Add Multiple Contact\n" + EXIT + " to exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    System.out.println("enter the first name");
                    String firstName = sc.nextLine();
                    editPerson(firstName);
                    break;
                case 3:
                    displayContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    addMultipleContact();
                    break;

            }

        }

    }

    private static void addMultipleContact() {
        System.out.println("enter number of contacts to add ");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            addContact();
        }
    }

    private static void deleteContact() {
        System.out.println("enter the first name");
        String firstName = sc.next();
        Contact person = getPerson(firstName);
        if (person == null) {
            System.out.println("No contact found of that name");
        } else {
            list.remove(person);
            System.out.println(firstName + " Delete from AddressBook");
        }
    }

    private static void addContact() {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first name");
        String firstName = sc.nextLine();
        System.out.println("enter the last name");
        String lastName = sc.nextLine();
        System.out.println("enter the address");
        String address = sc.nextLine();
        System.out.println("enter the city");
        String city = sc.nextLine();
        System.out.println("enter the state");
        String state = sc.nextLine();
        System.out.println("enter the zip code");
        String zip = sc.nextLine();
        System.out.println("enter the phone Number");
        String phone = sc.nextLine();
        System.out.println("enter the email Id ");
        String email = sc.nextLine();
        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
        list.add(contact);

    }

    private static void displayContact() {
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("Contact book is empty\n");
        }

    }

    private static Contact getPerson(String name) {
        for (Contact item : list) {
            if (item.firstName.equals(name)) {
                return item;
            }

        }
        return null;

    }

    private static void editPerson(String firstname) {

        Contact person = getPerson(firstname);
        if (person == null) {
            System.out.println("No contact found of that name");
        } else {
            int choice;

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("What do you wanna edit");
                System.out.println(
                        "1 First Name\n2 Last Name\n3 Address\n4 City\n5 State\n6Zip\n7 Phone number\n8Email\n9 Exit");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("enter the first name");
                        String firstName = sc.nextLine();
                        person.firstName = firstName;
                        break;
                    case 2:
                        System.out.println("enter the last name");
                        String lastName = sc.nextLine();
                        person.lastName = lastName;
                        break;
                    case 3:
                        System.out.println("enter the address");
                        String address = sc.nextLine();
                        person.address = address;
                        break;
                    case 4:
                        System.out.println("enter the city");
                        String city = sc.nextLine();
                        person.city = city;
                        break;
                    case 5:
                        System.out.println("enter state");
                        String state = sc.nextLine();
                        person.state = state;
                        break;
                    case 6:
                        System.out.println("enter the zip code");
                        String zip = sc.nextLine();
                        person.zip = zip;
                        break;
                    case 7:
                        System.out.println("enter phone number");
                        String phone = sc.nextLine();
                        person.phoneNumber = phone;
                        break;
                    case 8:
                        System.out.println("enter email");
                        String email = sc.nextLine();
                        person.eMail = email;
                        break;
                    case 9:
                        return;
                }
            }
        }

    }


}