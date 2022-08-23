package by.epam.yanushkevich_irina.module5.task_4.logic;

import by.epam.yanushkevich_irina.module5.task_4.entity.Treasure;
import by.epam.yanushkevich_irina.module5.task_4.main.Main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DragonCaveLogic {

    private final Scanner scanner = new Scanner(System.in);

    public List<Treasure> fillCave(int num) {

        List<Treasure> treasures = new ArrayList<>();

        try {
            String path = "C:\\Users\\Irene\\IdeaProjects\\Module5\\src\\by\\epam\\yanushkevich_irina\\module5\\task_4\\data\\Treasures.txt";
            FileReader fileReader = new FileReader(path);
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine() && num-- > 0) {
                String[] oneTreasure = scanner.nextLine().split(" - ");
                String trName = oneTreasure[0];
                String trDescription = oneTreasure[1];
                int trPrice = Integer.parseInt(oneTreasure[2]);
                treasures.add(new Treasure(trName, trDescription, trPrice));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
        return treasures;
    }

    public void showAllTreasures() {

        int id = 1;

        for (Treasure t : Main.lilyCave.getTreasures()) {
            System.out.println(id++ + ". " + t);
        }
    }

    public void findMostExpensiveTreasure() {

        int max = 0;
        int id = 0;

        for (Treasure t : Main.lilyCave.getTreasures()) {
            if (t.getPrice() > max) {
                max = t.getPrice();
                id = Main.lilyCave.getTreasures().indexOf(t);
            }
        }
        System.out.println("The most expensive treasure is:\n" + Main.lilyCave.getTreasures().get(id));
    }

    public void selectTreasuresForAmount(int sum, List<Treasure> tr, List<Treasure> basket) {

        List<Treasure> update = new ArrayList<>(tr);
        List<Treasure> tresForChoice = new ArrayList<>();

        for (Treasure t : update) {
            if (t.getPrice() <= sum) {
                tresForChoice.add(t);
            }
        }
        showAvailable(tresForChoice);
        addToBasket(tresForChoice, sum, basket);
    }

    private void showAvailable(List<Treasure> availTres) {

        int id = 1;

        System.out.println("Treasures available to you:");

        for (Treasure t : availTres) {
            System.out.println(id++ + ". " + t);
        }
        System.out.println("0. I didn't find anything interesting or I want change amount of money for purchasing.");
    }

    private void addToBasket(List<Treasure> tres, int sum, List<Treasure> basket) {

        Treasure chosen;
        int change;

        boolean result = false;
        int position = 0;
        int cheapest = findCheapest(tres);

        while (!result) {
            try {
                System.out.println("Enter the number of the treasure for purchase and press Enter >>>>");
                position = Integer.parseInt(scanner.nextLine());
                if (position > tres.size() || position < 0) {
                    System.out.println("It's impossible. Number must be from 0 " + " to " + tres.size());
                } else if (position == 0) {
                    return;
                } else {
                    result = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Illegal value. Try again.");
            }
        }
        chosen = tres.get(position - 1);
        change = sum - chosen.getPrice();

        basket.add(chosen);
        tres.remove(chosen);

        if (change < cheapest) {
            System.out.println("You can't choose anything else. Money is not enough. Your change equals " + change + "$.");
            printBasket(basket);
        } else {
            selectTreasuresForAmount(change, tres, basket);
        }
    }

    private int findCheapest(List<Treasure> treasures) {

        int min = Integer.MAX_VALUE;

        for (Treasure t : treasures) {
            if (t.getPrice() < min) {
                min = t.getPrice();
            }
        }
        return min;
    }

    private void printBasket(List<Treasure> basket) {
        System.out.println("List of treasures you have chosen:");
        for (Treasure t : basket) {
            System.out.println((basket.indexOf(t) + 1) + ". " + t);
        }
        buyBasket();
    }

    private void buyBasket() {
        boolean result = false;
        int choice;
        while (!result) {
            try {
                System.out.println("What do you want to do now? Press: 1 - buy it or 0 - back to menu.");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 1 || choice < 0) {
                    System.out.println("You can choose only 1 or 0!");
                } else if (choice == 1) {
                    System.out.println("Congratulations on your purchase and thank you!");
                    result = true;
                } else {
                    result = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}



