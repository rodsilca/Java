package application;

import entities.enums.OrderStatus;
import entitiess.Order;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Order order = new Order(1,new Date(), OrderStatus.PENDING_PAYMENT);

        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(order.toString());
        System.out.println(os1);
        System.out.println(os2);
    }
}
