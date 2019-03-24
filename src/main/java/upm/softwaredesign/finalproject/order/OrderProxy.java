package upm.softwaredesign.finalproject.order;

import upm.softwaredesign.finalproject.enums.TransactionStatus;

import java.util.Set;
import java.util.UUID;

public class OrderProxy {

    /*
    @return set of orders that are in a BlockChain
     */
    public Set<Order> consultChain(){
        //TODO
        return null;
    }

    /* Saves an order in the BlockChain
    @param transactionId: id  that links a maximum of 4 orders
    @param order: Request/Delivery that has to be added to a blockchain
     */
    public void saveOrder(Order order, UUID transactionId){
        //TODO
    }

    /* checks the status of a transaction:
        - Retailer Request
        - Factory Request/Delivery
        - Producer Delivery
    @param transactionId: id  that links a maximum of 4 orders
    @return the status of the transaction
     */
    public TransactionStatus status(UUID transactionId){
        //TODO
        return TransactionStatus.RETAILER_REQUEST;
    }
}
