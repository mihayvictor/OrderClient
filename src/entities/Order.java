package org.example.entities;

import org.example.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    private Date moment;
    private OrderStatus status;
    private Client client;
    List <OrderItem> products = new ArrayList<>();

    public Order() {
    }

    public Order(OrderStatus status, Client client) {
        this.moment = new Date(Instant.now().toEpochMilli());
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addProduct(OrderItem product){
        products.add(product);
    }

    public void removeProduct(OrderItem product){
        products.remove(product);
    }

    public Double total(){
        Double total = 0.0;
        for (OrderItem p : products){
            total += p.subtotal();
        }
      return total;
    }


    @Override
    public String toString() {
        return "ORDER SUMMARY" + "\n" +
                "Order moment: " + sdf.format(moment) + "\n" +
                "Order status: " + status + "\n" +
                client.getName() + " (" +sdf2.format(client.getBirthDate()) + ")" + " - " + client.getEmail() + "\n" +
                "Order Itens: " + "\n" +
                products.toString() + "\n" +
                "Total price: " + String.format("$%.2f", total())
                ;
    }
}
