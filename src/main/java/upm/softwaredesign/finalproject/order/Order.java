package upm.softwaredesign.finalproject.order;

import upm.softwaredesign.finalproject.model.ActorEntity;
import upm.softwaredesign.finalproject.model.Product;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

public class Order {

    private UUID id;

    private ActorEntity sender;

    private ActorEntity receiver;

    private Product product;

    private Date time;

    public Order() {

    }

    public Order(ActorEntity sender, ActorEntity receiver, Product product, Date time) {
        this.id = UUID.randomUUID();
        this.sender = sender;
        this.receiver = receiver;
        this.product = product;
        this.time = time;
    }

    public UUID getId() {
        return id;
    }

    public ActorEntity getSender() {
        return sender;
    }

    public ActorEntity getReceiver() {
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

    public void setSender(ActorEntity sender) {
        this.sender = sender;
    }

    public void setReceiver(ActorEntity receiver) {
        this.receiver = receiver;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
