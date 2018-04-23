import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 02/07/18
 * Submitted:  02/07/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.02.07
 */
public class Driver {
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    static ListCDLSBased list = new ListCDLSBased();

    public static void main(String[] args) {
        boolean repeat = true;
        String option = "";
        System.out.print("Select from the following menu:\n" + "\t1. Insert item to list.\n"
                         + "\t2. Remove item from list.\n" + "\t3. Get item from list.\n" + "\t4. Clear list.\n"
                         + "\t5. Print size and content of list.\n"
                         + "\t6. Reverse the list.\n" + "\t7. Exit program.\n");
        
        do {

            System.out.print("Make your selection now: ");
            try {
                option = stdin.readLine().toString();
                System.out.println(option);
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (option) {
            case "1":
                addItem(list);
                break;
            case "2":
                removeItem(list);
                break;
            case "3":
                getItem(list);
                break;
            case "4":
                removeAll(list);
                break;
            case "5":
                sizeContent(list);
                break;
            case "6":
                reverse(list);
                break;
            case "7": {
                repeat = false;
                System.out.println("Exiting program...Good Bye");
            }
            break;
            }
        } while (repeat);
    }

    private static void reverse(ListCDLSBased listS) {
        Object[] reversedList = new Object[listS.size()];
        if (listS.isEmpty()) {
            System.out.println("List is empty.. nothing to reverse!");
        } else {
            for (int i = listS.size() - 1, j = 0; i >= 0 || j < listS.size(); i--, j++) {
                reversedList[j] = listS.get(i);
            }
            listS.removeAll();
            for (int z = 0; z < reversedList.length; z++) {
                listS.add(z, reversedList[z]);
            }
            System.out.println("List has been reversed.");
        }
    }

    private static void sizeContent(ListCDLSBased listS) {
        if (!listS.isEmpty()) {
            System.out.println("\tList of size " + listS.size() + " has the following items : " + listS.toString() + ".");
        } else {
            System.out.println("List is empty");
        }
    }

    private static void removeAll(ListCDLSBased listS) {
        if (!listS.isEmpty()) {
            listS.removeAll();
        }
    }

    private static void getItem(ListCDLSBased listS) {
        System.out.print("Enter position to retrieve item from : ");
        try {
            int pos = Integer.parseInt(stdin.readLine().trim());
            if (pos >= 0 && pos <= list.size()) {
                System.out.println("Item " + listS.get(pos) + " retrieved from position " + pos + " in the list.");
            } else {
                System.out.println("Position specified is out of range!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void removeItem(ListCDLSBased listS) {
        System.out.print("Enter position to remove item from : ");
        try {
            int pos = Integer.parseInt(stdin.readLine().trim());
            if (pos < 0 || pos > list.size() - 1) {
                System.out.println("Position specified is out of range!");
            } else {
                System.out.println("Item " + listS.get(pos) + " removed from position " + pos + " in the list.");
                listS.remove(pos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void addItem(ListCDLSBased listS) {
        System.out.println("You are now inserting an item into the list.");
        System.out.print("\tEnter item: ");
        try {
            String item = stdin.readLine().trim();
            System.out.print("\tEnter position to insert item in : ");
            int pos = Integer.parseInt(stdin.readLine().trim());
            if (pos < 0 || pos > list.size()) {
                System.out.println("Position specified is out of range!");
            } else {
                System.out.println("Item " + item + " inserted in position " + pos + " in the list.");
                listS.add(pos, item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
