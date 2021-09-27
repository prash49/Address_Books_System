package com.bridgelabz.adressbookssystem;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    static Map<String, AddressBook> addressBook = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int EXIT = 9;

        int choice = 0;
        while (choice != EXIT) {
            System.out.println(
                    "1 : Add AddressBook\n2 : Add Contact\n3 : Edit Contact\n4 : Delete Contact\n5 : Display Contact\n6 :search\n7 :sort by name\n8 :sort  By Options\n"
                            + EXIT + " : to exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addAddressBook();
                    break;

                case 2:
                    addContact();
                    break;
                case 3:
                    editContact();

                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    displayContact();
                    break;
                case 6:
                    searchContact();
                    break;
                case 7:
                    sort();
                    break;
                case 8:
                    sortByPlace();
                    break;

            }

        }

    }

    /*
     * method to sort contacts based on city,pin,state
     */
    private static void sortByPlace() {
        System.out.println(" sort by\n1: Zip code\n2: City \n3: State ");
        Scanner m = new Scanner(System.in);
        int ch = m.nextInt();
        switch (ch) {
            case 1:
                for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
                    AddressBook obj = entry.getValue();
                    obj.sortZip();
                }
                break;
            case 2:
                for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
                    AddressBook obj = entry.getValue();
                    obj.sortCity();
                }
                break;
            case 3:
                for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
                    AddressBook obj = entry.getValue();
                    obj.sortState();
                }
                break;
        }
    }

    /*
     * method to sort contact based on names
     */
    private static void sort() {
        for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
            AddressBook obj = entry.getValue();
            obj.sort();
        }
    }

    /*
     * method to search contact based on city or state
     */

    private static void searchContact() {
        System.out.println("Enter the city or state name");
        String place = sc.nextLine();
        int count = 0;
        for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
            AddressBook obj = entry.getValue();
            count += obj.searchContact(place);
        }
        System.out.println(count + " contact found based on" + place);
    }

    /*
     * method to delete contact
     */
    private static void deleteContact() {
        System.out.println("AddressBooks Name: " + addressBook.keySet());
        System.out.println("Enter the name of address book to delete contact");
        String bookName = sc.nextLine();
        AddressBook adBook = addressBook.get(bookName);
        if (adBook != null) {
            addressBook.get(bookName).deletePerson();
        } else {
            System.out.println("AddressBook doesn't exist");
        }

    }

    /*
     * method to edit contact
     */
    private static void editContact() {
        System.out.println("AddressBooks Name: " + addressBook.keySet());
        System.out.println("Enter the name of address book to  edit");

        String bookName = sc.nextLine();
        AddressBook adBook = addressBook.get(bookName);
        if (adBook != null) {
            addressBook.get(bookName).editPerson();
        } else {
            System.out.println("AddressBook doesn't exist");
        }

    }

    /*
     * method to add new addressBook
     */
    private static void addAddressBook() {
        System.out.println("Enter the name of new address book");

        String bookName = sc.nextLine();

        AddressBook book = addressBook.get(bookName);
        if (book != null) {
            System.out.println("AddressBook with this name exists");
        } else {

            AddressBook adBook = new AddressBook(bookName);
            addressBook.put(bookName, adBook);
        }
        System.out.println("AddressBooks Name: " + addressBook.keySet());


    }

    /*
     * method to display contacts of addressBook
     */
    private static void displayContact() {
        System.out.println("AddressBooks Name: " + addressBook.keySet());
        System.out.println("Enter the name of address book to display");
        String bookName = sc.nextLine();
        AddressBook adBook = addressBook.get(bookName);

        if (adBook != null) {
            adBook.print();
        } else {
            System.out.println("Book name not found");
        }

    }

    /*
     * method to add a new contact to addressBook
     */
    private static void addContact() {
        System.out.println("AddressBooks Name: " + addressBook.keySet());
        System.out.println("Enter the name of Address book to add the contact");
        String adBook = sc.nextLine();
        AddressBook Book = addressBook.get(adBook);
        if (Book == null) {
            System.out.println("No book found");

        } else {
            addressBook.get(adBook).addContact();
        }
    }
}