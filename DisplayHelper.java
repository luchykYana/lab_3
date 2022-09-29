import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DisplayHelper {
    static ArrayList<String> menuItems = new ArrayList<String>();

    static void setMenuItems() {
        menuItems.add("1. Task 1");
        menuItems.add("2. Task 2");
        menuItems.add("3. Task 3");
        menuItems.add("4. Exit");
    }

    static void showMenu() {
        System.out.println("-------- Menu --------");
        System.out.println(menuItems.get(0));
        System.out.println(menuItems.get(1));
        System.out.println(menuItems.get(2));
        System.out.println(menuItems.get(3));
        System.out.println("----------------------");
        System.out.println("Please, print 1, 2 or 3 for program working or print 4 for exit program!\n");
    }

    static void showMenu2(HashSet<String> models) {
        System.out.println("-------- Delete cars --------");

        int i = 1;
        for (var model : models) {
            System.out.println(i + ". " + model);
            i++;
        }

        System.out.println("-----------------------------");
        System.out.println("Please, choose model of cars, which you want to delete. For example: 1, 3, 6.\n");
    }

    static void displayFirstTask(HashMap<Integer, ArrayList<Car>> cars) {
        int count = InputHelper.geyNumberOfElements();

        for (var i : cars.keySet()) {
            System.out.println("Max speed: " + i + ": Cars [");

            int p = 0;
            for (var j : cars.get(i)) {
                if (p < count)
                    System.out.println("\t\t\t\t\t\t" + j);

                p++;
            }

            System.out.println("\t\t\t\t\t ]");
        }

        InputHelper.waitBeforeMenu();
    }

    static void displayThirdTask(ArrayList<Car> cars) {
        for (var car : cars) {
            System.out.println(car);
        }

        System.out.println();
    }
}
