package upm.softwaredesign.finalproject.order;

import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Product;

import java.util.Date;
import java.util.UUID;

public class Order {

    private UUID id;

    private UUID transactionGroupId;

    private Actor sender;

    private Actor receiver;

    private Product product;

    private Date time;

    public Order(){

    }

    public Order(Actor sender, Actor receiver, Product product, Date time) {
        this.id = UUID.randomUUID();
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


    public UUID getTransactionGroupId() {
    return transactionGroupId;
  }

    public void setTransactionGroupId(UUID transactionGroupId) {
    this.transactionGroupId = transactionGroupId;
    }

}
