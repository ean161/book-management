package main;

/**
* @author Nguyen Hoai An - CE190990
*/

public class Book {
    private String ID;
    private String name;
    private int year;
    private String author;
    private int size;
    
    // Override
    Book(){
        
    }
    
    Book(String ID, String name, int year, String author, int size){
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.author = author;
        this.size = size;
    }
    
    // Setter, getter
    public String getID(){
        return this.ID;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getYear(){
        return this.year;
    }
    
    public String getAuthor(){
        return this.author;
    }
    
    public int getSize(){
        return this.size;
    }
    
    
    public void setID(String ID){
        this.ID = ID;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public void setSize(int size){
        this.size = size;
    }
    
    public void showInfo(){
        System.out.printf("| %-6s| %-18s| %-5d| %-14s| %-6s|\n+-----+-------+-------------------+------+---------------+-------+\n", this.ID, this.name, this.year, this.author, String.format("%dKB", this.size));
    }
}
