package upm.softwaredesign.finalproject.order;

import org.springframework.format.annotation.DateTimeFormat;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Product;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

public class Order {

    public Order(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Actor sender;

    private Actor receiver;

    private Product product;

    @DateTimeFormat
    private Date time;

}
