public class Menu {
    static void menu() {
        DisplayHelper.setMenuItems();

        while (true) {
            DisplayHelper.showMenu();
            var typing = InputHelper.catchUserInput();

            switch (typing) {
                case "1" -> TaskManager.firstTask();
                case "2" -> TaskManager.secondTask();
                case "3" -> TaskManager.thirdTask();
                case "4" -> {
                    System.out.println("Exit");
                    return;
                }
                default -> System.out.println("Not correct. Try again");
            }
        }
    }
}
