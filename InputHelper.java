import java.util.HashSet;
import java.util.Scanner;

public class InputHelper {
    static String catchUserInput() {
        Scanner myObj = new Scanner(System.in);

        return myObj.nextLine();
    }

    static int geyNumberOfElements() {
        Scanner myObj = new Scanner(System.in);

        int i = 1;

        do {
            System.out.println("Enter number of elements in each List. For example: 1, 2, 3, ..., 20");

            i = myObj.nextInt();

        } while (i <= 0 || i >= 20);

        return i;
    }

    static HashSet<String> getModelsForDelete(HashSet<String> models) {
        Scanner myObj = new Scanner(System.in);
        HashSet<String> userModels = new HashSet<>();

        String[] numbers = myObj.nextLine().split(",");

        int index = 1;
        for (var model : models) {
            for (var num : numbers) {
                if (Integer.parseInt(num.trim()) == index) {
                    userModels.add(model);
                }
            }
            index++;
        }

        return userModels;
    }

    static String priceRangeFromUser() {
        System.out.println("Enter two numbers for price range. For example: 2000, 3000");

        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }

    static void waitBeforeMenu() {
        System.out.println("Press any key and go to menu.");

        Scanner myObj = new Scanner(System.in);
        myObj.nextLine();
    }
}
