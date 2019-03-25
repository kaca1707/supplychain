package upm.softwaredesign.finalproject.order;

import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Product;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

public class Order {

    private UUID id;

    private Actor sender;

    private Actor receiver;

    private Product product;

    private Date time;

    public Order(){

    }

    public Order(UUID id, Actor sender, Actor receiver, Product product, Date time) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.product = product;
        this.time = time;
    }

    public UUID getId() {
        return id;
    }

    public Actor getSender() {
        return sender;
    }

    public Actor getReceiver() {
        return receiver;
    }

    public Product getProduct() {
        return product;
    }

    public Date getTime() {
        return time;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSender(Actor sender) {
        this.sender = sender;
    }

    public void setReceiver(Actor receiver) {
        this.receiver = receiver;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
