package upm.softwaredesign.finalproject.order;


import upm.softwaredesign.finalproject.blockchain.BlockChainFactory;
import upm.softwaredesign.finalproject.enums.TransactionStatus;

import java.util.*;
import upm.softwaredesign.finalproject.model.Actor;
import upm.softwaredesign.finalproject.model.Product;

public class OrderProxy {

    private final static OrderProxy instance = new OrderProxy();

    public static OrderProxy getInstance(){
        return instance;
    }

    /*
    @return arraylist of orders that are in the BlockChain
     */
    public ArrayList<Order> consultChain(){
        return BlockChainFactory.build().listOrders();
    }

    /* Saves an order in the BlockChain
     */


    public void saveOrder(Actor sender, Actor receiver, Product product, Date time){
        Order order = new Order(sender, receiver, product, time);
        BlockChainFactory.build().addOrder(order);
    }

    /* checks the status of a transaction:
        - Retailer Request
        - Factory Request/Delivery
        - Producer Delivery
    @param transactionGroupId: id  that links a maximum of 4 orders
    @return the status of the transaction
     */
    public TransactionStatus status(UUID transactionGroupId){
        return null;//BlockChainFactory.build().getTransactionGroupStatus(transactionGroupId);
    }
}
