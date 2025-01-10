package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* @author Nguyen Hoai An - CE190990
*/

public class BookManagement {
    private ArrayList<Book> listEBook = new ArrayList<>(
        Arrays.asList(
            new Book("B0001", "HTML", 2022, "Peter, John", 100),
            new Book("B0002", "C/C++", 2000, "Bobita", 90),
            new Book("B0003", "JAVA", 1999, "Jerry", 65),
            new Book("B0004", "Python", 1998, "John", 70)
        )
    );
    
    BookManagement(){
        
    }
    
    public void entryData(){
        System.out.println("----- Add new ebooks ----");
        listEBook.add(
            new Book(
                requestInput("ID"),
                requestInput("name"),
                Integer.parseInt(requestInput("year")), 
                requestInput("author"),
                Integer.parseInt(requestInput("size (kilobyte)"))
            )
        );
        System.out.println("Ebook created and added to list of ebooks successful!");
    }
    
    public void printData(){
        System.out.println(
            "------------------------ BOOK MANAGEMENT -------------------------"
        );
        
        printList(listEBook);
    }
    
    public void printList(ArrayList<Book> list){
        System.out.println(
            "| No. | ID    | Name              | Year | Author        | Size  |\n"
            + "+-----+-------+-------------------+------+---------------+-------+"
        );
        
        int iItem = 0;
        for(Book item : list){
            System.out.printf("| %-4s", ++iItem);
            item.showInfo();
        }
    }
    
    public void sort(){
        ArrayList<Book> bookshelf_copy = listEBook; // Avoid side effect
        for(Book item : listEBook){
            for(int i = 0; i < bookshelf_copy.size() - 1; i++){
                if(bookshelf_copy.get(i).getSize() > bookshelf_copy.get(i + 1).getSize()){
                    Book temp = bookshelf_copy.get(i);
                    bookshelf_copy.set(i, bookshelf_copy.get(i + 1));
                    bookshelf_copy.set(i + 1, temp);
                }
            }
        }
        printList(bookshelf_copy);
    }
    
    public int searchBookByID(String ID){
        for(int i = 0; i < listEBook.size(); i++)
            if(listEBook.get(i).getID().equalsIgnoreCase(ID))
                return i;
            
        return -1;
    }
    
    public Book searchBookObjectByID(String ID){
        for(Book item : listEBook){
            if(item.getID().equalsIgnoreCase(ID))
                return item;
        }
        return new Book();
    }
    
    public ArrayList<Book> biggestSize(){
        
        ArrayList<Book> largest = new ArrayList<>();
        
        int largestSize = -1;
        for(Book item : listEBook)
            if(item.getSize() > largestSize)
                largestSize = item.getSize();
        
        for(Book item : listEBook)
            if(item.getSize() == largestSize)
                largest.add(item);
        
        return largest;
    }
        
    public String requestInput(String field){
        String input;
        Scanner keyboard = new Scanner(System.in);
        
        while(true){
            System.out.print("Input " + field + ": ");
            input = keyboard.nextLine();
            
            if(!input.isEmpty()){
                if(field.equalsIgnoreCase("ID")){
                    if(input.length() == 5){
                        boolean isDuplicated = false;
                        for(Book item : listEBook){
                            if(item.getID().equalsIgnoreCase(input)){
                                isDuplicated = true;
                                break;
                            }
                        }
                        if(isDuplicated){
                            System.out.println("ID duplicated");
                        } else {
                            return input;
                        }
                    } else
                        System.out.println("ID must be exactly 5 characters");
                } else if(field.equalsIgnoreCase("name") || field.equalsIgnoreCase("author")){
                    return input;
                } else if(field.equalsIgnoreCase("year")){
                    int asNumber = Integer.parseInt(input);
                    if(asNumber >= 1900 && asNumber <= 2024)
                        return input;
                    else
                        System.out.println("Year must be in range 1900 to 2024");
                } else if(field.equalsIgnoreCase("size (kilobyte)")){
                    int asNumber = Integer.parseInt(input);
                    if(asNumber > 0)
                        return input;
                    else
                        System.out.println("Size must be greater than 0");
                }
            } else
                System.out.println(field + " must be not empty");
        }
    }
}
