package upm.softwaredesign.finalproject.viewmodel;

import upm.softwaredesign.finalproject.model.Product;
import upm.softwaredesign.finalproject.order.Order;

import java.util.UUID;

public class CreateRequestViewModel {
    private UUID id;
    private Integer sender;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Integer receiver;
    private String name;
    private Integer count;

}
