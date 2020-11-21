import java.io.*;
import java.util.*;
/**  Program for running PhoneDirectory class
 *  @author Phillip M
 *  @version 1.0
 *  @since   10/20/2020
 * */

public class proj3 {
    public static void main(String [] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        PhoneDirectory pd = new PhoneDirectory();
        while(true) {
            System.out.println("What do you want to do (type a number): \n" +
                    "        1. Load a previously saved phone directory from file\n" +
                    "        2. Add or change an entry\n" +
                    "        3. Remove an entry\n" +
                    "        4. Search for an entry\n" +
                    "        5. Display all entries\n" +
                    "        6. Save the current phone directory to a file\n" +
                    "        7. Quit the program");
            int menu = sc.nextInt();
            sc.nextLine();
            try {
                switch(menu) {

                    case 1:
                        System.out.println("Enter file name: ");
                        pd = load(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter Name,Number: ");
                        String entry = sc.nextLine();
                        StringTokenizer st = new StringTokenizer(entry, ",");
                        String name = st.nextToken();
                        String number = st.nextToken();
                        pd.addOrChangeEntry(name, number);
                        break;
                    case 3:
                        System.out.println("Enter Name to remove: ");
                        pd.removeEntry(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter Name to search: ");
                        DirectoryEntry et = pd.searchEntry(sc.nextLine());
                        if(et != null)
                            System.out.println(et);
                        else
                            System.out.println("Not in File");
                        break;
                    case 5:
                        pd.displayAllEntries();
                        break;
                    case 6:
                        System.out.println("Enter fileName to save: ");
                        save(pd, sc.nextLine());
                        break;
                    case 7:
                        System.exit(0);
                }
            } catch (Exception e) {
                    System.out.println("enter Valid input");

            }
        }
    }
    public static PhoneDirectory load(String fileName)throws IOException{
        PhoneDirectory pd = new PhoneDirectory();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String inputLine = null;
        while((inputLine = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(inputLine,",");
            pd.addOrChangeEntry(st.nextToken(),st.nextToken());
        }
        return pd;
    }
    public static void save(PhoneDirectory pd, String fileName) throws IOException {
        try {
            PrintWriter pr = new PrintWriter(new FileOutputStream(fileName));
//            pr.println("test");
            for (DirectoryEntry entry : pd.getTheDirectory()) {
                // Name,Number on each line
                pr.println(entry.getName() + "," +entry.getNumber());
            }
            pr.flush();
            pr.close();

        }catch (IOException e){
            System.out.println(e);
        }




    }
}
