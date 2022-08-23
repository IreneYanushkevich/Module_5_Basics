package by.epam.yanushkevich_irina.module5.task_4.entity;

import by.epam.yanushkevich_irina.module5.task_4.logic.DragonCaveLogic;

import java.util.List;

public class DragonCave {

    private String name;
    private int numOfTreasure;
    private List<Treasure> treasures;
    private final DragonCaveLogic caveLogic;

    {
        caveLogic = new DragonCaveLogic();
    }

    public DragonCave(String name, int numOfTreasure) {
        this.name = name;
        this.numOfTreasure = numOfTreasure;
        treasures = caveLogic.fillCave(numOfTreasure);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public int getNumOfTreasure() {
        return numOfTreasure;
    }

    public void setNumOfTreasure(int numOfTreasure) {
        this.numOfTreasure = numOfTreasure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DragonCave that = (DragonCave) o;
        if (name == null) {
            if (that.name != null) {
                return false;
            }
        } else if (!name.equals(that.name)) {
            return false;
        }
        if (treasures == null) {
            if (that.treasures != null) {
                return false;
            }
        } else if (!treasures.equals(that.treasures)) {
            return false;
        }
        return numOfTreasure == that.numOfTreasure;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((treasures == null) ? 0 : treasures.hashCode());
        result = prime * result + numOfTreasure;
        return result;
    }

    @Override
    public String toString() {
        return "Welcome to the " + name + "'s Cave, which contains " + numOfTreasure + " treasures:\n" + treasures;
    }
}
