package upm.softwaredesign.finalproject.order;

import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Product;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

public class Order {

    private UUID id;

    private Actor sender;

    private Actor receiver;

    private Product product;

    private Date time;

    public Order(){

    }
}
