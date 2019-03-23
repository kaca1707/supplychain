package upm.softwaredesign.finalproject.model;

import org.springframework.format.annotation.DateTimeFormat;

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
