package by.epam.yanushkevich_irina.module5.task_2;

public class Main {

    /* 2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
          нескольких товаров. */

    public static void main(String[] args) {

        Payment payment = new Payment();

        payment.addPurchase(payment.new Purchase("Eggs, 10 pcs.", 5, 2));
        payment.addPurchase(payment.new Purchase("Milk, 1 l.", 3, 3));
        payment.addPurchase(payment.new Purchase("Bread, 500 g.", 4, 1));

        payment.makePayment(payment.getPurchases());
    }
}
