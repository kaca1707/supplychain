package upm.softwaredesign.finalproject.order;

import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Product;

import java.util.Date;
import java.util.UUID;

public class Request extends Order {
    public Request(UUID id, Actor sender, Actor receiver, Product product, Date time) {
        super(id, sender, receiver, product, time);
    }
}
