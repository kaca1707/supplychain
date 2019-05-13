package upm.softwaredesign.finalproject.viewmodel;

import java.util.UUID;

public class CreateOrderVm {

    private String product;
    private Integer count;
    private Integer sender;

    public UUID getId() {
        return orderId;
    }

    public void setId(UUID orderId) {
        this.orderId = orderId;
    }

    private UUID orderId;

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

    private Integer receiver;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
