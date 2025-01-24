package org.example.view;

import org.example.entities.Client;
import org.example.entities.Order;
import org.example.entities.OrderItem;
import org.example.entities.Product;
import org.example.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter Client Data: ");
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Email: ");
        String email = s.nextLine();
        System.out.print("Birth date DD/MM/YYYY: ");
        Date birth = sdf.parse(s.next());

        Order order = new Order(OrderStatus.PROCESSING,new Client(name, email, birth));
        String date = s.nextLine();

        System.out.print("How many items to this order? ");
        int qntItens = s.nextInt();
        s.nextLine();
        System.out.println("Enter order data:");
        for(int i = 0; i<qntItens; i++){
            System.out.print("Produtc name: ");
            String productName = s.nextLine();
            System.out.print("Product Price: ");
            double productPrice = s.nextDouble();
            s.nextLine();
            System.out.print("Quantity: ");
            int quantity = s.nextInt();
            s.nextLine();
            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity,productPrice,product);
            order.addProduct(orderItem);
        }
        System.out.println(order);






    }
}