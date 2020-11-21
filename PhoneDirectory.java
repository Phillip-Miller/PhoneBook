import java.util.ArrayList;
/**  Program for maintains a phone directory
 * @author Phillip M
 * @version 1.0
 * @since   10/20/2020
 * */
public class PhoneDirectory {
    private ArrayList<DirectoryEntry> theDirectory;

    public PhoneDirectory(){
        theDirectory = new ArrayList<DirectoryEntry>();
    }

    public PhoneDirectory(ArrayList<DirectoryEntry> pd){
        theDirectory = pd;
    }
    public String addOrChangeEntry(String name, String number) {
        String old = "";
        try {
            for (DirectoryEntry entry : theDirectory) {
                if (entry.getName().equals(name)) {
                    //there is a match
                    old = entry.getNumber();
                    entry.setNumber(number);
                    return old;
                }
            }
            theDirectory.add(new DirectoryEntry(name, number));
            return null; //directory entry was added
        } catch (NullPointerException e) {
            theDirectory.add(new DirectoryEntry(name, number));
            return null; //directory entry was added
        }
    }


    // add an entry to directory or change an existing entry; return the old number or null if it is a
// new entry
    public DirectoryEntry searchEntry(String name) {

        // search the entry referenced by name; return the entry searched or null if there is no entry
        // for name
        for (DirectoryEntry entry : theDirectory) {
            if (entry.getName().equalsIgnoreCase(name))
                return entry;
        }
        return null;
    }
    public DirectoryEntry removeEntry(String name){
        // remove the entry referenced by name; return the entry removed or null if there is no entry
        // for name
        for (DirectoryEntry entry : theDirectory) {
            if (entry.getName().equalsIgnoreCase(name)){
                theDirectory.remove(entry); //might throw error check it
                return entry;
            }
        }
        return null;
    }

    public void displayAllEntries(){
        // display all entries in a nice and readable format
        for (DirectoryEntry entry : theDirectory) {
            System.out.println(entry);
        }
    }
    public ArrayList<DirectoryEntry> getTheDirectory(){
        return theDirectory;
    }
}

