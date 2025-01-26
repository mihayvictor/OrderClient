package org.example.entities;

import org.example.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
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
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append(client.toString() + "\n");    
        sb.append("Order Itens: " + "\n");
        for (OrderItem p : products){
            sb.append(p + "\n");
        }
        sb.append("Total price: ");
        sb.append(String.format("$%.2f", total()));
        return sb.toString();
    }
}
