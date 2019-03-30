package upm.softwaredesign.finalproject.order;

import java.util.Date;

import upm.softwaredesign.finalproject.model.ActorEntity;
import upm.softwaredesign.finalproject.model.ProductEntity;

public class Request extends Order {

    public Request(ActorEntity sender, ActorEntity receiver, ProductEntity product, Date time) {
        super(sender, receiver, product, time);
    }

}
