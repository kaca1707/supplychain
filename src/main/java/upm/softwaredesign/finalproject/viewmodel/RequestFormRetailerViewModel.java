package upm.softwaredesign.finalproject.viewmodel;

import java.util.UUID;

public class RequestFormRetailerViewModel {

    private Integer actorId;
    private Integer receiverId;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    private UUID orderId;

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }
}
