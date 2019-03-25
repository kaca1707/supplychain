package upm.softwaredesign.finalproject.order;

import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Product;

import java.util.Date;
import java.util.UUID;

public class Delivery extends Order {

    public Delivery(UUID id, Actor sender, Actor receiver, Product product, Date time) {
        super(id, sender, receiver, product, time);
    }
}
