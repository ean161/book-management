package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* @author Nguyen Hoai An - CE190990
*/

public class Main {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        BookManagement bookshelf = new BookManagement();
        String choice;
                    
        do {
            System.out.print(
                "----- BOOK MANAGEMENT -----\n"
                + "1. Adds new book.\n"
                + "2. Shows all books.\n"
                + "3. The biggest size book.\n"
                + "4. Search a book by ID.\n"
                + "5. Sort the list of books ascending by size.\n"
                + "6. Quit.\n"
                + "Please select a function: "
            );
            choice = keyboard.nextLine();
            
            switch(choice){
                case "1":
                    bookshelf.entryData();
                    break;
                case "2":
                    bookshelf.printData();
                    break;
                case "3":
                    bookshelf.printList(bookshelf.biggestSize());
                    break;
                case "4":
                    System.out.print("Please enter book's ID to search: ");
                    String target = keyboard.nextLine();
                    System.out.print("Search results: ");
                    
                    if(bookshelf.searchBookByID(target) == -1){
                        System.out.println("Not found!");
                        break;
                    } else
                        System.out.print("\n");
                    
                    bookshelf.printList(new ArrayList<>(
                        Arrays.asList(
                            bookshelf.searchBookObjectByID(target)
                        )
                    ));
                    break;
                case "5":
                    bookshelf.sort();
                    break;
                case "6":
                    System.out.println(
                        "THANK FOR USING OUR APPLICATION!\n"
                        + "SEE YOU AGAIN|"
                    );
                    break;
                default:
                    System.out.println("The function of application must be from 1 to 6!");
                    break;
            }
        } while(!choice.equalsIgnoreCase("6"));
        
    }
}
