package by.epam.yanushkevich_irina.module5.task_4.entity;

public class Treasure {

    private String name;
    private String description;
    private int price;

    public Treasure(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        if (name == null) {
            if (treasure.name != null) {
                return false;
            }
        } else if (!name.equals(treasure.name)) {
            return false;
        }
        if (description == null) {
            if (treasure.description != null) {
                return false;
            }
        } else if (!description.equals(treasure.description)) {
            return false;
        }
        return price == treasure.price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + price;
        return result;
    }

    @Override
    public String toString() {
        return name + ": " + description + ", price, $: " + price;
    }
}
