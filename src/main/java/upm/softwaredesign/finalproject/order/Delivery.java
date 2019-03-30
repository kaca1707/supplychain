package upm.softwaredesign.finalproject.order;

import upm.softwaredesign.finalproject.model.ActorEntity;
import upm.softwaredesign.finalproject.model.ProductEntity;

import java.util.Date;
import java.util.UUID;

public class Delivery extends Order {

    public Delivery(ActorEntity sender, ActorEntity receiver, ProductEntity product, Date time) {
        super(sender, receiver, product, time);
    }
}
