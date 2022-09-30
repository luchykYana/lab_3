import java.util.*;

public class TaskManager {
    static HashMap<Integer, ArrayList<Car>> cars = new HashMap<>();
    static ArrayList<Car> data;

    static void firstTask() {
        var maxSpeedSet = new HashSet<Integer>();

        if (data == null) {
            data = FileHelper.readFirstFile("firstFile.txt");
        }

        for (Car car : data) {
            maxSpeedSet.add(car.getMaxSpeed());
        }

        for (Integer i : maxSpeedSet) {
            ArrayList<Car> matchCars = new ArrayList<Car>();

            for (Car car : data) {
                if (car.getMaxSpeed() == i) {
                    matchCars.add(car);
                }
            }

            cars.put(i, matchCars);
        }

        DisplayHelper.displayFirstTask(cars);
    }

    static void secondTask() {
        HashSet<String> models = new HashSet<>();
        HashSet<String> userModels;

        for (var i : cars.keySet()) {
            for (Car car : cars.get(i)) {
                models.add(car.getModel());
            }
        }

        DisplayHelper.showMenu2(models);
        userModels = InputHelper.getModelsForDelete(models);

        System.out.println("You choose these models: " + userModels);

        for (var item : cars.keySet()) {

            cars.get(item).removeIf(c -> userModels.contains(c.getModel()));
        }

        DisplayHelper.displayFirstTask(cars);
    }

    static void thirdTask() {
        ArrayList<Car> carsFromTwoFiles = new ArrayList<>();
        ArrayList<Car> carsInRange = new ArrayList<>();

        var data1 = FileHelper.readFirstFile("firstFile.txt");
        var data2 = FileHelper.readFirstFile("secondFile.txt");

        carsFromTwoFiles.addAll(data1);
        carsFromTwoFiles.addAll(data2);

        System.out.println("Cars from two files");
        DisplayHelper.displayThirdTask(carsFromTwoFiles);

        System.out.println("Sorted cars from two files");
        carsFromTwoFiles.sort((Car car1, Car car2) -> car2.getModel().compareTo(car1.getModel()));

        DisplayHelper.displayThirdTask(carsFromTwoFiles);

        String[] range = InputHelper.priceRangeFromUser().split(",");

        for (var car : carsFromTwoFiles) {
            if (car.getPrice() > Integer.parseInt(range[0].trim()) &&
                    car.getPrice() < Integer.parseInt(range[1].trim())) {
                carsInRange.add(car);
            }
        }

        System.out.println("In your range ( " + range[0] + ", " + range[1] + " ) we found " + carsInRange.size() +
                " cars");

        DisplayHelper.displayThirdTask(carsInRange);
        InputHelper.waitBeforeMenu();
    }
}