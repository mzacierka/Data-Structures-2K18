import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriverArrayListBased {
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    static ListArrayListBasedPlus list = new ListArrayListBasedPlus();
    static boolean repeat  = true;
    public static void main(String[] args) {
        String option = "";
        do {
            System.out.println("Select from the following menu: ");
            System.out.println("    1. Insert item to list.");
            System.out.println("    2. Remove item from list.");
            System.out.println("    3. Get item from list.");
            System.out.println("    4. Clear list.");
            System.out.println("    5. Print size and content of list.");
            System.out.println("    6. Reverse list.");
            System.out.println("    7. Exit program.");
            System.out.print("Make your menu selection now: \n");
            try {
                option = stdin.readLine().toString();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch(option) {
            case "1" :
                insertInto();
                break;
            case "2" :
                removeFromList();
                break;
            case "3" :
                retrieveItem();
                break;
            case "4" :
                clearList();
                break;
            case "5" :
                print();
                break;
            case "6" :
                reverseList();
                break;
            case "7" :
                kill();
                break;
            }
        } while ( repeat );
    }
    private static void kill() {
        repeat = false;
        System.out.println("Exiting program...Good Bye");
    }
    private static void reverseList() {
        if(!list.isEmpty()) {
            System.out.println("List reversed");
            list.reverse();
        }
    }
    private static void print() {
        if(!list.isEmpty()) {
            System.out.println("List of size "+ list.size() + " has the following items : " + list.toString() + ".");
        } else {
            System.out.println("List is empty");
        }
    }
    private static void clearList() {
        if(!list.isEmpty()) {
            list.removeAll();
        }
    }
    private static void retrieveItem() {
        System.out.print("Enter position to retrieve item from : ");
        try {
            int pos = Integer.parseInt(stdin.readLine().trim());
            if(pos >= 0 && pos <= list.size()) {
                System.out.println("Item " + list.get(pos) + " retrieved from position "+ pos +" in the list.");
            } else {
                System.out.println("Position specified is out of range!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void removeFromList() {
        System.out.print("Enter position to remove item from : ");
        try {
            int pos = Integer.parseInt(stdin.readLine().trim());
            if(pos < 0 || pos > list.size()-1) {
                System.out.println("Position specified is out of range!");
            } else {
                System.out.println("Item " + list.get(pos) + " removed from position " + pos + " in the list.");
                list.remove(pos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void insertInto() {
        System.out.println("You are now inserting an item into the list.");
        System.out.print("Enter item: ");
        try {
            String item = stdin.readLine().trim();
            System.out.print("Enter position to insert item in : ");
            int pos = Integer.parseInt(stdin.readLine().trim());
            if(pos < 0 || pos > list.size()) {
                System.out.println("Position specified is out of range!");
            } else {
                System.out.println("Item " + item + " inserted in position " + pos + " in the list.");
                list.add(pos, item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

