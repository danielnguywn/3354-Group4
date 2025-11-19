import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Objects;

public class main{
    public static void addContact(ArrayList<contact> c){
        //gets info about the contact to be added
        Scanner myObj = new Scanner(System.in);
        String name;
        String email;
        String address;
        String notes;
        String input;
        String yes;
        String no;
        String phoneNumber;
        boolean blocked;

        //questions for user
        System.out.println("What is the name of the contact? Type n/a if not applicable.");
        name = myObj.nextLine();
        System.out.println("What is the email of the contact? Type n/a if not applicable.");
        email = myObj.nextLine();
        System.out.println("What is the addres of the contact? Type n/a if not applicable.");
        address = myObj.nextLine();
        System.out.println("Are there any notes you want to add for this contact? Type n/a if not applicable.");
        notes = myObj.nextLine();
        System.out.println("What is the phone number of the contact? Type n/a if not applicable.");
        phoneNumber = myObj.nextLine();
        System.out.println("Would you like to block this number? Type Yes or No.");
        input = myObj.nextLine();
        yes = "yes";
        no = "no";

        //stuff for whether to block the contact or not
        if(input.equalsIgnoreCase(yes)){
            blocked = true;
            System.out.println("The contact is blocked");
        }else if(input.equalsIgnoreCase(no)){
            blocked = false;
            System.out.println("The contact isn't blocked");
        }else{
            blocked = false;
        }
        //add contact to arraylist
        contact ac = new contact(name, email, address, notes, phoneNumber, blocked);
        c.add(ac);
    }
    
    public static void removeContact(ArrayList<contact> c){
        //this removes a contact based of the name provided.
        int index;
        String input;
        //calls search to search for contact to delete
        index = searchContacts(c);
        System.out.println("The name of the contact to be removed is");
        System.out.println(c.get(index).name);
        System.out.println("Would you like to remove this contact?");
        Scanner myObj = new Scanner(System.in);
        input = myObj.nextLine();
        //confirms deletion
        if(input.equalsIgnoreCase("yes")){
            c.remove(index);
            System.out.println("Removal successful");
        }else{
            System.out.println("Removal cancled");
        }
    }

    public static void editContact(ArrayList<contact> c){
        //edits contact based off name provided
        int index;
        String input;
        Scanner myObj = new Scanner(System.in);
        //calls search to search for contact to edit
        index = searchContacts(c);
        System.out.println("The name of the contact to be edited is: ");
        System.out.println(c.get(index).name);
        System.out.println("What part of the contact would you like to edit?");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Address");
        System.out.println("4. Notes");
        System.out.println("5. Phone number");
        System.out.println("6. Blocked");
        input = myObj.nextLine();
        //edit aspects of the contact object
        if(input.equalsIgnoreCase("1")){
            System.out.println("The current name of the contact is: ");
            System.out.println(c.get(index).name);
            System.out.println("What would you like the name to be?");
            input = myObj.nextLine();
            c.get(index).name = input;
        }else if(input.equalsIgnoreCase("2")){
            System.out.println("The current email of the contact is: ");
            System.out.println(c.get(index).email);
            System.out.println("What would you like the email to be?");
            input = myObj.nextLine();
            c.get(index).email = input;
        }else if(input.equalsIgnoreCase("3")){
            System.out.println("The current address of the contact is: ");
            System.out.println(c.get(index).address);
            System.out.println("What would you like the address to be?");
            input = myObj.nextLine();
            c.get(index).address = input;
        }else if(input.equalsIgnoreCase("4")){
            System.out.println("The current notes on the contact is: ");
            System.out.println(c.get(index).notes);
            System.out.println("What would you like the notes to be?");
            input = myObj.nextLine();
            c.get(index).notes = input;
        }else if(input.equalsIgnoreCase("5")){
            System.out.println("The current phone number of the contact is: ");
            System.out.println(c.get(index).phoneNumber);
            System.out.println("What would you like the phone number to be?");
            input = myObj.nextLine();
            c.get(index).phoneNumber = input;
        }else if(input.equalsIgnoreCase("6")){
            System.out.println("Is this contact blocked?");
            System.out.println(c.get(index).blocked);
            System.out.println("Would you like to change this?");
            input = myObj.nextLine();
            if(input.equalsIgnoreCase("Yes")){
                if(c.get(index).blocked == true){
                    c.get(index).blocked = false;
                }else{
                    c.get(index).blocked = true;
                }
            }
        }
    }
    
    public static int searchContacts(ArrayList<contact> c){
        //searches for contact based off name. returns index name was found at.
        System.out.println("What is the name of the contact you want to search for: ");
        String input;
        Scanner myObj = new Scanner(System.in);
        input = myObj.nextLine();
        for(int i = 0; i<c.size(); i++){
            if(c.get(i).name.equalsIgnoreCase(input)){
                return i;
            }
        }
        return 0;
    }

    public static void userInput(ArrayList<contact> c){
        boolean keepGoing = true;
        String input;
        while(keepGoing==true){
            System.out.println("What would you like to do?");
            System.out.println("1. Add contact");
            System.out.println("2. remove contact");
            System.out.println("3. Edit contact");
            System.out.println("4. Search for contact");
            System.out.println("9. Exit");


            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter your choice: ");

            input = myObj.nextLine();
            if(input.equalsIgnoreCase("1")){
                addContact(c);
            }else if(input.equalsIgnoreCase("2")){
                removeContact(c);
            }else if(input.equalsIgnoreCase("3")){
                editContact(c);
            }else if(input=="4"){
                searchContacts(c);
            }else if(input.equalsIgnoreCase("9")){
                keepGoing = false;
                ///the following are testing outputs
                System.out.println("Printing the second contact info rn");
                System.out.println("Name: " + c.get(1).name);
                System.out.println("Email: " + c.get(1).email);
                System.out.println("Address: " + c.get(1).address);
                System.out.println("Notes: " + c.get(1).notes);
                System.out.println("Phone number: " + c.get(1).phoneNumber);
                System.out.println("Number blocked: " + c.get(1).blocked);
            }
            //these are also testing outpuyts
            System.out.println("Printing the contact info rn");
            System.out.println("Name: " + c.get(0).name);
            System.out.println("Email: " + c.get(0).email);
            System.out.println("Address: " + c.get(0).address);
            System.out.println("Notes: " + c.get(0).notes);
            System.out.println("Phone number: " + c.get(0).phoneNumber);
            System.out.println("Number blocked: " + c.get(0).blocked);
        }
    }
    public static void main(String[] args){
        ArrayList<contact> contacts = new ArrayList<contact>();
        String input;
        System.out.println("Welcome to smart contacts");
        userInput(contacts);
    }
}