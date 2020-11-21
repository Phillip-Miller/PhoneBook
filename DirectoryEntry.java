/**  DirectoryEntry class with support for name and number both  as a string
 *  @author Phillip M
 *  @version 1.0
 *  @since   10/20/2020
 * */
public class DirectoryEntry {
    String name;
    String number;

    public DirectoryEntry(){
        this.name = null;
        this.number = null;    }
    public DirectoryEntry(String name, String number){
        this.name = name;
        this.number = number;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public String getName(){
        return this.name ;
    }
    public String getNumber(){
        return this.number ;
    }

    public String toString(){
        String entry = "Entry: " + name + " " + number + " ";
        return entry;
    }
    public boolean equals(DirectoryEntry other){
        return this.name.equalsIgnoreCase(other.name) && this.number.equals(other.number);
    }
    }