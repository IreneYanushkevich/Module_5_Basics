package by.epam.yanushkevich_irina.module5.task_2;

import java.util.ArrayList;
import java.util.List;

public class Payment {

    private List<Purchase> purchases;

    public Payment() {
        purchases = new ArrayList<>();
    }

    public class Purchase {

        private String name;
        private int price;
        private int quantity;

        Purchase(String name, int price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Purchase purchase = (Purchase) o;
            if (name == null) {
                if (purchase.name != null) {
                    return false;
                }
            } else if (!name.equals(purchase.name)) {
                return false;
            }
            return price == purchase.price && quantity == purchase.quantity;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + price;
            result = prime * result + quantity;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public String toString() {
            return "Purchase: " + name + ", price: " + price + ", quantity: " + quantity + "\n";
        }
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        if (purchases == null) {
            return payment.purchases == null;
        } else return purchases.equals(payment.purchases);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + ((purchases == null) ? 0 : purchases.hashCode());
    }

    @Override
    public String toString() {
        return "Payment expected. Shopping list:\n" + purchases;
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public void deletePurchase(Purchase purchase) {
        purchases.remove(purchase);
    }

    public int calculateTotalSum(List<Purchase> purchases) {
        int sum = 0;
        for (Purchase p : purchases) {
            sum += p.getPrice() * p.getQuantity();
        }
        return sum;
    }

    public void makePayment(List<Purchase> purchases) {
        for (Purchase p : purchases) {
            System.out.println(p.getName() + ": " + p.getPrice() + "$ * " + p.getQuantity() + "pcs. = " + p.getPrice() * p.getQuantity() + "$");
        }
        System.out.println("You have made a purchase for the total = " + calculateTotalSum(purchases) + "$. Thank you!");
    }
}
