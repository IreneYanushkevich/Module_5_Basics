package by.epam.yanushkevich_irina.module5.task_4.logic;

import by.epam.yanushkevich_irina.module5.task_4.entity.Treasure;
import by.epam.yanushkevich_irina.module5.task_4.main.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuLogic {

    private final Scanner scanner = new Scanner(System.in);

    public void printMenu() {

        System.out.println("Choose, what you want to do in the dragon's Cave:");
        System.out.println("1 - Viewing all the treasures in the cave");
        System.out.println("2 - Choosing the most expensive treasure");
        System.out.println("3 - Selection of treasures for a given amount");
        System.out.println("0 - Exit the cave");
    }

    public int getAnswer() {

        int answer;

        try {
            answer = Integer.parseInt(scanner.nextLine());
            if (answer < 0 || answer > 3) {
                System.out.println("You can choose only 1, 2, 3 or 0!");
            } else {
                return answer;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.");
        }
        return -1;
    }

    public boolean exploreTheCave(int answer) {

        DragonCaveLogic caveLogic = new DragonCaveLogic();

        switch (answer) {
            case 1 -> caveLogic.showAllTreasures();
            case 2 -> caveLogic.findMostExpensiveTreasure();
            case 3 -> {
                int sum = askSum();
                caveLogic.selectTreasuresForAmount(sum, Main.lilyCave.getTreasures(), new ArrayList<>());
            }
            case 0 -> {
                System.out.println("Good bye!");
                return true;
            }
        }
        return false;
    }

    int askSum() {

        boolean result = false;
        int sum = 0;
        int totalValue = findCostAllTreasures();

        while (!result) {

            try {
                System.out.println("All treasures in the cave are worth " + totalValue + "$." +
                        "Enter the amount of money that you are ready to spend on treasures >>>> ");
                sum = Integer.parseInt(scanner.nextLine());
                if (sum <= 0) {
                    System.out.println("It's impossible. Only positive value.");
                } else if (sum > totalValue) {
                    System.out.println("You are too rich! All treasures in the cave are worth " + totalValue + "$.");
                    System.out.println("The dragon won't let you take everything. Please enter a lower amount.");
                } else {
                    result = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Illegal value. Try again.");
            }
        }
        return sum;
    }

    private int findCostAllTreasures() {

        int sum = 0;

        for (Treasure t : Main.lilyCave.getTreasures()) {
            sum += t.getPrice();
        }
        return sum;
    }
}
