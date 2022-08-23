package by.epam.yanushkevich_irina.module5.task_4.entity;

import by.epam.yanushkevich_irina.module5.task_4.logic.MenuLogic;

public class Menu {

    private final MenuLogic menuLogic = new MenuLogic();

    public void activateMenu() {
        int choice;
        boolean isFinish = false;
        while (!isFinish) {
            menuLogic.printMenu();
            choice = menuLogic.getAnswer();
            isFinish = menuLogic.exploreTheCave(choice);
        }
    }
}
