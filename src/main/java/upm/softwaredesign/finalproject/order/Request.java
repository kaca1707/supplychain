package upm.softwaredesign.finalproject.order;

import java.util.Date;

import upm.softwaredesign.finalproject.model.ActorEntity;
import upm.softwaredesign.finalproject.model.Product;

public class Request extends Order {

    public Request(ActorEntity sender, ActorEntity receiver, Product product, Date time) {
        super(sender, receiver, product, time);
    }

}
