import java.util.Scanner;
import java.util.ArrayList;
public class ListMaker
{
    private static ArrayList<String> myList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        boolean done = false;
        String cmd = " ";
        do {
            displayList();
            cmd = SafeInput.getRegExString(in, "A - Add, D - Delete, I - Insert, P - Print, Q - Quit", "[AaDdIiPpQq]");
            cmd = cmd.toUpperCase();
            switch (cmd) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    done = quit();
                    break;
            }
        } while (!done);
    }
    private static void displayList()
    {
        System.out.println("\n--- Your List ---");
        if (myList.size() == 0) {
            System.out.println("(The list is empty)");
        } else {
            for (int i = 0; i < myList.size(); i++) {
                System.out.println((i + 1) + ". " + myList.get(i));
            }
        }
        System.out.println("-----------------");
    }
    private static void addItem()
    {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add");
        myList.add(item);
    }
    private static void deleteItem()
    {
        if (myList.size() == 0) {
            System.out.println("The list is empty, so there is nothing to delete");
            return;
        }
        int num = SafeInput.getRangedInt(in, "Enter the number of the item to delete", 1, myList.size());
        myList.remove(num - 1);
    }
    private static void insertItem()
    {
        int num = SafeInput.getRangedInt(in, "Enter the position to insert at", 1, myList.size() + 1);
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        myList.add(num - 1, item);
    }
    private static boolean quit()
    {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit");
    }
}
